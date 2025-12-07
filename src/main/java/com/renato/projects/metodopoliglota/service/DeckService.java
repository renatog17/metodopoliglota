package com.renato.projects.metodopoliglota.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.renato.projects.metodopoliglota.controller.dto.deck.ReadDeckDTO;
import com.renato.projects.metodopoliglota.controller.dto.language.ReadLanguageDTO;
import com.renato.projects.metodopoliglota.controller.dto.lexeme.ReadLexemeDTO;
import com.renato.projects.metodopoliglota.domain.Deck;
import com.renato.projects.metodopoliglota.domain.Lexeme;
import com.renato.projects.metodopoliglota.domain.User;
import com.renato.projects.metodopoliglota.domain.UserDetailsImpl;
import com.renato.projects.metodopoliglota.domain.enums.LevelCode;
import com.renato.projects.metodopoliglota.repository.DeckRepository;

@Service
public class DeckService {

	private final DeckRepository deckRepository;

	public DeckService(DeckRepository deckRepository) {
		super();
		this.deckRepository = deckRepository;
	}
	
	public List<ReadDeckDTO> getDecksByAuthenticatedUser(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
		User user = principal.getUser();
		
		List<Deck> decks = deckRepository.findDeckByUser(user);
		List<ReadDeckDTO> deckDTOs = decks.stream()
			    .map(deck -> new ReadDeckDTO(
			        deck.getId(),
			        deck.getCreatedAt(),
			        new ReadLanguageDTO(deck.getLanguage()),
			        deck.getName(),
			        deck.getDescription(),
			        deck.getDeckLexeme().stream()
			            .map(dl -> {
			                Lexeme l = dl.getLexeme();
			                List<LevelCode> levels = l.getLexemeLevel().stream()
			                        .map(ll -> ll.getLevel().getLevelCode())
			                        .toList();
			                return new ReadLexemeDTO(
			                    l.getId(),
			                    l.getLexeme(),
			                    l.getDescription(),
			                    levels
			                );
			            })
			            .toList()
			    ))
			    .toList();
		return deckDTOs;
	}
}
