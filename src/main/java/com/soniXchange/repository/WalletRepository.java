package com.soniXchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soniXchange.model.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long>{

    Wallet findByUserId(Long userId);
    
}
