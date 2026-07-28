package com.soniXchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soniXchange.model.PaymentOrder;

public interface PaymentOrderRepository extends JpaRepository<PaymentOrder, Long> {
    
}
