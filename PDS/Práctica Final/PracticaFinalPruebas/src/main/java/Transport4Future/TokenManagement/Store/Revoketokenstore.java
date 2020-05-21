package Transport4Future.TokenManagement.Store;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import Transport4Future.TokenManagement.Data.Revoketoken;
import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;


public class Revoketokenstore 
{
	private static final String PATH = System.getProperty("user.dir") + "/Store/revokeTokenStore.json";
	private List<Revoketoken> revoketokens_list;
	
	private static Revoketokenstore revoketokenstore;
	
	private Revoketokenstore() 
	{
		this.LOAD();	
	}
	
	public static Revoketokenstore GET_INSTANCE() 
	{
		if(revoketokenstore==null)
			revoketokenstore=new Revoketokenstore();
		return revoketokenstore;
	}
	
	public Tokenstore CLONE() 
	{
		try {
			throw new CloneNotSupportedException();
		}catch(CloneNotSupportedException exception) {
			System.out.println("Revoke Token Store object cannot be cloned");
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
			Revoketoken [] myArray = gson.fromJson(reader, Revoketoken[].class);
			this.revoketokens_list = new ArrayList<Revoketoken>();
			for (Revoketoken revoketoken: myArray) 
			{
				this.revoketokens_list.add(revoketoken);
			}
		}
		catch (Exception exception)
		{		
			this.revoketokens_list = new ArrayList<Revoketoken>();
		}	
	}
	 
	public void ADD (Revoketoken new_token) throws Tokenmanagementexception 
	{
		if (FIND(new_token.GET_TOKEN_VALUE())==null) 
		{
			revoketokens_list.add(new_token);
			this.SAVE();
		}
	}
	
	private void SAVE () throws Tokenmanagementexception 
	{
		
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		String jsonString = gson.toJson(this.revoketokens_list);
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
	
	public Revoketoken FIND(String encoded) 
	{
		Revoketoken result = null;
	    for (Revoketoken token : this.revoketokens_list) 
	    {
	    	if (token.GET_TOKEN_VALUE().equals(encoded)) 
	        	result = token;
	    }
		return result;
	}
}

