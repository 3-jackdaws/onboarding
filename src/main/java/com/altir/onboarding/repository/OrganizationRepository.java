package com.altir.onboarding.repository;

import com.altir.onboarding.entity.OrganizationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrganizationRepository extends MongoRepository<OrganizationEntity, String> {
}
