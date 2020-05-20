package Transport4Future.TokenManagement.Data;

import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;

public class Reason extends Attribute 
{

	
	private static final String ERROR_INVALID_STRING_LENGTH_FOR_REASON = "Error: invalid String length for reason.";

	Reason(String value) throws Tokenmanagementexception
	{
		
		if(value.length()<=100)
			this.data= value;
		else
			throw new Tokenmanagementexception(ERROR_INVALID_STRING_LENGTH_FOR_REASON);	
	}
}