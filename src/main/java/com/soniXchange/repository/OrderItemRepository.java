package com.soniXchange.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.soniXchange.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    
}
