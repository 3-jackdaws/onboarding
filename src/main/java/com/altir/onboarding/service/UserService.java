package com.altir.onboarding.service;

import com.altir.onboarding.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User createUser(User user);

    void deleteUser(String id);
}
