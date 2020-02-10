package org.galactic.empire.secret.software.exceptions;

public class LicensingException extends Exception {

	private static final long serialVersionUID = 1L;
	String message;

	public LicensingException(String message) {

		this.message = message;
	}

	public String getMessage() {

		return this.message;
	}

}
