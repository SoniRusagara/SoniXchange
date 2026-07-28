package com.soniXchange.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soniXchange.model.User;
import com.soniXchange.model.Withdrawal;
import com.soniXchange.repository.WithdrawalRepository;

@Service
public class WithdrawalServiceImpl implements WithdrawalService{

    @Autowired
    private WithdrawalRepository withdrawalRepository;

    

    @Override
    public Withdrawal reuestWithdrawal(Long amount, User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reuestWithdrawal'");
    }

    @Override
    public Withdrawal proceeWithwithdrawal(Long withdrawalId, boolean accept) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'proceeWithwithdrawal'");
    }

    @Override
    public List<Withdrawal> getUsersWithdrawalHistory(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsersWithdrawalHistory'");
    }

    @Override
    public List<Withdrawal> getAllWithdrawalRequests() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllWithdrawalRequests'");
    }
    
}
