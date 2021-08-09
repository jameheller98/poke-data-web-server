package com.ou.pokemondata.controller.dto;

public class UserSummaryResponse {
    private final Long id;
    private final String username;
    private final String firstName;
    private final String lastName;

    private UserSummaryResponse(Long id, String username, String firstName, String lastName) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static UserSummaryResponseBuilder builder() {
        return new UserSummaryResponseBuilder();
    }

    public static class UserSummaryResponseBuilder {
        private Long id;
        private String username;
        private String firstName;
        private String lastName;

        public UserSummaryResponseBuilder() {}

        public UserSummaryResponseBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UserSummaryResponseBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserSummaryResponseBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserSummaryResponseBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserSummaryResponse build() {
            return new UserSummaryResponse(id, username, firstName, lastName);
        }
    }
}
