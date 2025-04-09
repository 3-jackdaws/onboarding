package com.altir.onboarding.api.user;

import com.altir.onboarding.model.enums.Role;
import com.altir.onboarding.model.enums.UserStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponseDTO {

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
