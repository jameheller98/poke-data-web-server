package com.ou.pokemondata.controller;

import com.ou.pokemondata.controller.dto.BuilderRequest;
import com.ou.pokemondata.controller.dto.BuilderResponse;
import com.ou.pokemondata.mapper.BuilderMapper;
import com.ou.pokemondata.repository.BuilderRepository;
import com.ou.pokemondata.service.BuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/builder")
public class BuilderController {
    private BuilderRepository builderRepository;
    private BuilderService builderService;
    private BuilderMapper builderMapper;

    @Autowired
    public BuilderController(BuilderRepository builderRepository, BuilderService builderService, BuilderMapper builderMapper) {
        this.builderRepository = builderRepository;
        this.builderService = builderService;
        this.builderMapper = builderMapper;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public List<BuilderResponse> getBuilder(@PathVariable Long id) {
        return builderService.getBuilder(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public BuilderResponse createBuilder(@Valid @RequestBody BuilderRequest builderRequest) {
        return builderService.createBuilder(builderRequest);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public BuilderResponse updateBuilder(@PathVariable Long id, @Valid @RequestBody BuilderRequest builderRequest) {
        return builderMapper.toBuilderResponse(builderService.updateBuilder(id, builderRequest));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> deleteBuilder(@PathVariable Long id) {
        builderService.deleteBuilder(id);
        return ResponseEntity.ok("Delete success!");
    }
}
