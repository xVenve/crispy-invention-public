package Transport4Future.TokenManagement.Data;

import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;

public class Typeofdevice extends Attribute 
{
	
	Typeofdevice(String value) throws Tokenmanagementexception
	{
	this.error_message="Error: invalid type of sensor.";
	this.data= VALIDATEDATA(value);
	}
	
	protected String VALIDATEDATA(String value) throws Tokenmanagementexception 
	{
		if (!(value.equalsIgnoreCase("Sensor") || 
				value.equalsIgnoreCase("Actuator"))) 
		{
			throw new Tokenmanagementexception("Error: invalid type of sensor.");	
		}
		return value;
	}
	
}
