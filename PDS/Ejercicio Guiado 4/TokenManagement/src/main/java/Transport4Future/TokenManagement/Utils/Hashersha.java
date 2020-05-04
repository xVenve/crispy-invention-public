package Transport4Future.TokenManagement.Utils;

import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;

public class Hashersha extends Generichasher implements IHash 
{

	public Hashersha() 
	{
		this.algorithm ="SHA-256";
		this.format = "%064x";
	}
	@Override
	public String HASH(String text) throws Tokenmanagementexception 
	{
		
		return super.HASH(text);
	}

}
