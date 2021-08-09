package com.ou.pokemondata.service;

import com.ou.pokemondata.controller.dto.LoginRequest;
import com.ou.pokemondata.controller.dto.RegisterRequest;
import com.ou.pokemondata.controller.dto.UserSummaryResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<?> loginUser(LoginRequest loginRequest);

    ResponseEntity<?> createUser(RegisterRequest registerRequest);

    ResponseEntity<?> checkToken(String token);

    UserSummaryResponse getCurrentUser(Long id, String username, String firstName, String lastName);
}
