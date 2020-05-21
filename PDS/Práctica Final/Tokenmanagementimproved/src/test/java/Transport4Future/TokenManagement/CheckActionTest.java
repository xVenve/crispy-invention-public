package Transport4Future.TokenManagement;

import java.io.FileWriter;
import java.io.IOException;

import Transport4Future.TokenManagement.Data.Checkaction;
import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;

class CheckActionTest 
{
	private Checkaction my_action;
	private Tokenmanager my_manager;
	
	public CheckActionTest() 
	{
		 my_action = new Checkaction();
		 my_manager = Tokenmanager.GET_INSTANCE();
	}
	/* Caso de Prueba: <Casos prueba inválidos CheckActionTest>
	* Nodo del Árbol de Derivación Asociado: Arbol derivación check action
	* Técnica de prueba: Análisis Sintáctico
	* Resultado Esperado: Esperamos que todos den errores de json excepto el primero y los 3 últimos, 
	* que serán errores manejados por nuestro código. 
	*/
	@DisplayName ("Invalid Test Cases")
	@ParameterizedTest(name = "{index} -with the input ''{0}'' error expected is ''{1}''") 
	@CsvFileSource(resources = "/invalidTestCasesExecuteActionTokenTest.csv")
	void InvalidTestCases(String InputFilePath, String expectedMessage) 
	{
		Tokenmanagementexception ex = Assertions.assertThrows(Tokenmanagementexception.class, ()-> 
		{
			my_action.EXECUTE_ACTION(InputFilePath);
			this.RESET_STORES();
		});
		assertEquals (expectedMessage,ex.GET_MESSAGE());
	}
	
	/* Caso de Prueba: <Casos prueba válidos CheckActionTest>
	*  Valor Límite o Asociado: Valor de type of operation y token value
	*  Técnica de prueba: <Valor Límite>
	*  Resultado Esperado: Esperamos que todos los casos no hagan throw de alguna excepcion
	*/
	@DisplayName ("Valid Test Cases")
	@ParameterizedTest(name = "{index} -with the input ''{1}'' and ''{2}''")
	@CsvFileSource(resources = "/validTestCasesExecuteActionTokenTest.csv")
	void ValidTestCases(String InputFilePath, String TokenPath, String TokenRequestPath) 
			throws Tokenmanagementexception 
	{
		my_manager.TOKEN_REQUEST_GENERATION(TokenPath);
		my_manager.REQUEST_TOKEN(TokenRequestPath);
		boolean result = my_action.EXECUTE_ACTION(InputFilePath);
		this.RESET_STORES();
		assertEquals (true,result);
	}

	private void RESET_STORES() throws Tokenmanagementexception 
	{
		String storetokenStorePath = System.getProperty("user.dir") + "/Store/tokenStore.json";
        RESET_STORE(storetokenStorePath);
		
		String storerevokeTokenStorePath = System.getProperty("user.dir") + "/Store/revokeTokenStore.json";
		RESET_STORE(storerevokeTokenStorePath);
	}

	private void RESET_STORE(String store_path) throws Tokenmanagementexception 
	{
		FileWriter filetokenStoreWriter;
		try {
			filetokenStoreWriter = new FileWriter(store_path);
	        filetokenStoreWriter.close();
		} catch (IOException e) {
			throw new Tokenmanagementexception
			("Error: Unable to save a new token in the internal licenses store");
		}
	}
}
