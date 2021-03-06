package com.webserviceproject.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(long id) {
		super("object not found " + id);
	}

}
