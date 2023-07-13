package com.epam.esm.restapp.exceptions;

import com.epam.esm.services.exceptions.MyException;

public class MyError {

  private final MyException myException;

  public MyError(MyException myException) {
    this.myException = myException;
  }

  public String getReason() {
    return this.myException.getReason();
  }
}
