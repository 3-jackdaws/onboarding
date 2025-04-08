package com.altir.onboarding.api.user;

import com.altir.onboarding.entity.Role;
import com.altir.onboarding.entity.UserStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserPatchDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private UserStatus status;
    private Role role;
    private String organizationId;
}
