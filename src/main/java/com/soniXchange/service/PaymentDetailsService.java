package com.soniXchange.service;

import com.soniXchange.model.PaymentDetails;
import com.soniXchange.model.User;

public interface PaymentDetailsService {

    public PaymentDetails addPaymentDetails(String accountNumber,
                                            String accountHolder,
                                            String ifsc, 
                                            String bankName,
                                            User user);

    public PaymentDetails getUsersPaymentDetails(User user);
    
}
