package com.soniXchange.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.soniXchange.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUserId(Long userId);
    
}
