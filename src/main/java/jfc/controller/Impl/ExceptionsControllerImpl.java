package jfc.controller.Impl;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import jfc.controller.Interfaces.IExceptionController;
import jfc.exceptions.NoProductException;

import org.springframework.http.HttpStatus;

@ControllerAdvice
public class ExceptionsControllerImpl implements IExceptionController{
		  
	  @Override
	  @ResponseBody
	  @ExceptionHandler(NoProductException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  public String NoUserExceptionHandler(NoProductException ex) {
	    return ex.getMessage();
	  }
	  
	  
}
