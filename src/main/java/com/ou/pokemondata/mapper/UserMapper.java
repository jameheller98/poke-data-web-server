package com.ou.pokemondata.mapper;

import com.ou.pokemondata.controller.dto.*;
import com.ou.pokemondata.domain.RoleEntity;
import com.ou.pokemondata.domain.RoleName;
import com.ou.pokemondata.domain.UserEntity;
import com.ou.pokemondata.exception.AppException;
import com.ou.pokemondata.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public UserMapper(PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public ApiResponse toApiResponse(Boolean success, String message) {
        return ApiResponse.builder()
                .success(success)
                .message(message)
                .build();
    }

    public ValidResponse toValidResponse(Boolean valid, String message) {
        return ValidResponse.builder()
                .valid(valid)
                .message(message)
                .build();
    }

    public JwtAuthenticationResponse toJwtAuthenticationResponse(String jwt) {
        return JwtAuthenticationResponse.builder().accessToken(jwt).build();
    }

    public UserSummaryResponse toUserSummaryResponse(Long id, String username, String firstName, String lastName) {
        return UserSummaryResponse.builder()
                .id(id)
                .username(username)
                .firstName(firstName)
                .lastName(lastName)
                .build();
    }

    public UserEntity toEntity(RegisterRequest registerRequest) {
        /* SET ADMIN
            RoleEntity adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                .orElseThrow(() -> new AppException("Admin Role not set!"));
        */

        RoleEntity userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new AppException("User Role not set!"));

        return UserEntity.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .username(registerRequest.getUsername())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .build()
                .addRole(userRole);
    }
}
