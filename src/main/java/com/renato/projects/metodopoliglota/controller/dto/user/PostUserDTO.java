package com.renato.projects.metodopoliglota.controller.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PostUserDTO(
		@NotBlank(message = "Email is mandatory.")
		@Email(message = "Email must follow a valid email format")
		String email, 
		@NotBlank(message = "Password is mandatory")
		@Size(min = 8, max = 16)
		String password) {
}
