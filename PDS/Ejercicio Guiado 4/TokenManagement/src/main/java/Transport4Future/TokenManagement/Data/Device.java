package Transport4Future.TokenManagement.Data;

import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;

public class Device extends Attribute 
{
	
	Device(String value) throws Tokenmanagementexception
	{
	this.pattern="([A-Fa-f0-9]{32})";
	this.error_message="Error: invalid Device in token request.";
	this.data= VALIDATEDATA(value);
		
	}

}