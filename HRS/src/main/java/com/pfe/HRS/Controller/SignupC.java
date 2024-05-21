package com.pfe.HRS.Controller;

import com.pfe.HRS.Dto.SignupRequest;
import com.pfe.HRS.Service.AuthS;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class SignupC {

    private final AuthS authS;

    @Autowired
    public SignupC(AuthS authS) {
        this.authS = authS;
    }

    @PostMapping
    public ResponseEntity<?> signupUser (@RequestBody SignupRequest signupRequest) throws MessagingException {
        boolean isUserCreated = authS.createUser(signupRequest);
        if (isUserCreated) {
            return ResponseEntity.status(HttpStatus.CREATED).body(isUserCreated);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create customer");
        }
    }

}