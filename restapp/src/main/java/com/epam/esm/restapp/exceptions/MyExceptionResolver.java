package com.epam.esm.restapp.exceptions;

import com.epam.esm.services.exceptions.MyException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Component
public class MyExceptionResolver extends AbstractHandlerExceptionResolver {

  private static final Logger logger = LoggerFactory.getLogger(MyExceptionResolver.class);

  @Override
  protected ModelAndView doResolveException(
      HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
    if (ex instanceof MyException myException) {
      logger.warn("Exception: " + ex.getMessage());

      modelAndView.setStatus(HttpStatus.BAD_REQUEST);
      modelAndView.addObject("exception", new MyError(myException));
      return modelAndView;
    }

    String message = "Don't blame me, I'm a teapot!";
    logger.error(String.format("Something bad happened... [%s]\n...%s", ex.getMessage(), message));

    modelAndView.addObject("error", message);
    modelAndView.setStatus(HttpStatus.I_AM_A_TEAPOT);
    return modelAndView;
  }
}
