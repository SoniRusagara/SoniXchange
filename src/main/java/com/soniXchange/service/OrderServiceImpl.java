package com.soniXchange.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.soniXchange.domain.OrderType;
import com.soniXchange.model.Coin;
import com.soniXchange.model.Order;
import com.soniXchange.model.OrderItem;
import com.soniXchange.model.User;

@Service
public class OrderServiceImpl implements OrderService{

    @Override
    public Order createOrder(User user, OrderItem orderItem, OrderType orderType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createOrder'");
    }

    @Override
    public Order getOrderById(Long orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrderById'");
    }

    @Override
    public List<Order> getAllOrdersOfUser(Long userId, OrderType orderType, String assetSymbol) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllOrdersOfUser'");
    }

    @Override
    public Order processOrder(Coin coin, double quantity, OrderType orderType, User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processOrder'");
    }
    
}
