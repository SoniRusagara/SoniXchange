package com.soniXchange.service;

import com.soniXchange.domain.PaymentMethod;
import com.soniXchange.model.PaymentOrder;
import com.soniXchange.model.User;
import com.soniXchange.response.PaymentResponse;

public interface PaymentService {

    PaymentOrder createOrder(User user, Long amount, PaymentMethod paymentMethod);

    PaymentOrder getPaymentOrderById(Long id) throws Exception;

    Boolean proceedPaymentOrder(PaymentOrder paymentOrder, String paymentId);

    PaymentResponse createRazorpayPaymentLink(User user, Long amount);

    // For international transactions 
    PaymentResponse createStripePaymentLink(User user, Long amount, Long orderId);

}
