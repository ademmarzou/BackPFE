package com.pfe.HRS.Service;

import com.pfe.HRS.Dto.SignupRequest;
import com.pfe.HRS.Model.User;
import jakarta.mail.MessagingException;

public interface AuthS {
    boolean createUser(SignupRequest signupRequest) throws MessagingException;
}
