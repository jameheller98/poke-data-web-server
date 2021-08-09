package com.ou.pokemondata.controller.dto;

public class ValidResponse {
    private final Boolean valid;
    private final String message;

    private ValidResponse(Boolean valid, String message) {
        this.valid = valid;
        this.message = message;
    }

    public static ValidResponseBuilder builder() {
        return new ValidResponse.ValidResponseBuilder();
    }

    public Boolean getValid() {
        return valid;
    }

    public String getMessage() {
        return message;
    }

    public static class ValidResponseBuilder {

        private Boolean valid;
        private String message;

        public ValidResponseBuilder valid(Boolean valid) {
            this.valid = valid;
            return this;
        }

        public ValidResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ValidResponse build() {
            return new ValidResponse(valid, message);
        }
    }
}
