package com.altir.onboarding.controller;

import com.altir.onboarding.api.user.UserPatchDTO;
import com.altir.onboarding.api.user.UserPostDTO;
import com.altir.onboarding.api.user.UserResponseDTO;
import com.altir.onboarding.mapper.UserMapper;
import com.altir.onboarding.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getUsers(String firstName, String lastName) {
        userService.getUsers(firstName, lastName);
        return ResponseEntity.ok(
                userMapper.toUserResponseDTOList(
                        userService.getUsers(firstName, lastName)));
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserPostDTO user) {
        return ResponseEntity.ok(
                userMapper.toResponseDTO(
                        userService.createUser(
                                userMapper.toModel(user))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(
                userMapper.toResponseDTO(
                        userService.getUserById(id)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDTO> patchUserById(
            @PathVariable String id, @RequestBody UserPatchDTO userPatchDTO) {
        return ResponseEntity.ok(
                userMapper.toResponseDTO(
                        userService.patchUser(id, userMapper.toModel(userPatchDTO))));
    }
}
