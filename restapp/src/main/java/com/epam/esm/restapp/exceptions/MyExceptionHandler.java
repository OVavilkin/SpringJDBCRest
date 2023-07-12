package com.epam.esm.restapp.exceptions;

import com.epam.esm.services.exceptions.DaoNotFoundException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

  private static final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

  @ExceptionHandler(DaoNotFoundException.class)
  public void handleDaoNotFoundException(HttpServletRequest request, Exception ex) {
    if (ex instanceof DaoNotFoundException) {
      logger.info(request.getRequestURL() + " not found: " + ex.getMessage());
    } else {
      logger.error("Not implemented: " + ex.getMessage());
    }
    // 404 since void method
  }
}
