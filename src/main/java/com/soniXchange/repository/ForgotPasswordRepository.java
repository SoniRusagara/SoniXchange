package com.soniXchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soniXchange.model.ForgotPasswordToken;

public interface ForgotPasswordRepository extends JpaRepository<ForgotPasswordToken, Long> {

    ForgotPasswordToken findByUserId(Long userId);

    
} 
