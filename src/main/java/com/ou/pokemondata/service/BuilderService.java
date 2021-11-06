package com.ou.pokemondata.service;

import com.ou.pokemondata.controller.dto.BuilderRequest;
import com.ou.pokemondata.controller.dto.BuilderResponse;
import com.ou.pokemondata.domain.BuilderEntity;

import java.util.List;

public interface BuilderService {
    List<BuilderResponse> getBuilder(Long id);
    BuilderResponse createBuilder(BuilderRequest builderRequest);
    BuilderEntity updateBuilder(Long id, BuilderRequest builderRequest);
    void deleteBuilder(Long id);
}
