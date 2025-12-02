package com.renato.projects.metodopoliglota.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class ConfirmEmailController {

	@GetMapping("/confirm")
	public ResponseEntity<?> confirmEmail(){
		return null;
	}
	
	@PostMapping("/resend")
	public ResponseEntity<?> resendLink(){
		return null;
	}
	
//	@Transactional
//	@GetMapping("/confirm")
//	public ResponseEntity<String> confirmEmail(@RequestParam String token) {
//	    Optional<User> optionalUser = userRepository.findByVerificationToken(token);
//	        
//	    if(optionalUser.isEmpty())
//	    	return ResponseEntity.badRequest().body("Token inválido");
//	    
//	    User user = optionalUser.get();
//	    
//	    if (user.getTokenExpiry().isBefore(Instant.now())) {
//	        return ResponseEntity.badRequest().body("Token expirado");
//	    }
//
//	    user.setVerified(true);
//	    user.setVerificationToken(null);
//	    user.setTokenExpiry(null);
//	    userRepository.save(user);
//
//	    return ResponseEntity.ok("Email confirmado com sucesso!");
//	}
}
