package com.pfe.HRS.Controller;


import com.pfe.HRS.Service.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class TokenC {
    private final Token token;

    @Autowired
    public TokenC(Token token) {
        this.token = token;
    }

    @GetMapping("/validate/{id}")
    public LocalDateTime getvalidateById(@PathVariable Integer id) {
        return token.getvalidateById(id);
    }
}