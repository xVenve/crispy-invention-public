package Transport4Future.TokenManagement.Utils;

import java.util.Base64;

import Transport4Future.TokenManagement.Data.Token;

public class Encoder 
{
	public String URL64ENCODE(Token my_token, String signature) 
	{		
		String stringToEncode = my_token.GET_HEADER() + my_token.GET_PAYLOAD() + my_token.GET_SIGNATURE();
		return Base64.getUrlEncoder().encodeToString(stringToEncode.getBytes());
	}
	
	public String URL64DECODE(String encoded) 
	{	
		byte[] decoded = Base64.getMimeDecoder().decode(encoded);
		String decodedString = new String(decoded);
		return decodedString;
	}	
}
