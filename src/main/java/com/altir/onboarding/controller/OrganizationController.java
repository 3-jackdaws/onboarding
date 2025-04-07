package com.altir.onboarding.controller;

import com.altir.onboarding.api.organization.OrganizationPatchDTO;
import com.altir.onboarding.api.organization.OrganizationPostDTO;
import com.altir.onboarding.api.organization.OrganizationResponseDTO;
import com.altir.onboarding.mapper.OrganizationMapper;
import com.altir.onboarding.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizations")
@AllArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;
    private final OrganizationMapper organizationMapper;

    @GetMapping
    public ResponseEntity<List<OrganizationResponseDTO>> getOrganizations(String accountName, String federalEin) {
        return ResponseEntity.ok(
                organizationMapper.toResponseDTOList(
                        organizationService.getOrganizations(accountName, federalEin)));
    }

    @PostMapping
    public ResponseEntity<OrganizationResponseDTO> createOrganization(@RequestBody OrganizationPostDTO postDTO) {
        return ResponseEntity.ok(
                organizationMapper.toResponseDTO(
                        organizationService.createOrganization(
                                organizationMapper.toModel(postDTO))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable String id) {
        organizationService.deleteOrganization(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationResponseDTO> getOrganizationById(@PathVariable String id) {
        return ResponseEntity.ok(
                organizationMapper.toResponseDTO(
                        organizationService.getOrganizationById(id)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OrganizationResponseDTO> updateOrganization(@PathVariable String id, @RequestBody OrganizationPatchDTO patchDTO) {
        return ResponseEntity.ok(
                organizationMapper.toResponseDTO(
                        organizationService.patchOrganization(id, organizationMapper.toModel(patchDTO))));
    }

}
