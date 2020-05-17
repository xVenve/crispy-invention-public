package Transport4Future.TokenManagement.Data;

import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;

public class Dateclass extends Attribute 
{

	Dateclass(String value) throws Tokenmanagementexception
	{
	this.pattern="(0[1-9]|[1-2][0-9]|3[0-1])-(0[1-9]|1[0-2])-[0-9]{4}"
			+ "\\s(2[0-3]|[01][0-9]):[0-5][0-9]:[0-5][0-9]";
	this.error_message="Error: invalid date data in JSON structure.";
	this.data= VALIDATEDATA(value);
		
	}

}