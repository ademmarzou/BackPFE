package com.pfe.HRS.Service;

import com.pfe.HRS.Repository.TokenRepo;
import com.pfe.HRS.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class Token {

    private final TokenRepo tokenRepo;
    private final UserRepo userRepo;


    @Autowired
    public Token(TokenRepo tokenRepo, UserRepo userRepo) {
        this.tokenRepo = tokenRepo;
        this.userRepo = userRepo;
    }

    public LocalDateTime getvalidateById(Integer id) {
        return tokenRepo.findById(id).map(token -> token.getValue()).orElse(null);
    }
}