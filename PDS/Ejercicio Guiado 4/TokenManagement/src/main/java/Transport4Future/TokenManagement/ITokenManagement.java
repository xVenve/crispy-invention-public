package Transport4Future.TokenManagement;

public interface ITokenManagement {
	
	String TokenRequestGeneration (String InputFile) throws TokenManagementException;

	String RequestToken (String InputFile) throws TokenManagementException;

	boolean VerifyToken (String Token) throws TokenManagementException;


}
