package com.ou.pokemondata.mapper;

import com.ou.pokemondata.controller.dto.BuilderRequest;
import com.ou.pokemondata.controller.dto.BuilderResponse;
import com.ou.pokemondata.domain.BuilderEntity;
import com.ou.pokemondata.domain.UserEntity;
import com.ou.pokemondata.repository.UserRepository;
import com.ou.pokemondata.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BuilderMapper {
    @Autowired
    private UserRepository userRepository;

    public BuilderEntity toBuilderEntity(BuilderRequest builderRequest) {
        Optional<UserEntity> userEntity = userRepository.findByUsername(builderRequest.getUser());

        if(userEntity.isPresent()) {
            BuilderEntity builderEntity = BuilderEntity.builder()
                    .builder(builderRequest.getBuilder())
                    .build();
            userEntity.get().addBuilder(builderEntity);
            return builderEntity;
        }

        return new BuilderEntity();
    }

    public BuilderResponse toBuilderResponse(BuilderEntity builderEntity) {
        return BuilderResponse.builder()
                .id(builderEntity.getId())
                .builder(builderEntity.getBuilder())
                .user(builderEntity.getUser().getUsername())
                .build();
    }
}
