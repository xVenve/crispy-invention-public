package Transport4Future.TokenManagement.Data;

import java.util.HashMap;

import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;
import Transport4Future.TokenManagement.IO.Actionparser;
import Transport4Future.TokenManagement.Store.Revoketokenstore;
import Transport4Future.TokenManagement.Store.Tokenrequeststore;
import Transport4Future.TokenManagement.Store.Tokenstore;
import Transport4Future.TokenManagement.Utils.Encoder;

public class Checkaction 
{

	private static final String SENSOR = "Sensor";
	private static final String ACTUATOR = "Actuator";
	private static final String ERROR_NO_SE_PUEDE_REALIZAR_LA_OPERACIÓN = 
			"Error: No se puede realizar la operación.";
	private static final String SEND_REQUEST_FROM_ACTUATOR = "Send Request from Actuator";
	private static final String SEND_INFORMATION_FROM_SENSOR = "Send Information from Sensor";
	private static final String ERROR_EL_TOKEN_NO_EXISTE_O_ESTA_REVOCADO = 
			"Error: El token no existe o está revocado.";
	private String token_value; 
	private Operation type_of_operation;
	private Revoketokenstore my_revoke_store = Revoketokenstore.GET_INSTANCE();
	private Tokenstore my_token_store = Tokenstore.GET_INSTANCE();
	private Token token_to_check;
	private Tokenrequeststore my_request_store = Tokenrequeststore.GET_INSTANCE();
	private Tokenrequest request_to_check;

	public boolean EXECUTE_ACTION (String file_path) throws Tokenmanagementexception 
	{
		OBTAIN_ACTION_DATA(file_path);
		OBTAIN_TOKEN_TO_CHECK();
		VALIDATE_ACTION();
		return true;
	}

	private void OBTAIN_TOKEN_TO_CHECK() throws Tokenmanagementexception 
	{
		Encoder myEncoder= new Encoder();		
		token_to_check = my_token_store.FIND(myEncoder.URL64DECODE(token_value));
		if(my_revoke_store.FIND(token_value) != null || token_to_check == null ) 
		{
			throw new Tokenmanagementexception(ERROR_EL_TOKEN_NO_EXISTE_O_ESTA_REVOCADO);
		}
		
		request_to_check = my_request_store.FIND(token_to_check.GET_DEVICE());
	}

	private void OBTAIN_ACTION_DATA(String file_path) throws Tokenmanagementexception 
	{
		Actionparser myParser = new Actionparser();
		HashMap<String, String> items = myParser.PARSE(file_path);
		this.token_value = items.get(Actionparser.TOKEN_VALUE);
		this.type_of_operation = new Operation(items.get(Actionparser.TYPE_OF_OPERATION));
	}

	private void VALIDATE_ACTION() throws Tokenmanagementexception 
	{
	
		if (type_of_operation.GETDATA().equalsIgnoreCase(SEND_INFORMATION_FROM_SENSOR) && 
				(request_to_check.GET_TYPE_OF_DEVICE().equals(ACTUATOR))) 
		{
			throw new Tokenmanagementexception(ERROR_NO_SE_PUEDE_REALIZAR_LA_OPERACIÓN);
			
		}else if (type_of_operation.GETDATA().equalsIgnoreCase(SEND_REQUEST_FROM_ACTUATOR) && 
				(request_to_check.GET_TYPE_OF_DEVICE().equals(SENSOR)) )
		{ 
			throw new Tokenmanagementexception(ERROR_NO_SE_PUEDE_REALIZAR_LA_OPERACIÓN);
			
		}
	}
	

	
	
	
}
