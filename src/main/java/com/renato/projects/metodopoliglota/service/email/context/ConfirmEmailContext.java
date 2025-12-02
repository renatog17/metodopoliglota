package com.renato.projects.metodopoliglota.service.email.context;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ConfirmEmailContext {

	private String verificationToken;
	private String email;
	private String name;
	
}
