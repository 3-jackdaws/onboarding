package com.altir.onboarding.repository;

import com.altir.onboarding.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<UserEntity, String> {

    List<UserEntity> findAllByEmail(String email);
}
