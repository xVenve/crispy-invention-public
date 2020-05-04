package Transport4Future.TokenManagement.IO;

import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;

public interface ITokenManagementParser 
{
	public Object PARSE(String file_name) throws Tokenmanagementexception;
}
