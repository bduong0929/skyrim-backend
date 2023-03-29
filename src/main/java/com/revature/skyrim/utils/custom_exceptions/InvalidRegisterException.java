package com.revature.skyrim.utils.custom_exceptions;

public class InvalidRegisterException extends RuntimeException {

  public InvalidRegisterException() {
  }

  public InvalidRegisterException(String message) {
    super(message);
  }

  public InvalidRegisterException(Throwable cause) {
    super(cause);
  }

  public InvalidRegisterException(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidRegisterException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
