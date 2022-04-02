package com.example.demo.controller;

public class NoAccessException extends RuntimeException {

  public NoAccessException(String message) {
    super(message);
  }
}
