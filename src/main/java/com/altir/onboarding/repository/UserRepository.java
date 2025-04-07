package com.altir.onboarding.repository;

import com.altir.onboarding.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
