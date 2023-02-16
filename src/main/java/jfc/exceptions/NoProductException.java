package jfc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import jfc.commons.Constants;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = Constants.NO_PRODUCT_EXCEPTION_MESSAGE)
public class NoProductException extends Exception{

	private static final long serialVersionUID = 1L;

    public NoProductException(String errorMessage) {
        super(errorMessage);
    }
}
