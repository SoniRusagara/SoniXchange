package com.soniXchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soniXchange.model.VerificationCode;

public interface VerificationCodeRepository extends JpaRepository<VerificationCode, Long>{

    public VerificationCode findByUserId(Long userId);
    
}
