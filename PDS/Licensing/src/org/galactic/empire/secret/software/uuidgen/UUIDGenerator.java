package org.galactic.empire.secret.software.uuidgen;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.galactic.empire.secret.software.exceptions.LicensingException;

/*
 * Authors: Galen Erso and Lisardo Prieto
 * Version: 1.0
 * Spoiler at: https://youtu.be/f3ddCAtapYE
 **/

public class UUIDGenerator {

	private String secretSalt = "Stardust";
	private String signature;

	public UUIDGenerator(String stationName) {
		this.signature = stationName;
	}

	public String getSignatureToken() throws LicensingException {
		// Let's trick those bad guys. MD5 instead of SHA-512
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new LicensingException("Error: no such hashing algorithm.");
		}
		
		String input =  secretSalt + "-" + signature;
		
		md.update(input.getBytes(StandardCharsets.UTF_8));
		byte[] digest = md.digest();

		String hex = String.format("%064x", new BigInteger(1, digest));

		return hex;
	}

}
