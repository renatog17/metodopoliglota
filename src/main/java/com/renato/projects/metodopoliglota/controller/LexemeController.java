package com.renato.projects.metodopoliglota.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renato.projects.metodopoliglota.controller.dto.lexeme.PostLexemeDTO;
import com.renato.projects.metodopoliglota.service.LexemeService;

@RequestMapping("/lexemes")
@RestController
public class LexemeController {

	private final LexemeService lexemeService;

	public LexemeController(LexemeService lexemeService) {
		super();
		this.lexemeService = lexemeService;
	}

	@PostMapping
	public ResponseEntity<?> postLexeme(@RequestBody PostLexemeDTO postLexemeDTO){
		lexemeService.saveDeck(postLexemeDTO);
		return ResponseEntity.ok().build();
	}
}
