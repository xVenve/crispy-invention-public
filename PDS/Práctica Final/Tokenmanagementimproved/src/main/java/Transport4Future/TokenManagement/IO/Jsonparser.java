package Transport4Future.TokenManagement.IO;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;

import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;

public class Jsonparser implements ITokenManagementParser
{
	
	public Object PARSE(String input_file)
			throws Tokenmanagementexception 
	{
		Datareader myReader = new Datareader();
		String fileContents = myReader.GET_STRING_FROM_FILE(input_file);

		return JSON_DATA_PARSE(fileContents);
	}

	public JsonObject JSON_DATA_PARSE(String file_contents) throws Tokenmanagementexception 
	{
		JsonObject jsonLicense = null;
		try(StringReader strReader = new StringReader(file_contents)) {
			jsonLicense = Json.createReader(strReader).readObject();
		} catch(Exception exception) 
		{
			throw new Tokenmanagementexception
			("Error: JSON object cannot be created due to incorrect representation");
		}
		return jsonLicense;
	}
}
