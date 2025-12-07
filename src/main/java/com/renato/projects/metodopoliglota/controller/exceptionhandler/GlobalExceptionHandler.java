package com.renato.projects.metodopoliglota.controller.exceptionhandler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<ApiError>> handleValidationExceptions(MethodArgumentNotValidException ex,
			HttpServletRequest request) {

		List<ApiError> errors = ex.getBindingResult().getFieldErrors().stream()
				.map(err -> new ApiError(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
						err.getDefaultMessage(), err.getField(), request.getRequestURI()))
				.collect(Collectors.toList());

		return ResponseEntity.badRequest().body(errors);
	}

	@ExceptionHandler(DeckNotFoundException.class)
	public ResponseEntity<ApiError> handleDeckNotFoundException(DeckNotFoundException ex, HttpServletRequest request) {
		ApiError error = new ApiError(HttpStatus.NOT_FOUND.value(), "Not Found", ex.getMessage(), "deckId",
				request.getRequestURI());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(LanguageNotFoundException.class)
	public ResponseEntity<ApiError> handleLanguageNotFoundException(LanguageNotFoundException ex, HttpServletRequest request) {
		ApiError error = new ApiError(HttpStatus.NOT_FOUND.value(), "Not Found", ex.getMessage(), "language code",
				request.getRequestURI());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(LevelNotFoundException.class)
	public ResponseEntity<ApiError> handleLevelNotFoundException(LevelNotFoundException ex, HttpServletRequest request) {
		ApiError error = new ApiError(HttpStatus.NOT_FOUND.value(), "Not Found", ex.getMessage(), "level code",
				request.getRequestURI());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

}
