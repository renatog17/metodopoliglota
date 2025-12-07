package com.renato.projects.metodopoliglota.domain;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Deck {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	private LocalDateTime createdAt;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "language_id") 
	private Language language;
	private String name;
	private String description;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id") 
	private User user;
	@OneToMany(mappedBy = "deck", fetch = FetchType.LAZY)
	private List<DeckLexeme> deckLexeme;
	
	public Deck(Language language, String name, String description, User user) {
		super();
		this.createdAt = LocalDateTime.now();
		this.language = language;
		this.name = name;
		this.description = description;
		this.user = user;
	}
	
	
}