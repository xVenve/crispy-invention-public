package Transport4Future.TokenManagement;

import Transport4Future.TokenManagement.Data.Token;
import Transport4Future.TokenManagement.Data.Tokenrequest;
import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;
import Transport4Future.TokenManagement.Store.Tokenstore;
import Transport4Future.TokenManagement.Utils.Encoder;

public class Tokenmanager implements ITokenManagement 
{
	private static Tokenmanager manager;
	
	private Tokenmanager() 
	{	
	}
	
	public static Tokenmanager GET_INSTANCE() 
	{
		if(manager==null)
			manager=new Tokenmanager();
		return manager;
	}
	
	public Tokenmanager CLONE() 
	{
		try {
			throw new CloneNotSupportedException();
		}catch(CloneNotSupportedException exception) {
			System.out.println("Token manager object cannot be cloned");
		}
		return null;
	}	
	
	public String TOKEN_REQUEST_GENERATION(String input_file) throws Tokenmanagementexception
	{ 
		Tokenrequest request = new Tokenrequest(input_file);	
		return request.GENERATE_HASH();
	}

	public String REQUEST_TOKEN(String input_file) throws Tokenmanagementexception
	{ 
		Token myToken = new Token(input_file);
		return myToken.GENERATE_TOKEN_VALUE();
	}

	public boolean VERIFY_TOKEN (String token) throws Tokenmanagementexception
	{
		boolean result = false;
		Tokenstore myStore = Tokenstore.GET_INSTANCE();
		Encoder myEncoder= new Encoder();
		
		Token tokenFound = myStore.FIND(myEncoder.URL64DECODE(token));

		if (tokenFound!=null)
			result = tokenFound.IS_VALID();
		return result;
	}
	
}