package com.altir.onboarding.controller;

import com.altir.onboarding.api.onboarding.EnrollmentPostDTO;
import com.altir.onboarding.api.onboarding.EnrollmentResponseDTO;
import com.altir.onboarding.api.onboarding.OnboardingPostDTO;
import com.altir.onboarding.api.onboarding.OnboardingResponseDTO;
import com.altir.onboarding.mapper.OnboardingMapper;
import com.altir.onboarding.service.OnboardingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/onboarding")
@AllArgsConstructor
public class OnboardingController {

    private final OnboardingService onboardingService;
    private final OnboardingMapper onboardingMapper;


    @PostMapping("/create")
    public ResponseEntity<OnboardingResponseDTO> createOnboarding(@RequestBody OnboardingPostDTO postDTO) {
        return ResponseEntity.ok(
                onboardingMapper.toResponseDTO(
                        onboardingService.onboardingCreate(
                                onboardingMapper.toModel(postDTO))));
    }

    @PostMapping("/mfa/code")
    public ResponseEntity<EnrollmentResponseDTO> sendMfaCode(@RequestBody EnrollmentPostDTO postDTO) {
        //Todo need double check business requirements
        return new ResponseEntity<>(new EnrollmentResponseDTO(), HttpStatus.OK);
    }

}
