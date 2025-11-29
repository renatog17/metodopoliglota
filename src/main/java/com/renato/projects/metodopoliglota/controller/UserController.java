package com.renato.projects.metodopoliglota.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.renato.projects.metodopoliglota.controller.dto.user.PostUserDTO;
import com.renato.projects.metodopoliglota.domain.User;
import com.renato.projects.metodopoliglota.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<?> postUser(@RequestBody PostUserDTO postUserDTO, UriComponentsBuilder uriComponentsBuilder){
		User user = userService.save(postUserDTO);
		URI uri = uriComponentsBuilder
				.path("/user/{id}")
				.buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(uri).body(user);
	}
}
