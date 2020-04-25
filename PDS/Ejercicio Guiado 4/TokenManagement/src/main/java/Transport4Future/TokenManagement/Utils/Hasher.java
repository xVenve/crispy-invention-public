package Transport4Future.TokenManagement.Utils;

import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hasher 
{
	
	public String HASHING(String data_to_sign, String type_of_hash) throws Tokenmanagementexception 
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
		String format = "%064x";
		
		if (type_of_hash.equals("SHA-256")) 
		{
			signature = String.format(format, new BigInteger(1, digest));
		}else if (type_of_hash.equals("MD5")) 
		{
			format="%032x";
			signature = String.format(format, new BigInteger(1, digest));
		}
		return signature;
	}
	
	public String HASH_SHA256(String text) throws Tokenmanagementexception 
	{
		String typeOfHash ="SHA-256";
		return HASHING(text,typeOfHash);
	
	}

}
