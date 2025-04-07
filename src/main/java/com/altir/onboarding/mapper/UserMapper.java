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

    User toModel(UserEntity userEntity);

    User toModel(UserPatchDTO userEntity);

    UserEntity toUserEntity(User user);

    List<UserResponseDTO> toUserResponseDTOList(List<User> userList);

    User toModel(UserPostDTO userPostDTO);

}
