
package com.pfe.HRS.Controller;

import com.pfe.HRS.Dto.LoginRequest;
import com.pfe.HRS.Dto.LoginResponse;
import com.pfe.HRS.Model.User;
import com.pfe.HRS.Repository.TokenRepo;
import com.pfe.HRS.Repository.UserRepo;
import com.pfe.HRS.Service.AuthSImpl;
import com.pfe.HRS.Service.TokenS;
import com.pfe.HRS.Service.jwt.UserSImpl;
import com.pfe.HRS.utils.JwtUtil;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/login")
public class LoginC {

    private final AuthenticationManager authenticationManager;

    private final UserSImpl userSI;
    private final AuthSImpl authS;
    private final JwtUtil jwtUtil;
    private final UserRepo userRepo;
    private final TokenRepo tokenRepo;
    private User user ;


    @Autowired
    public LoginC(AuthenticationManager authenticationManager, UserSImpl userSI, AuthSImpl authS, JwtUtil jwtUtil, UserRepo userRepo, TokenRepo tokenRepo) {
        this.authenticationManager = authenticationManager;
        this.userSI = userSI;
        this.authS = authS;
        this.jwtUtil = jwtUtil;
        this.userRepo = userRepo;
        this.tokenRepo = tokenRepo;
    }

    @PostMapping
    public LoginResponse login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) throws IOException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Incorrect email or password.");
        } catch (DisabledException disabledException) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Customer is not activated");
            return null;
        }
        final UserDetails userDetails = userSI.loadUserByUsername(loginRequest.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        Optional<User> userOptional = userRepo.findByEmail(loginRequest.getEmail());

        if (userOptional.isPresent() ) {
            user = userOptional.get();
            Optional<TokenS> tokenOptional = tokenRepo.findByUserId(user.getId());

            TokenS token = tokenOptional.get();
            String id = String.valueOf(token.getId());

            String accountType = user.getAccountType();


            return new LoginResponse(jwt, accountType, id);


        } else {
            System.out.println(("error test loginc"));
            return new LoginResponse(jwt, null, null);

        }

    }

}