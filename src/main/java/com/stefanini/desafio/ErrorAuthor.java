package com.stefanini.desafio;

public class ErrorAuthor extends RuntimeException {

  public ErrorAuthor(String message) {
    super(message);
  }

  public ErrorAuthor(String message, Throwable cause) {
    super(message, cause);
  }

}
