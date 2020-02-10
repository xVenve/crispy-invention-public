package org.galactic.empire.secret.software.licensing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.stream.JsonGenerator;

import org.galactic.empire.secret.software.exceptions.LicensingException;

public class LicenseManager {

	public static boolean isLicenseValid(License lic) {
		// Check expiration

		// Check signature

		return false;
	}

	public static License revokeLicense(License lic) {
		// Set expiration to false and sign the license again

		return lic;
	}

	public static License readLicenseFromJSON(String path) throws LicensingException {
		License lic = null;

		String fileContents = "";

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			throw new LicensingException("Error: input file not found.");
		}
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				fileContents += line;
			}
		} catch (IOException e) {
			throw new LicensingException("Error: input file could not be accessed.");
		}
		try {
			reader.close();
		} catch (IOException e) {
			throw new LicensingException("Error: input file could not be closed.");
		}

		JsonObject jsonLicense = Json.createReader(new StringReader(fileContents)).readObject();

		
		// Check that only mandatory fields. TO-DO !!!
		/*
		try {
			// COMPLETE

		} catch (ParseException pe) {
			throw new LicensingException("Error: invalid fields in file.");
		}
		*/
		
		
		// Initialize license
		DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);

		try {
			String stationName = jsonLicense.getString("Station name");
			Date creationDate = df.parse(jsonLicense.getString("Creation date"));
			Date expirationDate = df.parse(jsonLicense.getString("Expiration date"));
			boolean revoked = Boolean.parseBoolean(jsonLicense.getString("Revoked"));
			String signature = jsonLicense.getString("Signature");

			lic = new License(stationName, creationDate, expirationDate, revoked, signature);
		} catch (ParseException pe) {
			throw new LicensingException("Error: invalid input data in JSON structure.");
		}

		return lic;
	}

	public static void writeLicensetoJSON(License lic) throws LicensingException {
		try {
			LinkedHashMap<String, String> values = new LinkedHashMap<String, String>(5, 10, false);
			values.put("Station name", lic.getStationName());
			values.put("Creation date", lic.getCreationDate().toString());
			values.put("Expiration date", lic.getExpirationDate().toString());
			values.put("Revoked", String.valueOf(lic.isRevoked()));
			values.put("Signature", lic.getSignature());

			String path = lic.getStationName() + "-lic.json";
			FileWriter fw = new FileWriter(path);

			JsonGenerator gen = Json.createGenerator(fw);
			JsonGenerator mainObj = gen.writeStartObject();

			// And here is how we traverse the LinkedHashMap, writing the pairs into JSON
			for (Map.Entry<String, String> entry : values.entrySet()) {
				mainObj.write(entry.getKey(), entry.getValue());
			}

			mainObj.writeEnd();
			gen.close();

		} catch (Exception e) {
			throw new LicensingException("Error: writing license as JSON object.");
		}
	}
}
