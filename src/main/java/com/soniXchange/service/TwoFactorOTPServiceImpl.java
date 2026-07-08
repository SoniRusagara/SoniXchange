package com.soniXchange.service;

import com.soniXchange.model.TwoFactorOTP;
import com.soniXchange.model.User;

public class TwoFactorOTPServiceImpl implements TwoFactorOTPService{

    @Override
    public TwoFactorOTP createTwoFactorOTP(User user, String otp, String jwt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createTwoFactorOTP'");
    }

    @Override
    public TwoFactorOTP findByUser(Long userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByUser'");
    }

    @Override
    public TwoFactorOTP findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean verifyTwoFactorOtp(TwoFactorOTP twoFactorOtp, String otp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verifyTwoFactorOtp'");
    }

    @Override
    public void deleteTwoFactorOtp(TwoFactorOTP twoFactorOtp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteTwoFactorOtp'");
    }
    
}
