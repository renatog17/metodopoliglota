package com.renato.projects.metodopoliglota.domain;

import java.time.LocalDateTime;
import java.util.List;

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
public class Lexeme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	private LocalDateTime createdAt;
	private String lexeme;
	private String description;
	@OneToMany(mappedBy = "lexeme", fetch = FetchType.LAZY)
	private List<LexemeLevel> lexemeLevel;
	@OneToMany(mappedBy = "lexeme", fetch = FetchType.LAZY)
	private List<DeckLexeme> deckLexeme;
}