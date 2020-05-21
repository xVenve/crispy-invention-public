package Transport4Future.TokenManagement.Data;

import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;

public class Macaddress extends Attribute 
{	
	Macaddress(String value) throws Tokenmanagementexception
	{
	this.pattern= "([a-fA-F0-9]{2}[:-]){5}[a-fA-F0-9]{2}$";
	this.error_message= "Error: invalid MAC Address data in JSON structure.";
	this.data= VALIDATEDATA(value);		
	}
}