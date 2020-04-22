package Transport4Future.TokenManagement;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

public class Tokenstore 
{

	private List<Token> tokens_list;
	
	private void LOAD () 
	{
		try
		{
			JsonReader reader = new JsonReader
					(new FileReader(System.getProperty("user.dir") + "/Store/tokenStore.json"));
			Gson gson = new Gson();
			Token [] myArray = gson.fromJson(reader, Token[].class);
			this.tokens_list = new ArrayList<Token>();
			for (Token token: myArray) 
			{
				this.tokens_list.add(token);
			}
		}
		catch (Exception exception)
		{		
			this.tokens_list = new ArrayList<Token>();
		}	
	}
	
	public void ADD (Token new_token) throws Tokenmanagementexception 
	{
		this.LOAD();
		if (FIND(new_token.GET_TOKEN_VALUE())==null) 
		{
			tokens_list.add(new_token);
			this.SAVE();
		}
	}
	
	private void SAVE () throws Tokenmanagementexception 
	{
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		String jsonString = gson.toJson(this.tokens_list);
        FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(System.getProperty("user.dir") + "/Store/tokenStore.json");
	        fileWriter.write(jsonString);
	        fileWriter.close();
		} catch (IOException exception) {
			throw new Tokenmanagementexception
			("Error: Unable to save a new token in the internal licenses store");
		}
	}
	
	public Token FIND (String token_to_find) 
	{
		Token result = null;
		this.LOAD();
	    for (Token token : this.tokens_list) 
	    {
	        if (token.GET_TOKEN_VALUE().equals(token_to_find)) 
	        {
	        	result = token;
	        }
	    }
		return result;
	}
}
