package com.epam.esm.services.exceptions;

public class DaoNotFoundException extends RuntimeException {
  public DaoNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  @Override
  public String getMessage() {
    return String.format(
        "Certificate not found, because of: %s caused by %s which says: %s.",
        super.getMessage(), super.getCause().getClass().getName(), super.getCause().getMessage());
  }
}
