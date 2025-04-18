package com.altir.onboarding.api.user;

import com.altir.onboarding.model.enums.Role;
import com.altir.onboarding.model.enums.UserStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserPostDTO {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String email;
    @NotBlank
    private String phoneNumber;

    private String organizationId;
    private UserStatus status;
    private Role role;
}
