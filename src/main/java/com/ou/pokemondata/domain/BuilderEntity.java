package com.ou.pokemondata.domain;

import com.ou.pokemondata.domain.audit.UserDateAuditEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "builder")
public class BuilderEntity extends UserDateAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String builder;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    public BuilderEntity() {}

    private BuilderEntity(Long id, String builder, UserEntity user) {
        this.id = id;
        this.builder = builder;
        this.user = user;
    }

    public static BuilderEntityBuilder builder() {return new BuilderEntityBuilder();}

    public Long getId() {
        return id;
    }

    public String getBuilder() {
        return builder;
    }

    public UserEntity getUser() {return user;}

    public void setBuilder(String builder) {
        this.builder = builder;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof  BuilderEntity)) return false;
        return id != null && id.equals(((BuilderEntity) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public static class BuilderEntityBuilder {

        private Long id;
        private String builder;
        private UserEntity user;

        public BuilderEntityBuilder() {}

        public BuilderEntityBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public BuilderEntityBuilder builder(String builder) {
            this.builder = builder;
            return this;
        }

        public BuilderEntityBuilder user(UserEntity user) {
            this.user = user;
            return this;
        }

        public BuilderEntity build() { return new BuilderEntity(id, builder, user);}
    }
}
