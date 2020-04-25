package Transport4Future.TokenManagement.IO;

import java.util.HashMap;

import javax.json.JsonObject;

import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;


public class Tokenparser extends Jsonparser 
{

	public static final String ERROR_INVALID_INPUT_DATA_IN_JSON_STRUCTURE = 
			"Error: invalid input data in JSON structure.";
	public static final String REQUEST_DATE = "Request Date";
	public static final String NOTIFICATION_E_MAIL = "Notification e-mail";
	public static final String TOKEN_REQUEST = "Token Request";

	public HashMap<String, String> PARSER(String file_name) throws Tokenmanagementexception 
	{
	JsonObject myJSON = this.JSON_FILE_PARSER(file_name);
	HashMap<String, String> items= new HashMap<String, String>();
	
	try {		
		items.put(TOKEN_REQUEST, myJSON.getString(TOKEN_REQUEST));
		items.put(NOTIFICATION_E_MAIL, myJSON.getString(NOTIFICATION_E_MAIL));
		items.put(REQUEST_DATE, myJSON.getString(REQUEST_DATE));				
	} catch (Exception exception) {
		throw new Tokenmanagementexception(ERROR_INVALID_INPUT_DATA_IN_JSON_STRUCTURE);
	}
	return items;
	}
}

