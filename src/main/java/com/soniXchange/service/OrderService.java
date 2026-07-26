package com.soniXchange.service;

import java.util.List;

import com.soniXchange.domain.OrderType;
import com.soniXchange.model.Order;
import com.soniXchange.model.OrderItem;
import com.soniXchange.model.User;

public interface OrderService {

    Order createOrder(User user, OrderItem orderItem, OrderType orderType);

    Order getOrderById(Long orderId);

    List<Order> getAllOrdersOfUser(Long userId, OrderType orderType, String assetSymbol);
    
}
