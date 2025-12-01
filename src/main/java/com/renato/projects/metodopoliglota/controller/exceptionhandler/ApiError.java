package com.renato.projects.metodopoliglota.controller.exceptionhandler;

import java.time.LocalDateTime;

public record ApiError(
        LocalDateTime timestamp,
        int status,
        String error,
        String message,
        String field,
        String path
) {
    public ApiError(int status, String error, String message, String field, String path) {
        this(LocalDateTime.now(), status, error, message, field, path);
    }
}