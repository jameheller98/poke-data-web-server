package com.ou.pokemondata.controller.dto;

public class BuilderResponse {
    private Long id;
    private String builder;
    private String user;

    public Long getId() {
        return id;
    }

    public String getBuilder() {
        return builder;
    }

    public String getUser() {
        return user;
    }

    public BuilderResponse() {}

    private BuilderResponse(Long id, String builder, String user) {
        this.id = id;
        this.builder = builder;
        this.user = user;
    }

    public static BuilderResponseBuilder builder() {return new BuilderResponseBuilder();}

    public static class BuilderResponseBuilder {
        private Long id;
        private String builder;
        private String user;

        public BuilderResponseBuilder () {}

        public BuilderResponseBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public BuilderResponseBuilder builder(String builder) {
            this.builder = builder;
            return this;
        }

        public BuilderResponseBuilder user(String user) {
            this.user = user;
            return this;
        }

        public BuilderResponse build() { return new BuilderResponse(id, builder, user);}
    }
}
