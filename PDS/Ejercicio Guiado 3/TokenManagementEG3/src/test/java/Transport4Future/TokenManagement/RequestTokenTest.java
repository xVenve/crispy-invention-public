package Transport4Future.TokenManagement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;

class RequestTokenTest 
{
private Tokenmanager mymanager;
	

	public RequestTokenTest()
	{
		mymanager = new Tokenmanager();
		
	}
	
	/* Caso de Prueba: <CSV CON CASOS DE PRUEBAS DEL ARBOL DE DERIVACION>
	* Nodo/s del Árbol de Derivación: <Valores específicos>
	* Tipo de Prueba: <Valor Normal && Omisión && Repetición>
	* Técnica de prueba: Análisis Sintáctico
	* Nota: Todas estas pruebas vienen descritas en su propio nombre y en el archivo txt que se adjunta.
	* Nota: Las pruebas que no se han contemplado, 
	* y han sido resultado del arbol se debe a que el patron que se nos da 
	* admite algunoas cosas como duplicados de hora, o que falten elementos en el email.
	*/

	
	@DisplayName("Pruebas de sintaxis")
	@ParameterizedTest(name="{index}: {1}") 
	@CsvFileSource(resources = "/GramaticCases.csv")
	public void NON_VALID_JSON_SYNTAX(String path, String name, String error) 
	{
		Tokenmanagementexception ex = 
				Assertions.assertThrows(Tokenmanagementexception.class, ()-> 
				{
					mymanager.REQUEST_TOKEN(path);
				});
		assertEquals (error, ex.GETMESSAGE());	
	}
	
	
	/* Caso de Prueba: <CEV89>
	* Nodo/s del Árbol de Derivación: <Valores específicos>
	* Tipo de Prueba: <Casos validos>
	* Técnica de prueba: Análisis Sintáctico
	* Resultado Esperado: llamamos a la funcion request token y hacemos que coincidan los resultados 
	* tras lanzarlo una vez, hemos tenido que dejar iat y exp como ctes,
	* para que no se creen tokens diferentes al insertar uno con los mismos atributos.
	*/

	
	@Test
	@DisplayName("Caso valido")
	public void VALID_CASE() throws Tokenmanagementexception 
	{
		
		String path = "src/test/resources/CorrectSyntax2.json";
		String url = "QWxnPT1IUzI1NlxuIFR5cD1QRFNcbkRldj1hMTIzNGI1Njc4YzEyMzRyMjM0NXQ2NHJmZ2h4"
				+ "dmVmc1xuIGlhdD0xOC8yMi8yMDIwIDEwOjAzOjg5MlxuIGV4cD0zMC80Ni83MDU1IDEx"
				+ "OjA1OjAwNmMxYjBmNjMxNWQ1MTEzMTI0MTVlYzJjZTRhYTU2YmRiYmE0MzNkY2UwMzE"
				+ "4OGJjZDI5ZWM5NTEzZjM5MmUzOA==";
		String result = mymanager.REQUEST_TOKEN(path);
		assertEquals (result, url);	
	}
	
	/* Caso de Prueba: <CEV90>
	* Nodo/s del Árbol de Derivación: <Valores específicos>
	* Tipo de Prueba: <Casos validos>
	* Técnica de prueba: Análisis Sintáctico
	* Resultado Esperado: llamamos a la funcion request token y hacemos que coincidan los resultados 
	* tras lanzarlo una vez,hemos tenido que dejar iat y exp como ctes,
	* para que no se creen tokens diferentes  al insertar uno con los mismos atributos, 
	* en este caso hemos duplicado un atributo, sabiendo que json 
	* siempre se queda con el valor del último de los repetidos.
	*/
	
	@Test
	@DisplayName("Caso valido (Nappears)")
	public void VALID_CASE_NAPPEARS() throws Tokenmanagementexception 
	{
		
		String path = "src/test/resources/CorrectSyntax2-Nappears.json";
		String url = "QWxnPT1IUzI1NlxuIFR5cD1QRFNcbkRldj1hMTIzNGI1Njc4YzEyMzRyMjM0NX"
				+ "Q2NHJmZ2hudmVmc1xuIGlhdD0xOC8yMi8yMDIwIDEwOjAzOjg5MlxuIGV4cD0zMC8"
				+ "0Ni83MDU1IDExOjA1OjAwODdlNmUzY2I5OGY5MmI3MzBjMThhYmJmZTAxZWE1YzV"
				+ "iMTFiNGVjMjFkOWFhM2ZjZDc3MjlhODI0NTkxZjI2Nw==";
		String result = mymanager.REQUEST_TOKEN(path);
		assertEquals (result, url);	
	}

		}
	


