package Transport4Future.TokenManagement.Store;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import Transport4Future.TokenManagement.Data.Token;
import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

public class Tokenstore 
{

	private static final String PATH = System.getProperty("user.dir") + "/Store/tokenStore.json";
	private List<Token> tokens_list;
	
	private static Tokenstore tokenstore;
	
	private Tokenstore() 
	{
		this.LOAD();	
	}
	
	public static Tokenstore GET_INSTANCE() 
	{
		if(tokenstore==null)
			tokenstore=new Tokenstore();
		return tokenstore;
	}
	
	public Tokenstore CLONE() 
	{
		try {
			throw new CloneNotSupportedException();
		}catch(CloneNotSupportedException exception) {
			System.out.println("Token Store object cannot be cloned");
		}
		return null;
	}
	
	
	private void LOAD() 
	{
		try
		{
			JsonReader reader = new JsonReader
					(new FileReader(PATH));
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
		if (FIND(new_token.GENERATE_TOKEN_VALUE())==null) 
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
			fileWriter = new FileWriter(PATH);
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
	    for (Token token : this.tokens_list) 
	    {
	    	String decoded = token.GET_HEADER() + token.GET_PAYLOAD() + token.GET_SIGNATURE();
	        if (decoded.equals(token_to_find)) 
	        	result = token;
	    }
		return result;
	}
	
}
