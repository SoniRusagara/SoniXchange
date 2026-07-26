package com.soniXchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soniXchange.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByUserId(Long userId);
    
}
