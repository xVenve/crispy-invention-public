package Transport4Future.TokenManagement.Exceptions;

public class Tokenmanagementexception extends Exception 
{	
	private static final long serialVersionUID = 1L;
	String message;

	public Tokenmanagementexception(String message) 
	{
		this.message = message;
	}

	public String GET_MESSAGE() 
	{
		return this.message;
	}	
}
