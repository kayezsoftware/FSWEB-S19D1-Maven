package com.workintech.s18d2.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// README: Global bir merkezden yönetilmeli
@Slf4j // README: @Slf4j hata olduğunda servera log düşürülmelidir
@ControllerAdvice
public class GlobalExceptionHandler {

    // README: Beklenmeyen hataları handle edebilmeli
    @ExceptionHandler(PlantException.class)
    public ResponseEntity<ErrorResponse> handlePlantException(PlantException ex) {
        log.error("PlantException: {}", ex.getMessage());
        ErrorResponse response = new ErrorResponse(ex.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, ex.getStatus());
    }

    // README: Tüm hataları handle edebilecek global sistem
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        log.error("General Exception: {}", ex.getMessage());
        ErrorResponse response = new ErrorResponse("An unexpected error occurred: " + ex.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
