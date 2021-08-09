package com.ou.pokemondata.controller;

import com.ou.pokemondata.controller.dto.UserSummaryResponse;
import com.ou.pokemondata.security.CurrentUser;
import com.ou.pokemondata.security.UserPrincipal;
import com.ou.pokemondata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    @PreAuthorize("hasRole('USER')")
    public UserSummaryResponse getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        return userService.getCurrentUser(
                currentUser.getId(),
                currentUser.getUsername(),
                currentUser.getFirstName(),
                currentUser.getLastName()
        );
    }
}
