package com.soniXchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.soniXchange.domain.PaymentMethod;
import com.soniXchange.domain.PaymentOrderStatus;
import com.soniXchange.model.PaymentOrder;
import com.soniXchange.model.User;
import com.soniXchange.repository.PaymentOrderRepository;
import com.soniXchange.response.PaymentResponse;

@Service
public class PaymentServiceImpl implements PaymentService{


    @Autowired
    private PaymentOrderRepository paymentOrderRepository;

    @Value("${stripe.api.key}") 
    private String stripeSecretKey;

    @Value("${razorpay.api.key}")
    private String apiKey;

    @Value("${razorpay.api.secret}")
    private String apiSecretKey;

    @Override
    public PaymentOrder createOrder(User user, Long amount, PaymentMethod paymentMethod) {
        PaymentOrder paymentOrder = new PaymentOrder();
        paymentOrder.setUser(user);
        paymentOrder.setAmount(amount);
        paymentOrder.setPaymentMethod(paymentMethod);

        return paymentOrderRepository.save(paymentOrder);
    }

    @Override
    public PaymentOrder getPaymentOrderById(Long id) throws Exception {
        return paymentOrderRepository.findById(id).orElseThrow(()-> new Exception("Payment Order not found"));
    }

    @Override
    public Boolean proceedPaymentOrder(PaymentOrder paymentOrder, String paymentId) {
        if(paymentOrder.getStatus().equals(PaymentOrderStatus.PENDING)){
            if()
        }
    }

    @Override
    public PaymentResponse createRazorpayPaymentLink(User user, Long amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createRazorpayPaymentLink'");
    }

    @Override
    public PaymentResponse createStripePaymentLink(User user, Long amount, Long orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createStripePaymentLink'");
    }
    
}
