package com.altir.onboarding.service.impl;

import com.altir.onboarding.config.UserDefaultConfigurations;
import com.altir.onboarding.model.User;
import com.altir.onboarding.model.enums.Role;
import com.altir.onboarding.model.enums.UserStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserNormalizationService {

    private final UserDefaultConfigurations defaultConfigurations;

    public void normalize(User user) {
        normalizeStatus(user);
        normalizeRole(user);
    }

    private void normalizeRole(User user) {
        if (user.getRole() == null) {
            user.setRole(Role.valueOf(defaultConfigurations.getRole()));
        }
    }

    private void normalizeStatus(User user) {
        if (user.getStatus() == null) {
            user.setStatus(UserStatus.valueOf(defaultConfigurations.getStatus()));
        }
    }
}
