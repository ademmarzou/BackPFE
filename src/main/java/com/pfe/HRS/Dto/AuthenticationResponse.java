package com.pfe.HRS.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
public class AuthenticationResponse {

    private String jwt;

    private String refresh_token ;


    public AuthenticationResponse() {}

    public AuthenticationResponse(String jwt) {
            this.jwt = jwt;
        }

    }

