package com.soniXchange.service;

import com.soniXchange.domain.VerificationType;
import com.soniXchange.model.User;
import com.soniXchange.model.VerificationCode;

public interface VerificationCodeService {

    VerificationCode sendVerificationCode(User user, VerificationType verificationType);

    VerificationCode getVerificationCodeById(Long id) throws Exception;

    VerificationCode getVerificationCodeByUser(Long userId);

    void deleteVerificationCodeById(VerificationCode verificationCode);
    
}
