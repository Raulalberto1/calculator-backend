package com.api.backend.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ ArithmeticException.class })
    public ResponseEntity<Object> handleGlobalException(ArithmeticException exception) {

        CustomError error = new CustomError();
        error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setMsg(exception.getLocalizedMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(error);
    }

}
