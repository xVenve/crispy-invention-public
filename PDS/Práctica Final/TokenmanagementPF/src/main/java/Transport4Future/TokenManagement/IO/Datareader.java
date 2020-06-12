package Transport4Future.TokenManagement.IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;

public class Datareader
{
	public String GET_STRING_FROM_FILE(String input_file) throws Tokenmanagementexception 
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
		return fileContents;
	}	
}
