package com.pfe.HRS.Service;

import com.pfe.HRS.Dto.SignupRequest;
import com.pfe.HRS.Model.User;
import com.pfe.HRS.Repository.TokenRepo;
import com.pfe.HRS.Repository.UserRepo;

import com.pfe.HRS.email.EmailService;
import com.pfe.HRS.email.EmailTemplateName;
import jakarta.mail.MessagingException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;


@Service
public class AuthSImpl implements AuthS {
    private final UserRepo userRepo ;
    private final TokenRepo tokenRepo ;

    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder ;

    private final String activationUrl = "http://localhost:4200/activate-account";


    @Autowired
    public AuthSImpl(UserRepo userRepo, TokenRepo tokenRepo, EmailService emailService, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.tokenRepo = tokenRepo;
        this.emailService = emailService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean createUser(SignupRequest signupRequest) throws MessagingException {
        if (userRepo.existsByEmail(signupRequest.getEmail())){
            return false;
        }

        User user = new User();
        BeanUtils.copyProperties(signupRequest,user);

        //hash the password before saving
        String hashPassword = passwordEncoder.encode(signupRequest.getPassword());
        user.setPassword(hashPassword);
        userRepo.save(user);
        sendValidationEmail(user);
        return true;
    }

    private String generateAndSaveActivationToken(User user) {
        // Generate a token
        String generatedToken = generateActivationCode(6);
        var token = TokenS.builder()
                .token(generatedToken)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(15))
                .user(user)
                .build();
        tokenRepo.save(token);

        return generatedToken;
    }



    private void sendValidationEmail(User user) throws MessagingException {
        var newToken = generateAndSaveActivationToken(user);

        emailService.sendEmail(
                user.getEmail(),
                user.getUsername(),
                EmailTemplateName.ACTIVATE_ACCOUNT,
                activationUrl,
                newToken,
                "Account activation"
        );
    }
    private String generateActivationCode(int length) {
        String characters = "0123456789";
        StringBuilder codeBuilder = new StringBuilder();

        SecureRandom secureRandom = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(characters.length());
            codeBuilder.append(characters.charAt(randomIndex));
        }

        return codeBuilder.toString();
    }
    public void activateAccount(String token) throws MessagingException {
        System.out.println("activateAccount method called with token: " + token);

        TokenS savedToken;
        savedToken = tokenRepo.findByToken(token).orElseThrow(()-> new RuntimeException("saved token invalid "));

        if (LocalDateTime.now().isAfter(savedToken.getExpiresAt())) {
            sendValidationEmail(savedToken.getUser());
            throw new RuntimeException("Activation token has expired. A new token has been send to the same email address");
        }
        System.out.println("activateAccount method called with token: " + savedToken);

        var user = userRepo.findById(savedToken.getUser().getId())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        userRepo.save(user);

        savedToken.setValidatedAt(LocalDateTime.now());
        tokenRepo.save(savedToken);
    }



}