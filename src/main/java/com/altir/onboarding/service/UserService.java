package com.altir.onboarding.service;

import com.altir.onboarding.model.User;

import java.util.List;

public interface UserService {

    User getUserById(String id);

    List<User> getUsers(String firstName, String lastName);

    User createUser(User user);

    void deleteUser(String id);

    User patchUser(String id, User user);
}
