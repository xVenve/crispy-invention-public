package Transport4Future.TokenManagement.Data;

import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;

public class Driverversion extends Attribute 
{
	
	Driverversion(String value) throws Tokenmanagementexception
	{
	this.pattern="([a-zA-Z0-9]{1}[A-Za-z0-9\\.]{0,24})";
	this.error_message="Error: invalid String length for driver version.";
	this.data= VALIDATEDATA(value);
		
	}

}