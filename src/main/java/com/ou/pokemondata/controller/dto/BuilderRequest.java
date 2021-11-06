package com.ou.pokemondata.controller.dto;

import com.ou.pokemondata.domain.BuilderEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class BuilderRequest {
    @NotBlank
    private String builder;

    @NotBlank
    @NotEmpty
    private String user;

    public String getBuilder() {
        return builder;
    }

    public String getUser() { return user; }

    public BuilderRequest() {}

    private BuilderRequest(String builder, String user) {
        this.builder = builder;
        this.user = user;
    }

    public static BuilderRequestBuilder builder() { return new BuilderRequestBuilder();}

    public static class BuilderRequestBuilder {

        private String builder;

        private String user;

        public BuilderRequestBuilder () {}

        public BuilderRequestBuilder builder(String builder) {
            this.builder = builder;
            return this;
        }

        public BuilderRequestBuilder user(String user) {
            this.user = user;
            return this;
        }

        public BuilderRequest build() { return new BuilderRequest(builder, user);}
    }
}
