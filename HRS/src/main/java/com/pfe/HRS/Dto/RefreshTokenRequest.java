package com.pfe.HRS.Dto;

import lombok.*;

@Getter
@Setter
public class RefreshTokenRequest {
    private String refreshToken ;
    public RefreshTokenRequest() {}

    public RefreshTokenRequest(String refreshToken) {
        this.refreshToken = refreshToken;
    }

}
