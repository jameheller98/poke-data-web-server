package com.ou.pokemondata.repository;

import com.ou.pokemondata.domain.BuilderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BuilderRepository extends JpaRepository<BuilderEntity, Long> {
    @Query("SELECT builder from BuilderEntity builder where builder.createdBy = ?1")
    List<BuilderEntity> findByIdUser(Long userId);

    Optional<BuilderEntity> findById(Long builderId);

    long countByCreatedBy(Long userId);

    List<BuilderEntity> findByIdIn(List<Long> builderIds);

    List<BuilderEntity> findByIdIn(List<Long> builderIds, Sort sort);
}
