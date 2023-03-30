package com.revature.skyrim.utils.custom_exceptions;

public class InvalidTokenException extends RuntimeException {

  public InvalidTokenException() {
  }

  public InvalidTokenException(String message) {
    super(message);
  }

  public InvalidTokenException(Throwable cause) {
    super(cause);
  }

  public InvalidTokenException(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidTokenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
