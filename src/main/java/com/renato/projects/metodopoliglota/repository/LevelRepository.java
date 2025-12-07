package com.renato.projects.metodopoliglota.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renato.projects.metodopoliglota.domain.Level;
import com.renato.projects.metodopoliglota.domain.enums.LevelCode;

public interface LevelRepository extends JpaRepository<Level, Long>{

	Optional <Level> findByLevelCode(LevelCode levelCode);

}
