package com.renato.projects.metodopoliglota.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.renato.projects.metodopoliglota.controller.dto.user.PostUserDTO;
import com.renato.projects.metodopoliglota.domain.User;
import com.renato.projects.metodopoliglota.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder encoder;

	public UserService(UserRepository userRepository, PasswordEncoder encoder) {
		super();
		this.encoder = encoder;
		this.userRepository = userRepository;
	}

	public User save(PostUserDTO postUserDTO) {
		User user = new User();
		user.setEmail(postUserDTO.email());
		user.setName(postUserDTO.name());
		user.setPassword(encoder.encode(postUserDTO.password()));
		return userRepository.save(user);
	}
	
	
}
