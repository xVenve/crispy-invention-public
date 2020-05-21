package Transport4Future.TokenManagement.Utils;

import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class Generichasher implements IHash
{
	protected String algorithm;
	protected String format;
	
	public Generichasher() 
	{
		super();
	}

	public String HASH( String data_to_sign) 
			throws Tokenmanagementexception 
	{
		MessageDigest msgDigest;
		try {
			msgDigest = MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			throw new Tokenmanagementexception("Error: no such hashing algorithm.");
		}
		
		msgDigest.update(data_to_sign.getBytes(StandardCharsets.UTF_8));
		byte[] digest = msgDigest.digest();
		
		String hex = String.format(format, new BigInteger(1, digest));
		return hex;
	}
}