package com.altir.onboarding.repository;

import com.altir.onboarding.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity, String> {

    //  /organizations/234234/users?firstName=Oleg
}
