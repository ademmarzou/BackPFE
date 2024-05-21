package com.pfe.HRS.Controller;

import com.pfe.HRS.Dto.AuthoResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthoC {


    @GetMapping("/hello")
    public AuthoResponse hello () {
    return new AuthoResponse ("hello from Authorized API request") ;
    }
}
