package com.pfe.HRS.Dto;

import lombok.*;
@Getter
@Setter
public class LoginResponse {
    private String  id;
    private String jwtToken;
    private String accountType;

    public LoginResponse(String jwtToken, String accountType , String id) {
        this.jwtToken = jwtToken;
        this.accountType = accountType;
        this.id = id ;
    }

}