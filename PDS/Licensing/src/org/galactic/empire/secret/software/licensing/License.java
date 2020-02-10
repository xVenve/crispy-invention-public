package org.galactic.empire.secret.software.licensing;

import java.util.Calendar;
import java.util.Date;

public class License {
	private String stationName;
	private Date creationDate;
	private Date expirationDate;
	private boolean revoked;
	private String signature;


	/*
	 * Creates a default license for 1 year since today (NOT SIGNED)
	 */
	public License(String stationName) {
		this.stationName = stationName;

		// Get "today" and set it to creation date
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		this.creationDate = cal.getTime();

		// Add one year and set it to expiration date
		cal.add(Calendar.YEAR, 1);
		this.expirationDate = cal.getTime();

		this.revoked = false;

	}

	/*
	 * Creates a default license, requesting all parameters
	 */
	public License(String stationName, Date creationDate, Date expirationDate, boolean revoked, String signature) {
		this.stationName = stationName;
		this.creationDate = creationDate;
		this.expirationDate = expirationDate;
		this.revoked = revoked;
		this.signature = signature;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public boolean isRevoked() {
		return revoked;
	}

	public void setRevoked(boolean revoked) {
		this.revoked = revoked;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	@Override
	public String toString() {
		return "License [\n\tstationName=" + stationName + ",\n\tcreationDate=" + creationDate + ",\n\texpirationDate="
				+ expirationDate + ",\n\trevoked=" + revoked + ",\n\tsignature=" + signature + "\n]";
	}

}
