package com.ou.pokemondata.domain;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "role")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private RoleName name;

    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> users = new HashSet<>();

    public RoleEntity() {
    }

    private RoleEntity(Long id, RoleName name, Set<UserEntity> users) {
        this.name = name;
        this.users = users;
        this.id = id;
    }

    public static RoleEntityBuilder builder() {
        return new RoleEntityBuilder();
    }

    public Long getId() {
        return id;
    }

    public RoleName getName() {
        return name;
    }

    public Set<UserEntity> getUsers() {
        return users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity role = (RoleEntity) o;
        return Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public static class RoleEntityBuilder {
        private Long id;
        private RoleName name;
        private Set<UserEntity> users = new HashSet<>();

        public RoleEntityBuilder() {
        }

        public RoleEntityBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public RoleEntityBuilder name(RoleName name) {
            this.name = name;
            return this;
        }

        public RoleEntityBuilder users(Set<UserEntity> users) {
            this.users = users;
            return this;
        }

        public RoleEntity build() {
            return new RoleEntity(id, name, users);
        }
    }
}
