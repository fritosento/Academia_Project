package com.Academia.project.Handle;

import com.Academia.project.Exeption.IllegalEX;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleGlobalEx {

    @ExceptionHandler
    public ResponseEntity<String> IllegalArgsExeption(IllegalEX e) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());  
    }
}
