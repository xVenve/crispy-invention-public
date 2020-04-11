package Transport4Future.TokenManagement;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class Tokenstore 
{

	private List<Token> tokens_list;
	
	private void LOAD () 
	{
		try
		{
			JsonReader reader = new JsonReader(new FileReader(System.getProperty("user.dir") + 
					"/Store/tokenStore.json"));
			Gson gson = new Gson();
			Token [] my_array = gson.fromJson(reader, Token[].class);
			this.tokens_list = new ArrayList<Token>();
			for (Token token: my_array) 
			{
				this.tokens_list.add(token);
			}
		}
		catch (Exception ex)
		{
		this.tokens_list = new ArrayList <Token>();
				
		}	
	}
	
	public void ADD (Token new_token) throws Tokenmanagementexception 
	{
		this.LOAD();
		if (FIND(new_token.toString())==null) 
		{
			tokens_list.add(new_token);
			this.SAVE();
		}
	}
	
	private void SAVE () throws Tokenmanagementexception 
	{
		Gson gson = new Gson();  
		String json_string = gson.toJson(this.tokens_list);
        FileWriter file_writer;
		try {
			file_writer = new FileWriter(System.getProperty("user.dir") + 
					"/Store/tokenStore.json");
	        file_writer.write(json_string);
	        file_writer.close();
		} catch (IOException e) {
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