package com.renato.projects.metodopoliglota.domain;

import java.util.ArrayList;
import java.util.List;

import com.renato.projects.metodopoliglota.domain.enums.LanguageCode;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Language{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@EqualsAndHashCode.Include
private Long id;
private String nativeName;
private LanguageCode languageCode;

@OneToMany(mappedBy = "language", fetch = FetchType.LAZY)
private List<Deck> decks = new ArrayList<>();
}