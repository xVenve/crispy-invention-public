package Transport4Future.TokenManagement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;

import javax.json.Json;
import javax.json.JsonObject;


public class Tokenmanager 
{

	public Tokenrequest READ_TOKEN_REQUEST_FROM_JSON(String path) 
			throws Tokenmanagementexception
	{
		Tokenrequest req = null;
		String file_contents = "";
		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			throw new Tokenmanagementexception("Error: input file not found.");
		}
		
		String line;
		try {
			while ((line = reader.readLine()) != null) 
			{
				file_contents += line;
			}
		} catch (IOException e) {
			throw new Tokenmanagementexception
			("Error: input file could not be accessed.");
		}
		try {
			reader.close();
		} catch (IOException e) {
			throw new Tokenmanagementexception
			("Error: input file could not be closed.");
		}
		
		JsonObject json_license = Json.createReader
				(new StringReader(file_contents)).readObject();
		DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
		
		try {
			String device_name = json_license.getString("Device Name");
			Date request_date = df.parse(json_license.getString("Request Date"));
			String serial_number = json_license.getString("Serial Number");
			String mac_address = json_license.getString("MAC Address");
			req=new Tokenrequest(device_name, request_date, serial_number, mac_address);
			
		} catch (ParseException pe) {
			throw new Tokenmanagementexception
			("Error: invalid input data in JSON structure.");
		}
		return req;
	}
}
