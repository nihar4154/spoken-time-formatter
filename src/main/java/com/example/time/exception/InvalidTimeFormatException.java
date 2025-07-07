package com.example.time.exception;

public class InvalidTimeFormatException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public InvalidTimeFormatException(String message) {
    super(message);
  }

  public InvalidTimeFormatException(String message, Throwable cause) {
    super(message, cause);
  }
}
