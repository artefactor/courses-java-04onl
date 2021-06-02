package com.example.servlet.repository;

/**
 * должно быть extends Exception
 * TODO заменить на Exception и показать что нужно будет сделать при этом
 */
public class DaoException extends RuntimeException {
	public DaoException() {
	}

	public DaoException(Throwable cause) {
		super(cause);
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}
}
