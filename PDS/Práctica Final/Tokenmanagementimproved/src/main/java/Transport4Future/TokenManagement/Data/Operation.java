package Transport4Future.TokenManagement.Data;

import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;

public class Operation extends Attribute  
{
	private static final String ERROR_INVALID_TYPE_OF_SENSOR = "Error: invalid type of sensor.";
	private static final String ERROR_INVALID_TYPE_OF_OPERATION = "Error: invalid type of operation.";
	private static final String CHECK_STATE = "Check State";
	private static final String SEND_REQUEST_TO_ACTUATOR = "Send Request to Actuator";
	private static final String SEND_INFORMATION_FROM_SENSOR = "Send Information from Sensor";

	Operation(String value) throws Tokenmanagementexception
	{
	this.error_message=ERROR_INVALID_TYPE_OF_SENSOR;
	this.data= VALIDATEDATA(value);
	}
	
	protected String VALIDATEDATA(String value) throws Tokenmanagementexception 
	{
		if (!(value.equalsIgnoreCase(SEND_INFORMATION_FROM_SENSOR) || 
				value.equalsIgnoreCase(SEND_REQUEST_TO_ACTUATOR) || 
				value.equalsIgnoreCase(CHECK_STATE))) 
		{
			throw new Tokenmanagementexception(ERROR_INVALID_TYPE_OF_OPERATION);	
		}
		return value;
	}
}
