package Transport4Future.TokenManagement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Verifytokentest 
{
	private Tokenmanager my_manager;
	
	public Verifytokentest () 
	{
		 my_manager = Tokenmanager.GET_INSTANCE();
	}
	
	private void RESET_TOKEN_STORE () throws Tokenmanagementexception 
	{
		String storePath = System.getProperty("user.dir") + "/Store/tokenStore.json";
        FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(storePath);
	        fileWriter.close();
		} catch (IOException e) {
			throw new Tokenmanagementexception
			("Error: Unable to save a new token in the internal licenses store");
		}		
	}
	
	private void INSERT_FIRST_TOKEN () throws Tokenmanagementexception 
	{
		this.RESET_TOKEN_STORE();
		String inputFile = 
				System.getProperty("user.dir") + "/TestData/TokenRequestTest/CorrectTokenRequest.json";
		my_manager.REQUEST_TOKEN(inputFile);
	}
	
	private void INSERT_SECOND_TOKEN () throws Tokenmanagementexception 
	{
		String inputFile = 
				System.getProperty("user.dir") + 
				"/TestData/TokenRequestTest/SecondCorrectTokenRequest.json";
		my_manager.REQUEST_TOKEN(inputFile);		
	}
	
	@Test
	@DisplayName("RF03 - TC01 - Buscar un token en un almacén de tokens vacío")
	void VerifyTokenEmptyTokenStore() throws Tokenmanagementexception 
	{
		this.RESET_TOKEN_STORE();
		String tokenToVerify = "ABxnPUhTMjU2XG4gVHlwPVBEU1xuRGV2PTI3OGU3ZTI3NzMyYzRlNTM5NDZjZjIwMDU4YWQ4MTM4X"
				+ "G4gaWF0PTE4LTAzLTIwMjAgMTA6MjI6MjBcbiBleHA9MjUtMDMtMjAyMCAxMDoyMjoyMGIzYWMwYjRkNjQ"
				+ "yOTE1OGRhMTI4NzYxZTk4Y2U4MzE3ZmE5MjhkNDJjNzEwYTlkMDZmNjRjOTY2N2JkZDM3MWM=\"";
		boolean result = my_manager.VERIFY_TOKEN(tokenToVerify);
		assertEquals (false,result);
	}
	
	@Test
	@DisplayName("RF03 - TC02 - Buscar un token que no existe en un almacén de registros que contiene un elemento")
	void VerifyTokenNonExistingToken() throws Tokenmanagementexception 
	{
		this.INSERT_FIRST_TOKEN();
		String tokenToVerify = "ABxnPUhTMjU2XG4gVHlwPVBEU1xuRGV2PTI3OGU3ZTI3NzMyYzRlNTM5NDZjZjIwMDU4YWQ4MTM4X"
				+ "G4gaWF0PTE4LTAzLTIwMjAgMTA6MjI6MjBcbiBleHA9MjUtMDMtMjAyMCAxMDoyMjoyMGIzYWMwYjRkNjQyO"
				+ "TE1OGRhMTI4NzYxZTk4Y2U4MzE3ZmE5MjhkNDJjNzEwYTlkMDZmNjRjOTY2N2JkZDM3MWM=\"";
		boolean result = my_manager.VERIFY_TOKEN(tokenToVerify);
		assertEquals (false,result);
	}
	
	@Test
	@DisplayName("RF03 - TC03 - Buscar un token que existe en almacén con registros")
	void VerifyTokenCorrectTest() throws Tokenmanagementexception 
	{
		this.INSERT_FIRST_TOKEN();
		String tokenToVerify = "QWxnPUhTMjU2XG4gVHlwPVBEU1xuRGV2PTI3OGU3ZTI3NzMyYzRlNTM5NDZjZjIwMDU4YWQ4MTM4X"
				+ "G4gaWF0PTE4LTAzLTIwMjAgMTA6MjI6MjBcbiBleHA9MjUtMDMtMjAyMCAxMDoyMjoyMGIzYWMwYjRkNjQyO"
				+ "TE1OGRhMTI4NzYxZTk4Y2U4MzE3ZmE5MjhkNDJjNzEwYTlkMDZmNjRjOTY2N2JkZDM3MWM=\"";
		boolean result = my_manager.VERIFY_TOKEN(tokenToVerify);
		assertEquals (false,result);
	}

	@Test
	@DisplayName("RF03 - TC04 - Buscar un token cuando el almacén no existe")
	void VerifyTokenNonExitingTokenStore() throws Tokenmanagementexception 
	{
		String storePath = System.getProperty("user.dir") + "/Store/tokenStore.json";
		File file = new File(storePath);
        file.delete();
		String tokenToVerify = "ABxnPUhTMjU2XG4gVHlwPVBEU1xuRGV2PTI3OGU3ZTI3NzMyYzRlNTM5NDZjZjIwMDU4YWQ4MTM4X"
				+ "G4gaWF0PTE4LTAzLTIwMjAgMTA6MjI6MjBcbiBleHA9MjUtMDMtMjAyMCAxMDoyMjoyMGIzYWMwYjRkNjQyO"
				+ "TE1OGRhMTI4NzYxZTk4Y2U4MzE3ZmE5MjhkNDJjNzEwYTlkMDZmNjRjOTY2N2JkZDM3MWM=";
		boolean result = my_manager.VERIFY_TOKEN(tokenToVerify);
		assertEquals (false,result);
	}
	
	@Test
	@DisplayName("RF03 - TC05 - Buscar un token válido")
	void VerifyValidToken() throws Tokenmanagementexception 
	{
		this.INSERT_FIRST_TOKEN();
		this.INSERT_SECOND_TOKEN();
		String tokenToVerify = "QWxnPUhTMjU2XG4gVHlwPVBEU1xuRGV2PTU3NjU5YmIwOTc4ZDQxMGIzYjc4YTg5MmM2MDRjY2I0XG4"
			+ "gaWF0PTE4LTAzLTIwMjAgMTA6MjI6MjBcbiBleHA9MTYtMDItMjAyMiAxMDoyMjoyMGEwYTc2MDc1MzkzOTRiMzNiMzM"
			+ "4NGZkYWIwNGY3ZjJkM2QzMTlkZGU3MzI2ZDQ0MmViOWQxZGRjYWYwOTU4OTg=";
		boolean result = my_manager.VERIFY_TOKEN(tokenToVerify);
		assertEquals (true,result);
	}
}