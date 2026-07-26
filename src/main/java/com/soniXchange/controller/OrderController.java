package com.soniXchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soniXchange.model.Coin;
import com.soniXchange.model.Order;
import com.soniXchange.model.User;
import com.soniXchange.model.WalletTransaction;
import com.soniXchange.service.CoinService;
import com.soniXchange.service.OrderService;
import com.soniXchange.service.UserService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    private UserService userService;

    @Autowired
    private CoinService coinService;

    // @Autowired
    // private WalletTransactionService WalletTransactionService;

    // Private

    @PostMapping("/pay")
    public ResponseEntity<Order> payOrderPayment(
        @RequestHeader("Authorization") String jwt,
        @RequestBody CreateOrderRequest req
    ) throws Exception{
        User user = userService.findUserProfileByJwt(jwt);
        Coin coin = coinService.findById(req.getCoinId());

        Order order = orderService.processOrder(coin, req.getQuantity(), req.getOrderType())
    }
    
}
