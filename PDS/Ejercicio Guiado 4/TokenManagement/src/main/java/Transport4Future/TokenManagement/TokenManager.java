package Transport4Future.TokenManagement;


import javax.json.JsonObject;


public class Tokenmanager implements ITokenManagement 
{

	
	public String TOKEN_REQUEST_GENERATION (String input_file) throws Tokenmanagementexception
	{ 
		Tokenrequest request = null;
		
		Jsonparser myParser = new Jsonparser();
		JsonObject jsonLicense = myParser.CHECK_REPRESENTATION(input_file);
		request = new Tokenrequest(jsonLicense);
		
		request.CHECK_TOKEN_REQUEST_FORMAT();
		
		String inputMD5 = "Stardust" + "-" + request.toString();
		Hasher myHasher = new Hasher();
		String hex = myHasher.HASHING(inputMD5,"MD5");
		myHasher.HASH_MD5(request, hex);
		return hex;
	}

	public String REQUEST_TOKEN (String input_file) throws Tokenmanagementexception
	{ 
		Token myToken = null;
				
		Jsonparser myParser = new Jsonparser();
		JsonObject jsonLicense = myParser.CHECK_REPRESENTATION(input_file);
		
	
		myToken = new Token (jsonLicense);
		myToken.CHECK_TOKEN_FORMAT();
		
		Hasher myHasher = new Hasher();
		String dataToSign =myToken.GET_HEADER() + myToken.GET_PAYLOAD();
		String signature = myHasher.HASHING(dataToSign,"SHA-256");
		myHasher.HASH_SHA256(myToken, signature);
		
		Tokenstore myStore = new Tokenstore ();
		myStore.ADD(myToken);
		
		return myToken.GET_TOKEN_VALUE();
	}

	private boolean IS_VALID (Token token_found) 
	{ 
		if ((!token_found.IS_EXPIRED()) && (token_found.IS_GRANTED()))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public boolean VERIFY_TOKEN (String token) throws Tokenmanagementexception
	{
		boolean result = false;
		Tokenstore myStore = new Tokenstore ();
		
		Token tokenFound = myStore.FIND(token);

		if (tokenFound!=null)
		{
			result = IS_VALID(tokenFound);
		}
		return result;
	}
}