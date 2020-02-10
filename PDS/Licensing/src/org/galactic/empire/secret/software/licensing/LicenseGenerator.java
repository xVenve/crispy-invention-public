package org.galactic.empire.secret.software.licensing;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import org.galactic.empire.secret.software.exceptions.LicensingException;
import org.galactic.empire.secret.software.uuidgen.UUIDGenerator;

public class LicenseGenerator {
	private String stationName;
	private String signatureToken;

	public LicenseGenerator(String stationName) throws LicensingException {
		this.stationName = stationName;
		UUIDGenerator gen = new UUIDGenerator(this.stationName);
		signatureToken = gen.getSignatureToken();
	} 

	public License generateLicense(Date creationDate, Date expirationDate) throws LicensingException {
		License lic = new License(stationName);
		lic.setCreationDate(creationDate);
		lic.setExpirationDate(expirationDate);
		lic.setRevoked(false);
		lic = signLicense(lic, this.signatureToken);
		return lic;
	}

	private String getLicenseSignature(License lic, String signatureToken) throws LicensingException  {
		String dataToSign = lic.getStationName() + ";" + lic.getCreationDate() + ";" + lic.getExpirationDate() + ";" + lic.isRevoked();

		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			throw new LicensingException("Error: no such hashing algorithm.");
		}

		md.update(dataToSign.getBytes(StandardCharsets.UTF_8));
		byte[] digest = md.digest();

		String signature = String.format("%064x", new BigInteger(1, digest));

		return signature;
	}

	private License signLicense(License lic, String signatureToken) throws LicensingException {
		String signature = getLicenseSignature(lic, signatureToken);
		lic.setSignature(signature);
		return lic;
	}
}
