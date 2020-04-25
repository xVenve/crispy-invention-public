package Transport4Future.TokenManagement.Data;

import java.util.regex.Pattern;

import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;

public abstract class Attribute 
{
	protected String pattern;
	protected String error_message;
	protected String data;
	

	protected String VALIDATEDATA(String value)
			throws Tokenmanagementexception 
	{
		Pattern pattern;
		pattern = Pattern.compile(this.pattern);
		if (!pattern.matcher(value).matches()) 
		{
			throw new Tokenmanagementexception(this.error_message);	
		}
		return value;
	}
	
	public String GETDATA() 
	{
		return data;
	}
}
