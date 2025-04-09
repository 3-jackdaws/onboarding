package com.altir.onboarding.entity;

import com.altir.onboarding.model.enums.Role;
import com.altir.onboarding.model.enums.UserStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Document(collection = "users")
public class UserEntity {

    @Id
    private String id = UUID.randomUUID().toString();

    @NotBlank
    private String organizationId;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String email;
    @NotBlank
    private UserStatus status;
    @NotBlank
    private Role role;

    @CreatedDate
    private LocalDateTime createdDate;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private LocalDateTime updatedDate;
    @LastModifiedBy
    private String updatedBy;
}
