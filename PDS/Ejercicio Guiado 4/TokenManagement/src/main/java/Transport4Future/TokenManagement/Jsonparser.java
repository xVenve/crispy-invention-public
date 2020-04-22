package Transport4Future.TokenManagement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;

public class Jsonparser 
{
	public JsonObject CHECK_REPRESENTATION(String input_file)
			throws Tokenmanagementexception 
	{
		BufferedReader reader;
		String fileContents = "";
		try {
			reader = new BufferedReader(new FileReader(input_file));
		} catch (FileNotFoundException exception) {
			throw new Tokenmanagementexception("Error: input file not found.");
		}
		String line;
		try {
			while ((line = reader.readLine()) != null) 
			{
				fileContents += line;
			}
		} catch (IOException exception) {
			throw new Tokenmanagementexception("Error: input file could not be accessed.");
		}
		try {
			reader.close();
		} catch (IOException exception) {
			throw new Tokenmanagementexception("Error: input file could not be closed.");
		}

		JsonObject jsonLicense = null;
		try(StringReader strReader = new StringReader(fileContents)) {
			jsonLicense = Json.createReader(strReader).readObject();
		} catch(Exception exception) 
		{
			throw new Tokenmanagementexception
			("Error: JSON object cannot be created due to incorrect representation");
		}
		return jsonLicense;
	}
}
