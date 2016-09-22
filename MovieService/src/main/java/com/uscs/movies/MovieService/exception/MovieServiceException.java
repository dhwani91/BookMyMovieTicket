package com.uscs.movies.MovieService.exception;

@SuppressWarnings("serial")
public class MovieServiceException extends Exception {
	private ErrorCode errorCode;

	public MovieServiceException(ErrorCode code, String message, Throwable throwable) {
		super(message, throwable);
		this.errorCode = code;
	}

	public MovieServiceException(ErrorCode code, String message) {
		super(message);
		this.errorCode = code;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

}
