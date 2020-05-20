package Transport4Future.TokenManagement.Data;

import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;

public class Typeofrevocation extends Attribute  
{
	
	private static final String ERROR_INVALID_TYPE_OF_REVOCATION = "Error: invalid type of revocation.";
	private static final String FINAL = "Final";
	private static final String TEMPORAL = "Temporal";

	Typeofrevocation(String value) throws Tokenmanagementexception
	{
	this.error_message=ERROR_INVALID_TYPE_OF_REVOCATION;
	this.data= VALIDATEDATA(value);
	}
	
	protected String VALIDATEDATA(String value) throws Tokenmanagementexception 
	{
		if (!(value.equalsIgnoreCase(TEMPORAL) || 
				value.equalsIgnoreCase(FINAL))) 
		{
			throw new Tokenmanagementexception(ERROR_INVALID_TYPE_OF_REVOCATION);	
		}
		return value;
	}
	
}
