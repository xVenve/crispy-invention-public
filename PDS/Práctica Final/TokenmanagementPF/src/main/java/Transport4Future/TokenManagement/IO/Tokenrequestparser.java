package Transport4Future.TokenManagement.IO;

import java.util.HashMap;

import javax.json.JsonObject;

import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;

public class Tokenrequestparser extends Jsonparser implements ITokenManagementParser
{
	public static final String MAC_ADDRESS = "MAC Address";
	public static final String SERIAL_NUMBER = "Serial Number";
	public static final String SUPPORT_E_MAIL = "Support e-mail";
	public static final String DRIVER_VERSION = "Driver Version";
	public static final String TYPE_OF_DEVICE = "Type of Device";
	public static final String DEVICE_NAME = "Device Name";
	public static final String ERROR_INVALID_INPUT_DATA_IN_JSON_STRUCTURE = 
			"Error: invalid input data in JSON structure.";

	public HashMap<String, String> PARSE(String file_name) throws Tokenmanagementexception 
	{
		JsonObject myJSON = (JsonObject) super.PARSE(file_name);
		HashMap<String, String> items= new HashMap<String, String>();

		try {			
			items.put(DEVICE_NAME, myJSON.getString(DEVICE_NAME));
			items.put(TYPE_OF_DEVICE, myJSON.getString(TYPE_OF_DEVICE));
			items.put(DRIVER_VERSION, myJSON.getString(DRIVER_VERSION));
			items.put(SUPPORT_E_MAIL, myJSON.getString(SUPPORT_E_MAIL));
			items.put(SERIAL_NUMBER, myJSON.getString(SERIAL_NUMBER));
			items.put(MAC_ADDRESS, myJSON.getString(MAC_ADDRESS));		
		} catch (Exception exception) {
			throw new Tokenmanagementexception(ERROR_INVALID_INPUT_DATA_IN_JSON_STRUCTURE);
		}
		
	return items;
	}
}
