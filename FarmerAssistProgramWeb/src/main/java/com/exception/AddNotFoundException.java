package com.exception;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class AddNotFoundException extends RuntimeException {

	public AddNotFoundException(String message) {
		super(message);
	}
}
