package com.altir.onboarding.controller;

import com.altir.onboarding.entity.User;
import com.altir.onboarding.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
