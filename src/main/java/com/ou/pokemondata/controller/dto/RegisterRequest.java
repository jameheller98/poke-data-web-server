package com.ou.pokemondata.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegisterRequest {

    @NotBlank
    @Size(min = 4, max = 20)
    private final String firstName;

    @NotBlank
    @Size(min = 4, max = 20)
    private final String lastName;

    @NotBlank
    @Size(min = 3, max = 15)
    private final String username;

    @NotBlank
    @Size(max = 40)
    @Email
    private final String email;

    @NotBlank
    @Size(min = 6, max = 20)
    private final String password;

    private RegisterRequest(String firstName, String lastName, String username, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public static RegisterRequestBuilder builder() {
        return new RegisterRequestBuilder();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static class RegisterRequestBuilder {

        private String firstName;
        private String lastName;
        private String username;
        private String email;
        private String password;

        public RegisterRequestBuilder() {
        }

        public RegisterRequestBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public RegisterRequestBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public RegisterRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        public RegisterRequestBuilder email(String email) {
            this.email = email;
            return this;
        }

        public RegisterRequestBuilder password(String password) {
            this.password = password;
            return this;
        }

        public RegisterRequest build() {
            return new RegisterRequest(firstName, lastName, username, email, password);
        }
    }
}
