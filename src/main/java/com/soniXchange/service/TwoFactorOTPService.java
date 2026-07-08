package com.soniXchange.service;

import com.soniXchange.model.TwoFactorOTP;
import com.soniXchange.model.User;

public interface TwoFactorOTPService {
    
    TwoFactorOTP createTwoFactorOTP(User user, String otp, String jwt);

    TwoFactorOTP findByUser(Long userId);

    TwoFactorOTP findById(String id);

    boolean verifyTwoFactorOtp(TwoFactorOTP twoFactorOtp, String otp);

    void deleteTwoFactorOtp(TwoFactorOTP twoFactorOtp);
}
