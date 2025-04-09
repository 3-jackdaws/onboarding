package com.altir.onboarding.api.user;

import com.altir.onboarding.model.enums.Role;
import com.altir.onboarding.model.enums.UserStatus;
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
