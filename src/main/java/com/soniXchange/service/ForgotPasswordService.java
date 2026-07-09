package com.soniXchange.service;

import com.soniXchange.domain.VerificationType;
import com.soniXchange.model.ForgotPasswordToken;
import com.soniXchange.model.User;

public interface ForgotPasswordService {

    ForgotPasswordToken createToken(
        User user, 
        String id, 
        String otp, 
        VerificationType verificationType, 
        String sendTo
    );

    ForgotPasswordToken findById(String id);

    ForgotPasswordToken findByUser(Long userId);

    void deleteToken(ForgotPasswordToken token);
    
}
