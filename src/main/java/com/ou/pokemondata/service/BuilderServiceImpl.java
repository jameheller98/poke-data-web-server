package com.ou.pokemondata.service;

import com.ou.pokemondata.controller.dto.BuilderRequest;
import com.ou.pokemondata.controller.dto.BuilderResponse;
import com.ou.pokemondata.domain.BuilderEntity;
import com.ou.pokemondata.domain.UserEntity;
import com.ou.pokemondata.mapper.BuilderMapper;
import com.ou.pokemondata.repository.BuilderRepository;
import com.ou.pokemondata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BuilderServiceImpl implements BuilderService {

    private final BuilderMapper builderMapper;
    private final BuilderRepository builderRepository;
    private final UserRepository userRepository;

    @Autowired
    public BuilderServiceImpl(BuilderMapper builderMapper, BuilderRepository builderRepository, UserRepository userRepository) {
        this.builderMapper = builderMapper;
        this.builderRepository = builderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<BuilderResponse> getBuilder(Long id) {
        return builderRepository.findByIdUser(id).stream().map(builderMapper::toBuilderResponse).collect(Collectors.toList());
    }

    @Override
    public BuilderResponse createBuilder(BuilderRequest builderRequest) {
        Optional<UserEntity> userEntity = userRepository.findByUsername(builderRequest.getUser());
        List<BuilderEntity> listBuilderEntity = builderRepository.findByIdUser(userEntity.get().getId());
        if(listBuilderEntity.size() < 3) {
            BuilderEntity builder = builderMapper.toBuilderEntity(builderRequest);
            builderRepository.save(builder);
            return builderMapper.toBuilderResponse(builder);
        }
       return null;
    }

    @Override
    public BuilderEntity updateBuilder(Long id, BuilderRequest builderRequest) {
        Optional<BuilderEntity> builderEntity = builderRepository.findById(id);

        if (builderEntity.isPresent()) {
            BuilderEntity builderEntityValue = builderEntity.get();
            builderEntityValue.setBuilder(builderRequest.getBuilder());
            return builderRepository.save(builderEntityValue);
        }

        return new BuilderEntity();
    }

    @Override
    public void deleteBuilder(Long id) {
        builderRepository.deleteById(id);
    }
}
