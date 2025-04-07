package com.altir.onboarding.api.user;

import com.altir.onboarding.entity.Role;
import com.altir.onboarding.entity.UserStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserPatchDTO {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String email;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private UserStatus status;
    @NotBlank
    private Role role;
}
