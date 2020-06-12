package Transport4Future.TokenManagement;

import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;

public class Tokengenerationtest 
{
	private Tokenmanager my_manager;
	
	public Tokengenerationtest () 
	{
		 my_manager = Tokenmanager.GET_INSTANCE();
	}
	
	@DisplayName ("Invalid Test Cases")
	@ParameterizedTest(name = "{index} -with the input ''{0}'' error expected is ''{1}''")
	@CsvFileSource(resources = "/invalidTestCasesRequestGenerationTest.csv")
	void InvalidTestCases(String InputFilePath, String expectedMessage) 
	{
		Tokenmanagementexception ex = Assertions.assertThrows(Tokenmanagementexception.class, ()-> 
		{
			my_manager.TOKEN_REQUEST_GENERATION(InputFilePath);
		});
		assertEquals (expectedMessage,ex.GET_MESSAGE());
	}
	
	@DisplayName ("Valid Test Cases")
	@ParameterizedTest(name = "{index} -with the input ''{0}'' output expected is ''{1}''")
	@CsvFileSource(resources = "/validTestCasesRequestGenerationTest.csv")
	void ValidTestCases(String InputFilePath, String Result) throws Tokenmanagementexception
	{
		String myResult = my_manager.TOKEN_REQUEST_GENERATION(InputFilePath);
		assertEquals (Result,myResult);
	}
}