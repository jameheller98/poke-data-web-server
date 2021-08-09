package com.ou.pokemondata.controller;

import com.ou.pokemondata.controller.dto.LoginRequest;
import com.ou.pokemondata.controller.dto.RegisterRequest;
import com.ou.pokemondata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return userService.loginUser(loginRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        return userService.createUser(registerRequest);
    }

    @GetMapping("/check_token")
    public ResponseEntity<?> checkToken(@RequestParam(name = "token") String token) {
        return userService.checkToken(token);
    }
}
