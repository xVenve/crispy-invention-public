package Transport4Future.TokenManagement;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;

class TokenRequestGenerationTest
{
	private Tokenmanager mymanager;

	public TokenRequestGenerationTest()
	{
		mymanager = new Tokenmanager();

	}


/* Caso de Prueba: <CP1 - Fichero no existe>
* Clase de Equivalencia o Valor Límite Asociado: <CEI2 - Ruta a un fichero que no existe>
* Técnica de prueba: <Clases de Equivalencia>
* Resultado Esperado: <Esperamos que salte la excepcion: 'Error: input file not found.'>
*/

	@Test
	public void NON_EXISTING_FILE()
	{
		String inputfilepath = "./TestData/TokenRequestGeneration/NonExistingFile.json";
		String expectedmessage = "Error: input file not found.";
		Tokenmanagementexception ex =
				Assertions.assertThrows(Tokenmanagementexception.class, ()->
				{
					mymanager.TOKENREQUESTGENERATION(inputfilepath);
				});
		assertEquals (expectedmessage, ex.GETMESSAGE());
	}


/* Caso de Prueba: <CP2 - Fichero que no cumple la sintaxis JSON>
* Clase de Equivalencia o Valor Límite Asociado: <CEI4 - El fichero de entrada no cumple la sintaxis JSON>
* Técnica de prueba: <Clases de Equivalencia>
* Resultado Esperado: <Esperamos que salte la excepcion: 
* 'Error: JSON object cannot be created due to incorrect representation'>
*/

	@Test
	public void NON_VALID_JSON_SYNTAX()
	{
		String inputfilepath = "src/test/resources/InvalidSyntax.json";
		String expectedmessage = "Error: JSON object cannot be created "
				+ "due to incorrect representation";
		Tokenmanagementexception ex =
				Assertions.assertThrows(Tokenmanagementexception.class, ()->
				{
					mymanager.TOKENREQUESTGENERATION(inputfilepath);
				});
		assertEquals (expectedmessage, ex.GETMESSAGE());

	}


	/* Caso de Prueba: <CP12 - Email es un correo incorrecto>
	* Clase de Equivalencia o Valor Límite Asociado: <CEI24 - El valor de email es un correo incorrecto>
	* Técnica de prueba: <Clases de Equivalencia>
	* Resultado Esperado: <Esperamos que salte la excepcion: 
	* 'Error: invalid Device Name data in JSON structure.'>
	*/

	@Test
	public void NON_VALID_EMAIL()
	{
		String expectedmessage = "Error: invalid E-mail data in JSON structure.";
		String inputfilepath = "src/test/resources/InvalidMail.json";
		Tokenmanagementexception ex =
				Assertions.assertThrows(Tokenmanagementexception.class, ()->
				{
					mymanager.TOKENREQUESTGENERATION(inputfilepath);
				});

		assertEquals (expectedmessage, ex.GETMESSAGE());
	}


	/* Caso de Prueba: <CP3 - La etiqueta no se corresponde a DeviceName,
	* 					CP8 - Etiqueta de TypeOfDevice errónea,
	* 					CP13 - Email tiene una etiqueta no valida,
	* 					CP15 - DriverVersion no tiene una etiqueta correcta,
	* 					CP21 - SerialNumber tiene una etiqueta incorrecta,
	* 					CP26 - MacAddress tiene una etiqueta incorrecta>
	* Clase de Equivalencia o Valor Límite Asociado: <CEI6 - La etiqueta es distinta a "DeviceName",
	*CEI14 - Etiqueta errónea,
	*CEI23 - Etiqueta incorrecta,
	*CEI28 - Etiqueta incorrecta,
	*CEI39 - Etiqueta incorrecta,
	*CEI47 - Etiqueta incorrecta>
	* Técnica de prueba: <Clases de Equivalencia>
	* Resultado Esperado: <Esperamos que salte la excepcion: 
	* 'Error: XX not found.' donde XX corresponde al campo que no ha podido encontrar>
	*/

	@DisplayName("Pruebas de tags")
	@ParameterizedTest(name="{index}: {1}")
	@CsvFileSource(resources = "/incorrect_tags.csv")
	public void INVALID_TAG_TEST(String ruta, String prueba, String mensajeerror)
	{
		Tokenmanagementexception ex =
				Assertions.assertThrows(Tokenmanagementexception.class, ()->
				{
					mymanager.TOKENREQUESTGENERATION(ruta);
				});
		assertEquals (mensajeerror, ex.GETMESSAGE());
	}


	/* Caso de Prueba: <CP6 - Límite inferior ya comprobado con "", que es longitud inferior,
	*CP18 - Límite inferior ya comprobado con "", que es longitud inferior,
	*CP19 - El valor de DriverVersion es "",
	*CP24 - SerialNumber tiene el valor "",
	*CP29 - MacAddress tiene como valor "">
	*
	* Clase de Equivalencia o Valor Límite Asociado: <Límite inferior
	* 
	*CEI8 - El valor sobre DeviceName es "",
	*CEI34 - La longitud de DriverVersion no está entre 1 y 25 caracteres,
	*CEI36 - El valor de DeviceName es "",
	*CEI44 - Serial Number es "",
	*CEI52 - MacAddress es "">
	* Técnica de prueba: <Valor Límite>
	* Resultado Esperado: <Esperamos que salte la excepcion: 
	* 'Error: XX invalid entry.' donde XX es la entrada con longitud 0>
	*/

	@DisplayName("Pruebas de comillas")
	@ParameterizedTest(name="{index}: {1}")
	@CsvFileSource(resources = "/incorrect_empty_entry.csv")
	public void EMPTY_ENTRY_TEST(String filepath, String name, String error)
	{
		Tokenmanagementexception ex =
				Assertions.assertThrows(Tokenmanagementexception.class, ()->
				{
					mymanager.TOKENREQUESTGENERATION(filepath);
				});
		assertEquals (error, ex.GETMESSAGE());
	}


	/* Caso de Prueba: <CP6 - DeviceName tiene una longitud mayor a 20 o una menor a 1>
	* Clase de Equivalencia o Valor Límite Asociado: <BAV - Se prueba el límite superior>
	* Técnica de prueba: <Valor Límite>
	* Resultado Esperado: <Esperamos que salte la excepcion: 'Error: Invalid length on Device Name.'>
	*/

	@Test
	public void INVALID_LENGTH_DN ()
	{
		String filepath = "src/test/resources/InvalidLengthDN.json";
		String error = "Error: Invalid length on Device Name.";
		Tokenmanagementexception ex =
				Assertions.assertThrows(Tokenmanagementexception.class, ()->
				{
					mymanager.TOKENREQUESTGENERATION(filepath);
				});
		assertEquals (error, ex.GETMESSAGE());
	}


	/* Caso de Prueba: <CP18 - DriverVersion no está entre 3 y 25 caracteres>
	* Clase de Equivalencia o Valor Límite Asociado: <BAV - Se prueba el límite superior>
	* Técnica de prueba: <Valor Límite>
	* Resultado Esperado: <Esperamos que salte la excepcion: 'Error: Invalid length on Driver Version.'>
	*/

	@Test
	public void INVALID_LENGTH_DV ()
	{
		String filepath = "src/test/resources/InvalidLengthDV.json";
		String error = "Error: Invalid length on Driver Version.";
		Tokenmanagementexception ex =
				Assertions.assertThrows(Tokenmanagementexception.class, ()->
				{
					mymanager.TOKENREQUESTGENERATION(filepath);
				});
		assertEquals (error, ex.GETMESSAGE());
	}


	/* Caso de Prueba: <CP16 - Formato invalido de DriverVersion>
	* Clase de Equivalencia o Valor Límite Asociado: <CEI29>
	* Técnica de prueba: <Clases de Equivalencia>
	* Resultado Esperado: <Esperamos que salte la excepcion: 
	* 'Error: invalid Driver Version data in JSON structure.'>
	*/

	@Test
	public void INVALID_PATTERN_DV()
	{
		String filepath = "src/test/resources/InvalidPatternDV.json";
		String error = "Error: invalid Driver Version data in JSON structure.";
		Tokenmanagementexception ex =
				Assertions.assertThrows(Tokenmanagementexception.class, ()->
				{
					mymanager.TOKENREQUESTGENERATION(filepath);
				});
		assertEquals (error, ex.GETMESSAGE());

	}


	/* Caso de Prueba: <CP4 - Formato invalido de Device Name>
	* Clase de Equivalencia o Valor Límite Asociado: <CEI6>
	* Técnica de prueba: <Clases de Equivalencia>
	* Resultado Esperado: <Forzamos a que device name tenga numeros y esperamos a que salte una exce>
	*/

	@Test
	public void INVALID_PATTERN_DN()
	{
		String filepath = "src/test/resources/InvalidPatternDN.json";
		String error = "Error: invalid Device Name data in JSON structure.";
		Tokenmanagementexception ex =
				Assertions.assertThrows(Tokenmanagementexception.class, ()->
				{
					mymanager.TOKENREQUESTGENERATION(filepath);
				});
		assertEquals (error, ex.GETMESSAGE());

	}


/* Caso de Prueba: <CP10 - Formato incorrecto de Type of Device>
* Clase de Equivalencia o Valor Límite Asociado: <CEI17>
* Técnica de prueba: <Clases de Equivalencia>
* Resultado Esperado: <Esperamos que Type Of Device no tenga el formato admitido y salte una excepcion,
* indicando que ese valor no es adecuado>
*/

	@Test
	public void INVALID_PATTERN_TOD()
	{
		String filepath = "src/test/resources/InvalidPatternToD.json";
		String error = "Error: invalid Type Of Device data in JSON structure.";
		Tokenmanagementexception ex =
				Assertions.assertThrows(Tokenmanagementexception.class, ()->
				{
					mymanager.TOKENREQUESTGENERATION(filepath);
				});
		assertEquals (error, ex.GETMESSAGE());

	}


/* Caso de Prueba: <CP22 - Valor incorrrecto de Serial Number>
* Clase de Equivalencia o Valor Límite Asociado: <CEI40>
* Técnica de prueba: <Clases de Equivalencia>
* Resultado Esperado: <Esperamos que serial number no tenga el formato inválido, 
* no pase el pattern y salte una excepcion>
*/

	@Test
	public void INVALID_PATTERN_SN()
	{
		String filepath = "src/test/resources/InvalidPatternSN.json";
		String error = "Error: invalid Serial Number data in JSON structure.";
		Tokenmanagementexception ex =
				Assertions.assertThrows(Tokenmanagementexception.class, ()->
				{
					mymanager.TOKENREQUESTGENERATION(filepath);
				});
		assertEquals (error, ex.GETMESSAGE());

	}


/*Caso de Prueba: <CP12 - Valor incorrecto de email>
* Clase de Equivalencia o Valor Límite Asociado: <CEI24>
* Técnica de prueba: <Clases de Equivalencia>
* Resultado Esperado: <Esperamos que nuestro email no cumpla los requisitos del pattern y salte una excepción>
*/

	@Test
	public void INVALID_PATTERN_MAC()
	{
		String filepath = "src/test/resources/InvalidPatternMAC.json";
		String error = "Error: invalid MAC Address data in JSON structure.";
		Tokenmanagementexception ex =
				Assertions.assertThrows(Tokenmanagementexception.class, ()->
				{
					mymanager.TOKENREQUESTGENERATION(filepath);
				});
		assertEquals (error, ex.GETMESSAGE());

	}


/*Caso de Prueba: <CEV - Clases de prueba validas>
* Clase de Equivalencia o Valor Límite Asociado: <Todas las clases válidas>
* Técnica de prueba: <Clases de Equivalencia>
* Resultado Esperado: <Esperamos que no salte ninguna excepcion, 
* y que el resultado de nuestra encriptación sea la misma que la del método>
*/

	@DisplayName("Pruebas validas")
	@ParameterizedTest(name="{index}: {1}")
	@CsvFileSource(resources = "/valid_cases.csv")
	public void VALID_JSON(String filepath, String name,String device_name,String type_device,
			String driver_version,String email, String serial_number,
			String mac_address) throws Tokenmanagementexception
	{
		String result = mymanager.TOKENREQUESTGENERATION(filepath);
		Tokenrequest test = new Tokenrequest(device_name,type_device,driver_version,email,
				serial_number,mac_address);
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new Tokenmanagementexception("Error: no such hashing algorithm.");
		}

		String input = test.toString();

		md.update(input.getBytes(StandardCharsets.UTF_8));
		byte[] digest = md.digest();

		String hex = String.format("%32x", new BigInteger(1, digest));
		assertEquals(hex,result);

	}
}
