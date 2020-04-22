package Transport4Future.TokenManagement;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class Tokenrequeststore 
{
	private static final String STOREPATH = System.getProperty("user.dir") + "/Store/tokenRequestsStore.json";
	public HashMap<String, Tokenrequest> HASH_MAP(Tokenrequest request, String hex, Gson gson) 
	{
		String jsonString;
		HashMap<String, Tokenrequest> clonedMap;
	

		//Tengo que cargar el almacen de tokens request en memoria y añadir el nuevo si no existe
		try {
			Object object = gson.fromJson(new FileReader(STOREPATH), Object.class);
			jsonString = gson.toJson(object);	
	        Type type = new TypeToken<HashMap<String, Tokenrequest>>(){}.getType();
	        clonedMap = gson.fromJson(jsonString, type);
		} catch (Exception exception) {
			clonedMap=null;
		}
        if (clonedMap==null) 
        {
        	clonedMap = new HashMap ();
        	clonedMap.put (hex, request);	        	
        }
        else if (!clonedMap.containsKey(hex))
        {
        	clonedMap.put (hex, request);
        }
		return clonedMap;
	}
	public void SAVE_TOKEN_REQUEST_STORE(Gson gson, HashMap<String, Tokenrequest> cloned_map)
			throws Tokenmanagementexception 
	{
		String jsonString;
		jsonString = gson.toJson(cloned_map);
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

}
