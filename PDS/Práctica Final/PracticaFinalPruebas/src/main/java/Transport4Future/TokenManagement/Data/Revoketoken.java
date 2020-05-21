package Transport4Future.TokenManagement.Data;

import java.util.HashMap;

import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;
import Transport4Future.TokenManagement.IO.Revoketokenparser;
import Transport4Future.TokenManagement.Store.Revoketokenstore;
import Transport4Future.TokenManagement.Store.Tokenstore;
import Transport4Future.TokenManagement.Utils.Encoder;

public class Revoketoken 
{	
	private static final String ERROR_TOKEN_INEXISTENTE = "Error: El token que se quiere revocar no existe.";
	private static final String ERROR_TOKEN_CADUCADO = "Error: El token que se quiere revocar ya ha caducado.";
	private static final String ERROR_TOKEN_YA_REVOCADO = "Error: El token que se quiere revocar ya está revocado.";
	private String token_value;
	private Typeofrevocation type_of_revocation;
	private Reason reason;
	private Tokenstore my_token_store = Tokenstore.GET_INSTANCE(); 
	private Token token_to_revoke;
	
	public String REVOKE_TOKEN(String file_path) throws Tokenmanagementexception
	{
		OBTAIN_REVOKE_TOKEN_DATA(file_path);
		this.CHECK_REVOKE_TOKEN();
		this.STORE_REVOKETOKEN();
		
		return token_to_revoke.GET_NOTIFICATION_EMAIL();
	}

	private void OBTAIN_REVOKE_TOKEN_DATA(String file_path) throws Tokenmanagementexception 
	{
		Revoketokenparser myParser = new Revoketokenparser();
		HashMap<String, String> items = myParser.PARSE(file_path);
		
		this.token_value = items.get(Revoketokenparser.TOKEN_VALUE);
		this.type_of_revocation = new Typeofrevocation(items.get(Revoketokenparser.TYPE_OF_REVOCATION));
		this.reason = new Reason(items.get(Revoketokenparser.REASON));	
		this.token_to_revoke = this.EXTRACT_TOKEN_TO_REVOKE();
	}
	
	private boolean CHECK_REVOKE_TOKEN() throws Tokenmanagementexception 
	{
		Revoketokenstore myRevokestore = Revoketokenstore.GET_INSTANCE();
				
		if(token_to_revoke.IS_VALID() == false)
			throw new Tokenmanagementexception(ERROR_TOKEN_CADUCADO);
		if(myRevokestore.FIND(this.GET_TOKEN_VALUE())!=null)
			throw new Tokenmanagementexception(ERROR_TOKEN_YA_REVOCADO);
		return true;
	}
	
	private Token EXTRACT_TOKEN_TO_REVOKE() throws Tokenmanagementexception 
	{
		Encoder myEncoder = new Encoder();
		String decodetokenvalue = myEncoder.URL64DECODE(token_value);
		
		Token foundToken = my_token_store.FIND(decodetokenvalue);
		if(foundToken != null)
			return foundToken;
		throw new Tokenmanagementexception(ERROR_TOKEN_INEXISTENTE);
	}
		
	private void STORE_REVOKETOKEN() throws Tokenmanagementexception 
	{
		Revoketokenstore myRevokestore = Revoketokenstore.GET_INSTANCE();
		myRevokestore.ADD(this);
	}

	public String GET_TOKEN_VALUE() 
	{
		return this.token_value;
	}
}
