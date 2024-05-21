package com.pfe.HRS.Controller;


import com.pfe.HRS.Service.AuthSImpl;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AaccountC {

   private final AuthSImpl authS;

    @GetMapping("/activate-account")
    public void confirm(@RequestParam String token) throws MessagingException {
        authS.activateAccount(token);
    }


}