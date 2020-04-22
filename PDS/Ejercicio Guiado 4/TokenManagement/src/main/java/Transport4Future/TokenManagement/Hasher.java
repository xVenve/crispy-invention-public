package Transport4Future.TokenManagement;



import java.util.Base64;
import java.util.HashMap;

import com.google.gson.Gson;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Hasher 
{
	public String HASHING(String data_to_sign,String type_of_hash) throws Tokenmanagementexception 
	{
		MessageDigest msgDigest;
		try {
			msgDigest = MessageDigest.getInstance(type_of_hash);
		} catch (NoSuchAlgorithmException e) {
			throw new Tokenmanagementexception("Error: no such hashing algorithm.");
		}
		
		msgDigest.update(data_to_sign.getBytes(StandardCharsets.UTF_8));
		byte[] digest = msgDigest.digest();
		String signature = "";
		if (type_of_hash.equals("SHA-256")) 
		{
			signature = String.format("%064x", new BigInteger(1, digest));
		}else if (type_of_hash.equals("MD5")) 
		{
			signature = String.format("%032x", new BigInteger(1, digest));
		}
		return signature;
	}
	public void HASH_MD5(Tokenrequest request, String hex) throws Tokenmanagementexception 
	{
		Gson gson = new Gson();
		String jsonString;
		Tokenrequeststore myTokenRequestStore = new Tokenrequeststore();
		HashMap<String, Tokenrequest> clonedMap = myTokenRequestStore.HASH_MAP(request, hex, gson);
		myTokenRequestStore.SAVE_TOKEN_REQUEST_STORE(gson, clonedMap);
	}
	public void HASH_SHA256(Token my_token, String signature) 
	{
		my_token.SET_SIGNATURE(signature);
		
		String stringToEncode = my_token.GET_HEADER() + my_token.GET_PAYLOAD() + my_token.GET_SIGNATURE();
		String encodedString = Base64.getUrlEncoder().encodeToString(stringToEncode.getBytes());
		my_token.SET_TOKEN_VALUE(encodedString);
	}

}
