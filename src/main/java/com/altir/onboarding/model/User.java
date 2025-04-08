package com.altir.onboarding.model;

import com.altir.onboarding.entity.Role;
import com.altir.onboarding.entity.UserStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {

    private String id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private UserStatus status;
    private Role role;
    private String organizationId;

    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime updatedDate;
    private String updatedBy;
}
