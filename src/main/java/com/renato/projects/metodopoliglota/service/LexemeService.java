package com.renato.projects.metodopoliglota.service;

import java.util.Arrays;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.renato.projects.metodopoliglota.controller.dto.lexeme.PostLexemeDTO;
import com.renato.projects.metodopoliglota.controller.exceptionhandler.DeckNotFoundException;
import com.renato.projects.metodopoliglota.controller.exceptionhandler.LanguageNotFoundException;
import com.renato.projects.metodopoliglota.controller.exceptionhandler.LevelNotFoundException;
import com.renato.projects.metodopoliglota.domain.Deck;
import com.renato.projects.metodopoliglota.domain.DeckLexeme;
import com.renato.projects.metodopoliglota.domain.Language;
import com.renato.projects.metodopoliglota.domain.Level;
import com.renato.projects.metodopoliglota.domain.Lexeme;
import com.renato.projects.metodopoliglota.domain.LexemeLevel;
import com.renato.projects.metodopoliglota.domain.User;
import com.renato.projects.metodopoliglota.domain.UserDetailsImpl;
import com.renato.projects.metodopoliglota.repository.DeckLexemeRepository;
import com.renato.projects.metodopoliglota.repository.DeckRepository;
import com.renato.projects.metodopoliglota.repository.LanguageRepository;
import com.renato.projects.metodopoliglota.repository.LevelRepository;
import com.renato.projects.metodopoliglota.repository.LexemeLevelRepository;
import com.renato.projects.metodopoliglota.repository.LexemeRepository;

import jakarta.transaction.Transactional;

@Service
public class LexemeService {

	private final DeckRepository deckRepository;
	private final LanguageRepository languageRepository;
	private final LevelRepository levelRepository;
	private final LexemeLevelRepository lexemeLevelRepository;
	private final LexemeRepository lexemeRepository;
	private final DeckLexemeRepository deckLexemeRepository;
	
	public LexemeService(DeckRepository deckRepository, LanguageRepository languageRepository,
			LevelRepository levelRepository, LexemeLevelRepository lexemeLevelRepository,
			LexemeRepository lexemeRepository, DeckLexemeRepository deckLexemeRepository) {
		super();
		this.deckRepository = deckRepository;
		this.languageRepository = languageRepository;
		this.levelRepository = levelRepository;
		this.lexemeLevelRepository = lexemeLevelRepository;
		this.lexemeRepository = lexemeRepository;
		this.deckLexemeRepository = deckLexemeRepository;
	}

	@Transactional
	public Lexeme saveDeck(PostLexemeDTO postLexemeDTO) {
		Deck deck;
		if (postLexemeDTO.deckId() == null) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
			User user = principal.getUser();
			Language language = languageRepository.findByLanguageCode(postLexemeDTO.newDeck().language())
					.orElseThrow(() -> new LanguageNotFoundException(postLexemeDTO.newDeck().language()));
			deck = new Deck(language, postLexemeDTO.newDeck().name(), postLexemeDTO.newDeck().description(), user);
			deckRepository.save(deck);
		} else {
			deck = deckRepository.findById(postLexemeDTO.deckId())
					.orElseThrow(() -> new DeckNotFoundException(postLexemeDTO.deckId()));
		}
		
		Level level = levelRepository.findByLevelCode(postLexemeDTO.level())
				.orElseThrow(() -> new LevelNotFoundException(postLexemeDTO.level()));

		Lexeme lexeme = new Lexeme(postLexemeDTO.lexeme(), postLexemeDTO.description());
		lexemeRepository.save(lexeme);
		
		LexemeLevel lexemeLevel = new LexemeLevel(lexeme, level);
		lexemeLevelRepository.save(lexemeLevel);

		DeckLexeme deckLexeme = new DeckLexeme(deck, lexeme);
		deckLexemeRepository.save(deckLexeme);
		
		lexeme.setLexemeLevel(Arrays.asList(lexemeLevel));
		lexeme.setDeckLexeme(Arrays.asList(deckLexeme));
		
		return lexeme;
	}

	public void deleteLexeme(Long id) {
		lexemeRepository.deleteById(id);
	}

}
