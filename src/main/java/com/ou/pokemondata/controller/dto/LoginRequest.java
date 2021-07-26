package com.ou.pokemondata.controller.dto;

import javax.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank
    private final String usernameOrEmail;

    @NotBlank
    private final String password;

    private LoginRequest(String usernameOrEmail, String password) {
        this.usernameOrEmail = usernameOrEmail;
        this.password = password;
    }

    public static LoginRequestBuilder builder() {
        return new LoginRequestBuilder();
    }

    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public static class LoginRequestBuilder {

        private String usernameOrEmail;
        private String password;

        public LoginRequestBuilder() {
        }

        public LoginRequestBuilder usernameOrEmail(String usernameOrEmail) {
            this.usernameOrEmail = usernameOrEmail;
            return this;
        }

        public LoginRequestBuilder password(String password) {
            this.password = password;
            return this;
        }

        public LoginRequest build() {
            return new LoginRequest(usernameOrEmail, password);
        }
    }
}
