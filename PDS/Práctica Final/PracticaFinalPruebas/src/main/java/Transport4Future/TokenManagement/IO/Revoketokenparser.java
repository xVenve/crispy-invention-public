package Transport4Future.TokenManagement.IO;

import java.util.HashMap;

import javax.json.JsonObject;

import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;

public class Revoketokenparser extends Jsonparser implements ITokenManagementParser
{

	public static final String TOKEN_VALUE = "Token Value";
	public static final String TYPE_OF_REVOCATION = "Type of revocation";
	public static final String REASON = "Reason";
	public static final String ERROR_INVALID_INPUT_DATA_IN_JSON_STRUCTURE = 
			"Error: invalid input data in JSON structure.";
	
	public HashMap<String, String> PARSE(String file_name) throws Tokenmanagementexception 
	{
		JsonObject myJSON = (JsonObject) super.PARSE(file_name);
		HashMap<String, String> items= new HashMap<String, String>();

		try {			
			items.put(TOKEN_VALUE, myJSON.getString(TOKEN_VALUE));
			items.put(TYPE_OF_REVOCATION, myJSON.getString(TYPE_OF_REVOCATION));
			items.put(REASON, myJSON.getString(REASON));		
		} catch (Exception exception) {
			throw new Tokenmanagementexception(ERROR_INVALID_INPUT_DATA_IN_JSON_STRUCTURE);
		}
		return items;
	}
	
}
