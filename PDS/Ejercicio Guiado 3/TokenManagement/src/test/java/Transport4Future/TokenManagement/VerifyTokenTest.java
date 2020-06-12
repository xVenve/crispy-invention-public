package Transport4Future.TokenManagement;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



class VerifyTokenTest  
{
	
	Tokenmanager mymanager = new Tokenmanager();
	
	
	/* Caso de Prueba: <CP1.1 - VerifyToken recibe un token no existente>
	* Técnica de prueba: Análisis Estructural - <Caminos Básicos>
	* Resultado Esperado: <Esperamos que al no existir, no lo verifique y nos devuelva false>
	*/
	
	@Test
	@DisplayName ("Buscar token no existente")
	void VerifyNonExistingToken() throws Tokenmanagementexception
	{
		String token_to_verify = "abcdegf2910394hcx3jcaads34ccs3";
		boolean result = mymanager.VERIFY_TOKEN(token_to_verify);
		assertEquals (result, false);
	}
	
	
	/* Caso de Prueba: <CP1.2 - VerifyToken recibe un token existente>
	* Técnica de prueba: Análisis Estructural - <Caminos Básicos>
	* Resultado Esperado: <Al recibir un token que si esta en el Store, puede verificar su existencia>
	*/
	
	@Test
	@DisplayName ("Buscar Token existente")
	void VerifyExistingToken() throws Tokenmanagementexception
	{
		String token_to_verify = "QWxnPT1IUzI1NlxuIFR5cD1QRFNcbkRldj1hMTIzNGI1Njc4YzEyMzR"
				+ "yMjM0NXQ2NHJmZ2h4dmVmc1xuIGlhdD0xOC8yMi8yMDIwIDEwOjAzOj"
				+ "g5MlxuIGV4cD0zMC80Ni83MDU1IDExOjA1OjAwNmMxYjBmNjMxNWQ1M"
				+ "TEzMTI0MTVlYzJjZTRhYTU2YmRiYmE0MzNkY2UwMzE4OGJjZDI5ZWM5NTEzZjM5MmUzOA==";
		boolean result = mymanager.VERIFY_TOKEN(token_to_verify);
		assertEquals (result, true);
	}
	
	
	/* Caso de Prueba: <CP2.1 - Find busca en un almacen que existe, pero sin registros,
	* 					CP3.2 - Load busca en un almacen que esta vacio>
	* Técnica de prueba: Análisis Estructural - <Pruebas de Bucles>
	* Resultado Esperado: <Esperamos que al no haber ningun registro, 
	* no itere en el bucle y al no encontrar el pedido nos devuelva false>
	*/
	
	@Test
	@DisplayName("Buscar tokens en un almacen vacio")
	void VerifyEmptyTokenStore() throws Tokenmanagementexception
	{
		this.RESET_TOKEN_STORE();
		String token_to_verify = "QWxnPT1IUzI1NlxuIFR5cD1QRFNcbkRldj1hMTIzNGI1Njc4YzEyMzR"
				+ "yMjM0NXQ2NHJmZ2h4dmVmc1xuIGlhdD0xOC8yMi8yMDIwIDEwOjAzOj"
				+ "g5MlxuIGV4cD0zMC80Ni83MDU1IDExOjA1OjAwNmMxYjBmNjMxNWQ1M"
				+ "TEzMTI0MTVlYzJjZTRhYTU2YmRiYmE0MzNkY2UwMzE4OGJjZDI5ZWM5NTEzZjM5MmUzOA==";
		boolean result = mymanager.VERIFY_TOKEN(token_to_verify);
		assertEquals(result,false);
	}
	
	
	/* Caso de Prueba: <CP2.2 - Find busca en un almacen no vacio, con 1 registro, 
	 * un registro que no esta presente,
	* 					CP3.4 - Load busca en un almacen no vacio, con 1 registro, 
	* un registro que no esta presente>
	* Técnica de prueba: Análisis Estructural - <Pruebas de Bucles>
	* Resultado Esperado: <Esperamos que haga una iteracion y al no encontrarlo devuelva false>
	*/
	
	@Test
	@DisplayName("Buscar un token que no existe en un almacen de registros")
	void VerifyTokenNonExistingToken() throws Tokenmanagementexception
	{
		this.INSERT_FIRST_TOKEN();
		String token_to_verify = "abCdEGf2910394HCX3JCAAAADS34Ccs3";
		boolean result = mymanager.VERIFY_TOKEN(token_to_verify);
		assertEquals(result,false);
	}
	
	
	/* Caso de Prueba: <CP2.3 - Find recibe un token no existente>
	* Técnica de prueba: Análisis Estructural - <Caminos Básicos>
	* Resultado Esperado: <Esperamos que al no existir el token que busca nos devuelva false>
	*/
	
	@Test
	@DisplayName ("Buscar un token que existe en un almacen")
	void VerifyTokenCorrectTest() throws Tokenmanagementexception
	{
		this.INSERT_FIRST_TOKEN();
		String token_to_verify = "QWxnPT1IUzI1NlxuIFR5cD1QRFNcbkRldj1hMTIzNGI1Njc4YzEyMzR"
				+ "yMjM0NXQ2NHJmZ2h4dmVmc1xuIGlhdD0xOC8yMi8yMDIwIDEwOjAzOj"
				+ "g5MlxuIGV4cD0zMC80Ni83MDU1IDExOjA1OjAwNmMxYjBmNjMxNWQ1M"
				+ "TEzMTI0MTVlYzJjZTRhYTU2YmRiYmE0MzNkY2UwMzE4OGJjZDI5ZWM5NTEzZjM5MmUzOA==";
		boolean result = mymanager.VERIFY_TOKEN(token_to_verify);
		assertEquals(result,true);

	}
	
	
	/* Caso de Prueba: <CP3.1 - Load busca un token en un almacen que no existe>
	* Técnica de prueba: Análisis Estructural - <Caminos Básicos>
	* Resultado Esperado: <Esperamos que al no existir el almacen nos devuelva false>
	*/
	
	@Test
	@DisplayName ("Buscar un token cuando el almacen no existe")
	void VerifytokenNonExistingTokenStore() throws Tokenmanagementexception
	{
		String store_path = System.getProperty("user.dir") + "/Store/tokenStore.json";
		File file = new File (store_path);
		file.delete();
		String token_to_verify = "QWxnPT1IUzI1NlxuIFR5cD1QRFNcbkRldj1hMTIzNGI1Njc4YzEyMzR"
				+ "yMjM0NXQ2NHJmZ2h4dmVmc1xuIGlhdD0xOC8yMi8yMDIwIDEwOjAzOj"
				+ "g5MlxuIGV4cD0zMC80Ni83MDU1IDExOjA1OjAwNmMxYjBmNjMxNWQ1M"
				+ "TEzMTI0MTVlYzJjZTRhYTU2YmRiYmE0MzNkY2UwMzE4OGJjZDI5ZWM5NTEzZjM5MmUzOA==";
		boolean result = mymanager.VERIFY_TOKEN(token_to_verify);
		assertEquals(result,true);

	}

	
	/* Caso de Prueba: <CP3.2 - Load busca en un almacen con dos tokens, 
	 * un token que existe en ese registro,
	* 					CP2.4 - Find busca en un almacen con dos tokens, 
	* un token que existe en ese registro>
	* Técnica de prueba: Análisis Estructural - <Pruebas de Bucles>
	* Resultado Esperado: <Esperamos que haga dos iteracion y al encontrarlo devuelva true>
	*/
	
	@Test
	@DisplayName ("Token Valido 2 vueltas bucle")
	void VerifyValidToken() throws Tokenmanagementexception
	{
		this.INSERT_FIRST_TOKEN();
		this.INSERT_SECOND_TOKEN();
		String token_to_verify = "QWxnPT1IUzI1NlxuIFR5cD1QRFNcbkRldj1hMTIzNGI1Njc4YzEyMzR"
				+ "yMjM0NXQ2NHJmZ2h4dmVmc1xuIGlhdD0xOC8yMi8yMDIwIDEwOjAzOj"
				+ "g5MlxuIGV4cD0zMC80Ni83MDU1IDExOjA1OjAwNmMxYjBmNjMxNWQ1M"
				+ "TEzMTI0MTVlYzJjZTRhYTU2YmRiYmE0MzNkY2UwMzE4OGJjZDI5ZWM5NTEzZjM5MmUzOA==";
		boolean result = mymanager.VERIFY_TOKEN(token_to_verify);
		assertEquals(result,true);
	}

	
	/* Caso de Prueba: <CP3.5 - Load busca en un almacen con N tokenss, 
	 * un token que existe en ese registro,
	* 					CP2.5 - Find busca en un almacen con N tokens, 
	* un token que existe en ese registro>
	* Técnica de prueba: Análisis Estructural - <Caminos Básicos>
	* Resultado Esperado: <Esperamos que haga las N iteracion y al encontrarlo devuelva true>
	*/
	
	@Test
	@DisplayName ("Token Valido 10 vueltas bucle")
	void VerifyValidNTimesToken() throws Tokenmanagementexception
	{
		this.INSERT_FIRST_TOKEN();
		for(int i=0; i<10; i++) 
		{
			String input_file = System.getProperty("user.dir") + 
					"/src/test/resources/CorrectSyntaxPruebaBucleMax"+i+".json";
			mymanager.REQUEST_TOKEN(input_file);
		}
		String token_to_verify = "QWxnPT1IUzI1NlxuIFR5cD1QRFNcbkRldj1hMTIzNGI1Njc4YzEyMzR"
				+ "yMjM0NXQ2NHJmZ2h4dmVmc1xuIGlhdD0xOC8yMi8yMDIwIDEwOjAzOj"
				+ "g5MlxuIGV4cD0zMC80Ni83MDU1IDExOjA1OjAwNmMxYjBmNjMxNWQ1M"
				+ "TEzMTI0MTVlYzJjZTRhYTU2YmRiYmE0MzNkY2UwMzE4OGJjZDI5ZWM5NTEzZjM5MmUzOA==";
		boolean result = mymanager.VERIFY_TOKEN(token_to_verify);
		assertEquals(result,true);
	}

	
	/* Caso de Prueba: <CP4.1 - isExpired recibe un token expirado>
	* Técnica de prueba: Análisis Estructural - <Caminos Básicos>
	* Resultado Esperado: <Esperamos al haber expirado nos devuelva false>
	*/
	
	@Test
	@DisplayName ("Token Expirado")
	void VerifyExpiredToken() throws Tokenmanagementexception
	{
		this.INSERT_FIRST_TOKEN();
		String token_to_verify = "OWQzZmJjNThjZGM5YmRhZGMzMzdhMmVmMjkwYzU"
				+ "xNDVhMDViMmNhZGI4N2QyNDg5YWU4YTBhYTY5MjI2ZTNlNA==";
		boolean result = mymanager.VERIFY_TOKEN(token_to_verify);
		assertEquals(result,false);
	}

	
	/* Caso de Prueba: <CP4.2 - isExpired recibe un token que no ha expirado>
	* Técnica de prueba: Análisis Estructural - <Caminos Básicos>
	* Resultado Esperado: <Esperamos al no haber expirado nos devuelva true>
	*/
	
	@Test
	@DisplayName ("Token no Expirado")
	void VerifyNotExpiredToken() throws Tokenmanagementexception
	{
		this.INSERT_FIRST_TOKEN();
		String token_to_verify = "QWxnPT1IUzI1NlxuIFR5cD1QRFNcbkRldj1hMTIzNGI1Njc4YzEyMzR"
				+ "yMjM0NXQ2NHJmZ2h4dmVmc1xuIGlhdD0xOC8yMi8yMDIwIDEwOjAzOj"
				+ "g5MlxuIGV4cD0zMC80Ni83MDU1IDExOjA1OjAwNmMxYjBmNjMxNWQ1M"
				+ "TEzMTI0MTVlYzJjZTRhYTU2YmRiYmE0MzNkY2UwMzE4OGJjZDI5ZWM5NTEzZjM5MmUzOA==";
		boolean result = mymanager.VERIFY_TOKEN(token_to_verify);
		assertEquals(result,true);
	}
	
	
	/* Caso de Prueba: <CP5.1 - isGranted recibe un token con fecha de creacion posterior a la actual>
	* Técnica de prueba: Análisis Estructural - <Caminos Básicos>
	* Resultado Esperado: <Esperamos al no ser correcta nos devuelva false>
	*/
	
	@Test
	@DisplayName ("Token Creado en fecha posterior")
	void VerifyCreationDateToken() throws Tokenmanagementexception
	{
		this.INSERT_FIRST_TOKEN();
		String token_to_verify = "M2NhYjRlOTE1OGI3OTczOGM2YjA5YTRjYmY1MmY2N"
				+ "jg1MTAwMWIzZmZjNzg4MDk4YjljZTI4NDU5OTk3NjNlZg==";
		boolean result = mymanager.VERIFY_TOKEN(token_to_verify);
		assertEquals(result,false);
	}
	
	
	/* Caso de Prueba: <CP5.2 - isGranted recibe un token con fecha de creacion anterior a la actual>
	* Técnica de prueba: Análisis Estructural - <Caminos Básicos>
	* Resultado Esperado: <Esperamos al recibir una fecha correcta nos devuelva true>
	*/
	
	@Test
	@DisplayName ("Token creado en fecha valida")
	void VerifyIncorrectCreationDateToken() throws Tokenmanagementexception
	{
		this.INSERT_FIRST_TOKEN();
		String token_to_verify = "QWxnPT1IUzI1NlxuIFR5cD1QRFNcbkRldj1hMTIzNGI1Njc4YzEyMzR"
				+ "yMjM0NXQ2NHJmZ2h4dmVmc1xuIGlhdD0xOC8yMi8yMDIwIDEwOjAzOj"
				+ "g5MlxuIGV4cD0zMC80Ni83MDU1IDExOjA1OjAwNmMxYjBmNjMxNWQ1M"
				+ "TEzMTI0MTVlYzJjZTRhYTU2YmRiYmE0MzNkY2UwMzE4OGJjZDI5ZWM5NTEzZjM5MmUzOA==";
		boolean result = mymanager.VERIFY_TOKEN(token_to_verify);
		assertEquals(result,true);
	}
	
	private void RESET_TOKEN_STORE () throws Tokenmanagementexception 
	{
		String store_path = System.getProperty("user.dir") + "/Store/tokenStore.json";
		FileWriter file_writer;
		try {
			file_writer = new FileWriter (store_path);
			file_writer.close();
			
		}catch (IOException e){
			throw new Tokenmanagementexception ("Error: unable to save a new token");
		}
	}
	
		private void INSERT_FIRST_TOKEN() throws Tokenmanagementexception
		{
			this.RESET_TOKEN_STORE();
			String input_file = System.getProperty("user.dir") + 
					"/src/test/resources/CorrectSyntax2.json";
			mymanager.REQUEST_TOKEN(input_file);
			
		}
		private void INSERT_SECOND_TOKEN() throws Tokenmanagementexception
		{
			String input_file = System.getProperty("user.dir") + 
					"/src/test/resources/CorrectSyntax2-Nappears.json";
			mymanager.REQUEST_TOKEN(input_file);
			
		}
		
	
	
	
}


