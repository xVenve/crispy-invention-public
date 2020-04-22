package Transport4Future.TokenManagement;

public interface ITokenManagement 
{
	
	String TOKEN_REQUEST_GENERATION (String input_file) throws Tokenmanagementexception;

	String REQUEST_TOKEN (String input_file) throws Tokenmanagementexception;

	boolean VERIFY_TOKEN (String token) throws Tokenmanagementexception;


}
