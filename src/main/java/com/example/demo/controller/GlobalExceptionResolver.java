package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionResolver {

  @ExceptionHandler
  public ResponseEntity<String> handleNotAuthorizedException(NotAuthorizedException ex) {
    return ResponseEntity.status(401).body("Not Authorized: " + ex.getMessage());
  }

  @ExceptionHandler
  public ResponseEntity<String> handleNoAccessException(NoAccessException ex) {
    return ResponseEntity.status(403).body("Access Denied: " + ex.getMessage());
  }
}
