package Transport4Future.TokenManagement.Utils;

import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;

public interface IHash 
{
	public String HASH (String text) throws Tokenmanagementexception; 
}
