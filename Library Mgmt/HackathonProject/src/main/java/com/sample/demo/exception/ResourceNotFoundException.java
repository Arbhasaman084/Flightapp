package com.sample.demo.exception;

public class ResourceNotFoundException extends Exception{

	private static final long serialVersionUID = -5557689037685584988L;

	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
