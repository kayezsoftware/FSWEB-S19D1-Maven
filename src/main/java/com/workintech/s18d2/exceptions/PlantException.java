package com.workintech.s18d2.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

// README: Global hata yönetimi
@Getter
public class PlantException extends RuntimeException {
    private final HttpStatus status;

    public PlantException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}