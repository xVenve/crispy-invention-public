package Transport4Future.TokenManagement.Utils;

import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;

public class Hashermd extends Generichasher implements IHash 
{
	private String key = "Stardust-";

	public Hashermd () 
	{
		this.algorithm = "MD5";
		this.format = "%32x";
	}

	@Override
	public String HASH(String text) throws Tokenmanagementexception 
	{
		
		String input = key + text;
		
		return super.HASH(input);
	}

}
