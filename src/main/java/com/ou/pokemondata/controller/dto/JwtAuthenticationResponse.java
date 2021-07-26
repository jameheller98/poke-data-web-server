package com.ou.pokemondata.controller.dto;

public class JwtAuthenticationResponse {

    private final String accessToken;
    private final String tokenType;

    private JwtAuthenticationResponse(String accessToken, String tokenType) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
    }

    public static JwtAuthenticationResponseBuilder builder() {
        return new JwtAuthenticationResponseBuilder();
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public static class JwtAuthenticationResponseBuilder {

        private String accessToken;
        private String tokenType = "Bearer";

        public JwtAuthenticationResponseBuilder() {
        }

        public JwtAuthenticationResponseBuilder accessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        public JwtAuthenticationResponseBuilder tokenType(String tokenType) {
            this.tokenType = tokenType;
            return this;
        }

        public JwtAuthenticationResponse build() {
            return new JwtAuthenticationResponse(accessToken, tokenType);
        }
    }
}
