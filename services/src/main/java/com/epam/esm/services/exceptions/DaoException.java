package com.epam.esm.services.exceptions;

import java.util.Objects;

public class DaoException extends RuntimeException implements MyException {

  public DaoException(String message, Throwable exception) {
    super(message, exception);
  }

  public DaoException(String message) {
    super(message);
  }

  @Override
  public String getReason() {
    return String.format(
        "\"%s\", caused by: %s",
        this.getMessage(),
        Objects.isNull(this.getCause()) ? this.getCause().getClass().getName() : "self");
  }
}
