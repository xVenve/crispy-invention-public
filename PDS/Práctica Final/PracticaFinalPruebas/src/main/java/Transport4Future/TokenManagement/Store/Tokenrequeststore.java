package Transport4Future.TokenManagement.Store;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.HashMap;

import Transport4Future.TokenManagement.Data.Tokenrequest;
import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class Tokenrequeststore 
{
	
	private static Tokenrequeststore tokenrequeststore;
	
	private Tokenrequeststore() 
	{
		
	}
	
	public static Tokenrequeststore GET_INSTANCE() 
	{
		if(tokenrequeststore==null)
			tokenrequeststore=new Tokenrequeststore();
		return tokenrequeststore;
	}
	
	public Tokenrequeststore CLONE() 
	{
		try {
			throw new CloneNotSupportedException();
		}catch(CloneNotSupportedException exception) {
			System.out.println("Token manager object cannot be cloned");
		}
		return null;
	}
	
	private static final String STOREPATH = System.getProperty("user.dir") + "/Store/tokenRequestsStore.json";
	
	public void SAVE_TOKEN_REQUEST(Tokenrequest request, String hex)
			throws Tokenmanagementexception 
	{
		HashMap<String, Tokenrequest> clonedMap = this.LOAD_TOKENREQUEST_STORE();
		if (clonedMap==null) 
        {
			clonedMap = new HashMap<String, Tokenrequest>();
			clonedMap.put (hex, request);	        	
        }
        else if (!clonedMap.containsKey(hex))
        {
        	clonedMap.put (hex, request);
        }
		Gson gson= new Gson();
		String jsonString;
		jsonString = gson.toJson(clonedMap);
        FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(STOREPATH);
	        fileWriter.write(jsonString);
	        fileWriter.close();
		} catch (IOException exception) {
			throw new Tokenmanagementexception
			("Error: Unable to save a new token in the internal licenses store");
		}
	}
		
	private HashMap<String, Tokenrequest> LOAD_TOKENREQUEST_STORE() 
	{
		//Tengo que cargar el almacen de tokens request en memoria y añadir el nuevo si no existe
		HashMap<String, Tokenrequest> clonedMap;
		try {
			Gson gson =new Gson();
			String jsonString;
			
			Object object = gson.fromJson(new FileReader(STOREPATH), Object.class);
			jsonString = gson.toJson(object);	
			Type type = new TypeToken<HashMap<String, Tokenrequest>>(){}.getType();
			clonedMap = gson.fromJson(jsonString, type);
		} catch (Exception exception) {
			clonedMap=null;
		}
	return clonedMap;
	}
	
	public Tokenrequest FIND(String device) throws Tokenmanagementexception
    {
        Tokenrequeststore requestStore = Tokenrequeststore.GET_INSTANCE();
        HashMap <String, Tokenrequest> clonedMap = requestStore.LOAD_TOKENREQUEST_STORE();
        if (clonedMap == null)
            return null;
        else if (!clonedMap.containsKey(device))
            return null;
        else
            return clonedMap.get(device);
    }
	
}
