package com.renato.projects.metodopoliglota.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renato.projects.metodopoliglota.domain.Language;
import com.renato.projects.metodopoliglota.domain.enums.LanguageCode;

public interface LanguageRepository extends JpaRepository<Language, Long>{

	Optional <Language> findByLanguageCode(LanguageCode languageCode);

}
