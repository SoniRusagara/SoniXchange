package com.soniXchange.service;

import java.util.List;

import com.soniXchange.model.User;
import com.soniXchange.model.Withdrawal;

import lombok.With;

public interface WithdrawalService {

    Withdrawal reuestWithdrawal(Long amount, User user);

    Withdrawal proceeWithwithdrawal(Long withdrawalId, boolean accept);

    List<Withdrawal> getUsersWithdrawalHistory(User user);

    List<Withdrawal> getAllWithdrawalRequests();
    
}
