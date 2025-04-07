package com.altir.onboarding.mapper;

import com.altir.onboarding.api.organization.OrganizationPatchDTO;
import com.altir.onboarding.api.organization.OrganizationPostDTO;
import com.altir.onboarding.api.organization.OrganizationResponseDTO;
import com.altir.onboarding.entity.OrganizationEntity;
import com.altir.onboarding.model.Organization;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OrganizationMapper {

    OrganizationResponseDTO toResponseDTO(Organization organization);

    Organization toModel(OrganizationEntity entity);

    Organization toModel(OrganizationPatchDTO patchDTO);

    OrganizationEntity toEntity(Organization organization);

    List<OrganizationResponseDTO> toResponseDTOList(List<Organization> organizations);

    Organization toModel(OrganizationPostDTO postDTO);
}
