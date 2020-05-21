package Transport4Future.TokenManagement.Data;

import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;

public class Devicename extends Attribute 
{
	Devicename(String value) throws Tokenmanagementexception
	{
	this.pattern="([A-Za-z0-9\\s]{1,20})";
	this.error_message="Error: invalid String length for device name.";
	this.data= VALIDATEDATA(value);
	}
}
