package com.ou.pokemondata.controller.dto;

public class ApiResponse {

    private final Boolean success;
    private final String message;

    private ApiResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public static ApiResponseBuilder builder() {
        return new ApiResponseBuilder();
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public static class ApiResponseBuilder {

        private Boolean success;
        private String message;

        public ApiResponseBuilder success(Boolean success) {
            this.success = success;
            return this;
        }

        public ApiResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ApiResponse build() {
            return new ApiResponse(success, message);
        }
    }
}
