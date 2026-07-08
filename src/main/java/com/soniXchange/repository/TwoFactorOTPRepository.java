package com.soniXchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soniXchange.model.TwoFactorOTP;

public interface TwoFactorOTPRepository extends JpaRepository<TwoFactorOTP, String>{
    TwoFactorOTP findByUserId(Long userId);
    
}
