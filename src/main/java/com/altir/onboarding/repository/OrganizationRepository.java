package com.altir.onboarding.repository;

import com.altir.onboarding.entity.OrganizationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface OrganizationRepository extends MongoRepository<OrganizationEntity, String> {

    Optional<List<OrganizationEntity>> findAllByAccountNameAndFederalEin(String accountName, String federalEin);
}
