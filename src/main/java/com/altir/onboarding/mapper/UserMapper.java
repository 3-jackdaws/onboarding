package com.altir.onboarding.mapper;

import com.altir.onboarding.api.user.UserPatchDTO;
import com.altir.onboarding.api.user.UserPostDTO;
import com.altir.onboarding.api.user.UserResponseDTO;
import com.altir.onboarding.entity.UserEntity;
import com.altir.onboarding.model.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    UserResponseDTO toResponseDTO(User user);

    User toModel(UserEntity entity);

    User toModel(UserPatchDTO patchDTO);

    UserEntity toEntity(User user);

    List<UserResponseDTO> toResponseDTOList(List<User> users);

    User toModel(UserPostDTO postDTO);

}
