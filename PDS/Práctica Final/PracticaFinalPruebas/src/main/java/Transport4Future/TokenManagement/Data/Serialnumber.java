package Transport4Future.TokenManagement.Data;

import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;

public class Serialnumber extends Attribute 
{
	
	Serialnumber(String value) throws Tokenmanagementexception
	{
	this.pattern="([A-Za-z0-9-]{1,})";
	this.error_message="Error: invalid String length for serial number.";
	this.data= VALIDATEDATA(value);
	}
}
