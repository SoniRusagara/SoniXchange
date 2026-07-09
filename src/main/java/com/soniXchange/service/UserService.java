package com.soniXchange.service;

import com.soniXchange.model.User;

public interface UserService {

    public User findUserProfileByJwt(String jwt);
    public User findUserByEmail(String email);
    public User findUserById(Long userId);

    public User enableTwoFactorAuthentication(User user);

    User updatePassword(User user, String newPassword);

}
