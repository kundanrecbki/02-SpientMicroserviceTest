package com.sapient.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CompetetionsNotFoundException extends RuntimeException{
	public CompetetionsNotFoundException(String message) {
		super(message);
	}

}
