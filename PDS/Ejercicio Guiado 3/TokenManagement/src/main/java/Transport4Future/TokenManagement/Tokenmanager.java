package Transport4Future.TokenManagement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import java.text.SimpleDateFormat;

import java.util.Base64;
import java.util.Date;
import java.util.regex.Pattern;

import javax.json.Json;
import javax.json.JsonObject;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;






public class Tokenmanager
{
	
    Tokenstore store = new Tokenstore ();

//FUNCIONALIDAD 1
	public String TOKENREQUESTGENERATION(String path)
			throws Tokenmanagementexception
	{
		Tokenrequest req = null;
		String file_contents = "";
		BufferedReader reader;
		
		

		try {
			reader = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			throw new Tokenmanagementexception("Error: input file not found.");
		}

		String line;
		try {
			while ((line = reader.readLine()) != null)
			{
				file_contents += line;
			}
		} catch (IOException e) {
			throw new Tokenmanagementexception
			("Error: input file could not be accessed.");
		}
		
		JsonObject jsonlicense = null;
		try(StringReader sr = new StringReader(file_contents)) {
			jsonlicense = Json.createReader(sr).readObject();
		} catch(Exception e) {
			throw new Tokenmanagementexception("Error: JSON "
					+ "object cannot be created due to incorrect "
					+ "representation");
		}
		
		try {
			reader.close();
		} catch (IOException e) {
			throw new Tokenmanagementexception
			("Error: input file could not be closed.");
		}

		JsonObject json_license = Json.createReader
				(new StringReader(file_contents)).readObject();
		
		try {
			String device_name = json_license.getString("Device Name");

		}catch (Exception e)  
		{
			throw new Tokenmanagementexception
			("Error: Device Name not found.");
		}
		try {
			String type_of_device = json_license.getString("Type of Device");

		}catch (Exception e)  
		{
			throw new Tokenmanagementexception
			("Error: Type of Device not found.");
		}
		
		try {
			String driverversion = json_license.getString("Driver Version");

		}catch (Exception e)  
		{
			throw new Tokenmanagementexception
			("Error: Driver Version not found.");
		}
		try {
			String serialnumber = json_license.getString("Serial Number");

		}catch (Exception e)  
		{
			throw new Tokenmanagementexception
			("Error: Serial Number not found.");
		}
		try {
			String supportemail = json_license.getString("Support e-mail");

		}catch (Exception e)  
		{
			throw new Tokenmanagementexception
			("Error: Support e-mail not found.");
		}
		try {
			String macaddress = json_license.getString("MAC Address");

		}catch (Exception e)  
		{
			throw new Tokenmanagementexception
			("Error: MAC Address not found.");
		}
		
		try {
			
			
			String device_name = json_license.getString("Device Name");
			String type_device = json_license.getString("Type of Device");
			String driver_version = json_license.getString("Driver Version");
			String email = json_license.getString("Support e-mail");
			String serial_number = json_license.getString("Serial Number");
			String mac_address = json_license.getString("MAC Address");
			

			req=new Tokenrequest(device_name,type_device, driver_version,
					email, serial_number, mac_address);
		

		} catch (Exception pe) {
			throw new Tokenmanagementexception
			("Error: invalid input data in JSON structure.");
		}
		
		
		//Comprobacion patron Device Name
				Pattern devicepattern = Pattern.compile("(?<=\\\\s|^)[a-zA-Z]"
						+ "*(?=[.,;:]?\\\\s|$)");
				if (!devicepattern.matcher(req.GETDEVICE_NAME()).matches()) 
				{					
				throw new Tokenmanagementexception("Error: invalid Device Name "
						+ "data in JSON structure.");	
				}
		//Comprobacion patron email
		Pattern mailpattern = Pattern.compile("(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^"
				+ "()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\"
				+ "Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?"
				+ ":(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n"
				+ ")?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\"
				+ "n)?[\\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r"
				+ "\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@("
				+ "?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:"
				+ "(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\"
				+ "[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:"
				+ "\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:("
				+ "?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[(["
				+ "^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,"
				+ ";:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=["
				+ "\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:"
				+ "\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ "
				+ "\\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
				+ "\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\"
				+ "]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?"
				+ "[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n"
				+ ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
				+ "\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ "
				+ "\\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?["
				+ " \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
				+ "\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t"
				+ "])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ "
				+ "\\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\"
				+ "]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?"
				+ "(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])"
				+ "+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|"
				+ "\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\."
				+ "(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]"
				+ "+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))"
				+ "|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r"
				+ "\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\"
				+ "] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\"
				+ "\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ "
				+ "\\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] "
				+ "\\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\"
				+ "\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t]"
				+ ")*))*\\>(?:(?:\\r\\n)?[ \\t])*)|(?:[^()<>@,;:\\\\\".\\[\\] \\0"
				+ "00-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\""
				+ ".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\""
				+ "(?:(?:\\r\\n)?[ \\t])*)*:(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@"
				+ ",;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=["
				+ "\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:"
				+ "\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ "
				+ "\\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?["
				+ " \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r"
				+ "\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@("
				+ "?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:"
				+ "(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\"
				+ "[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:"
				+ "\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?"
				+ ":\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\"
				+ "[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:"
				+ "\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=["
				+ "\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:"
				+ "\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ "
				+ "\\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
				+ "\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\["
				+ "\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r"
				+ "\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:"
				+ "\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^"
				+ "\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:"
				+ "\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?"
				+ ":(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\"
				+ "[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:"
				+ "(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?"
				+ ":(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))"
				+ "|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:"
				+ "(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\0"
				+ "31]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\"
				+ "[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?"
				+ ":(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:"
				+ "\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=["
				+ "\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?"
				+ ":\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?"
				+ "[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
				+ "\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\"
				+ "[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r"
				+ "\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:("
				+ "?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[("
				+ "[^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:"
				+ "\\r\\n)?[ \\t])*)(?:,\\s*(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-"
				+ "\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\""
				+ ".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))"
				+ "*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^"
				+ "()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+"
				+ "|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|"
				+ "\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:"
				+ "(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+"
				+ "(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\["
				+ "\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t]"
				+ ")*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] "
				+ "\\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,"
				+ ";:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r"
				+ "\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+("
				+ "?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]"
				+ "]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:"
				+ "(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<"
				+ ">@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|"
				+ "\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]"
				+ "|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ "
				+ "\\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
				+ "\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^"
				+ "\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:"
				+ "(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+"
				+ "(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]"
				+ "]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)"
				+ "(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\00"
				+ "0-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:"
				+ "\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r"
				+ "\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:"
				+ "\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|("
				+ "?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|"
				+ "(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?"
				+ ":\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+("
				+ "?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]"
				+ "]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:("
				+ "?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:"
				+ "\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?"
				+ "=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)"
				+ "*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:"
				+ "[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t"
				+ "])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
				+ "\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?"
				+ "[ \\t])*))*)?;\\s*)");
		if (!mailpattern.matcher(req.GETSUPPORT_EMAIL()).matches()) 
		{
			throw new Tokenmanagementexception("Error: invalid E-mail "
					+ "data in JSON structure.");	
		}
		//Comprobacion patron Driver Version
		Pattern dvpattern = Pattern.compile("(?!\\.)(\\d+(\\.\\d+)+)"
				+ "(?![\\d\\.])$");
		if (!dvpattern.matcher(req.GETDRIVER_VERSION()).matches()) 
		{
			throw new Tokenmanagementexception("Error: invalid Driver Version data "
					+ "in JSON structure.");
		}
		//Comprobacion patron Type Of Device
		if (!json_license.getString("Type of Device").equals("Sensor") && !
				json_license.getString("Type of Device").equals("Actuator")) 
		{
			throw new Tokenmanagementexception("Error: invalid Type Of Device data"
					+ " in JSON structure.");
		}
		//Comprobacion patron Serial Number
		Pattern snpattern = Pattern.compile("^[a-zA-Z0-9-]*$");
		if (!snpattern.matcher(req.GETSERIAL_NUMBER()).matches()) 
		{
			throw new Tokenmanagementexception("Error: invalid Serial Number data "
					+ "in JSON structure.");
		}
		//Comprobacion patron MAC Address
		
		Pattern macpattern = Pattern.compile("^([0-9A-Fa-f]{2}[:-])"
				+ "{5}([0-9A-Fa-f]{2})$");
		if (!macpattern.matcher(req.GETMAC_ADDRESS()).matches()) 
		{
			throw new Tokenmanagementexception("Error: invalid MAC "
					+ "Address data in JSON structure.");
		}
		
		
		//Comprobaciones ""
		if (json_license.getString("Device Name").equals("")) 
		{
			throw new Tokenmanagementexception("Error: Device Name "
					+ "invalid entry.");	
			}

		if (json_license.getString("Driver Version").equals("")) 
		{
			throw new Tokenmanagementexception("Error: Driver Version "
					+ "invalid entry.");	
			}

		if (json_license.getString("MAC Address").equals("")) 
		{
			throw new Tokenmanagementexception("Error: MAC Address "
					+ "invalid entry.");	
			}

		if (json_license.getString("Serial Number").equals("")) 
		{
			throw new Tokenmanagementexception("Error: Serial Number "
					+ "invalid entry.");	
			}
		
		
		
		//Comprobaciones length
		
		if(json_license.getString("Device Name").length()>20 || 
				json_license.getString("Device Name").length()<1) 
		{
			throw new Tokenmanagementexception("Error: Invalid length on Device Name.");
		}
		
		
		if(json_license.getString("Driver Version").length()>25 || 
				json_license.getString("Driver Version").length()<3) 
		{
			throw new Tokenmanagementexception("Error: Invalid length on"
					+ " Driver Version.");
		}
		
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new Tokenmanagementexception("Error: no such hashing algorithm.");
		}
		
		String input = req.toString();
		
		md.update(input.getBytes(StandardCharsets.UTF_8));
		byte[] digest = md.digest();

		// Beware the hex length. If MD5 -> 32:"%032x", but for instance, 
		//in SHA-256 it should be "%064x" 
		String hex = String.format("%32x", new BigInteger(1, digest));

		return hex;
	}
	
//FUNCIONALIDAD 2 
	public String REQUEST_TOKEN(String input_file) throws Tokenmanagementexception
	{
		  Token mytoken=null;

		  String file_contents="";

		  BufferedReader reader;	

				try {
					reader = new BufferedReader(new FileReader(input_file));
				} catch (FileNotFoundException e) {
					throw new Tokenmanagementexception("Error: input file not found.");
				}
				String line;
				try {
					while ((line = reader.readLine()) != null)
					{
						file_contents += line;
					}
				} catch (IOException e) {
					throw new Tokenmanagementexception
					("Error: input file could not be accessed.");
				}
		    try {
					reader.close();
				} catch (IOException e) {
					throw new Tokenmanagementexception
					("Error: input file could not be closed.");
				}

		    //
		    JsonObject jsonlicense = null;
		  		try(StringReader sr = new StringReader(file_contents)) {
		  			jsonlicense = Json.createReader(sr).readObject();
		  		} catch(Exception e) {
		  			throw new Tokenmanagementexception("Error: JSON "
		  					+ "object cannot be created due to incorrect "
		  					+ "representation");
		  		}
		  		try {
					jsonlicense.getString("Token Request");

				}catch (Exception e)  
				{
					throw new Tokenmanagementexception
					("Error: Token Request not found.");
				}
		  		try {
		  			 SimpleDateFormat format = 
		  					 new SimpleDateFormat("dd/mm/yyyy HH:MM:SS");
				     format.parse(jsonlicense.getString("Request Date"));
				}catch (Exception e)  
				{
					throw new Tokenmanagementexception
					("Error: Request Date not found.");
				}
		  		try {
					jsonlicense.getString("Notification e-mail");

				}catch (Exception e)  
				{
					throw new Tokenmanagementexception
					("Error: Notification e-mail not found.");
				}
		  		
		      //CREACION OBJETO TOKEN
		      try {
		        String token_request = jsonlicense.getString("Token Request");
		        String email = jsonlicense.getString("Notification e-mail");
		        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy HH:MM:SS");
		        Date date = format.parse(jsonlicense.getString("Request Date"));
		        mytoken = new Token (token_request, date, email);
		      } catch (Exception pe) {
		        throw new Tokenmanagementexception("Error: invalid input data in JSON structure.");
		      }
		      
		      CHECK_FORMAT(mytoken);
		      
		      String data_to_sign = mytoken.GET_HEADER() + mytoken.GET_PAYLOAD();
		      		      
		      String myhash = HASH(data_to_sign);
		      mytoken.SET_SIGNATURE(myhash);
		      
		      String string_to_encode = mytoken.GET_HEADER()+ mytoken.GET_PAYLOAD() 
		      + mytoken.GET_SIGNATURE();
		      String encodedtoken = ENCODE_STRING (string_to_encode);
		      mytoken.SET_TOKEN_VALUE(encodedtoken);
 
		      store.ADD(mytoken);
		    	
		      
		      return encodedtoken;	  
	}
		
//GENERACION DE HASH
	public String HASH (String input) throws Tokenmanagementexception
	{
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			throw new Tokenmanagementexception("Error: no such hashing algorithm.");
		}
		
		md.update(input.getBytes(StandardCharsets.UTF_8));
		byte[] digest = md.digest();

		// Beware the hex length. If MD5 -> 32:"%032x", but for instance, 
		//in SHA-256 it should be "%064x" 
		String hex = String.format("%064x", new BigInteger(1, digest));

		return hex;
	}

//CODIFICACION STRING EN 64 URL
	private String ENCODE_STRING(String stringToEncode) throws Tokenmanagementexception 
	{
		  String encoded_url;
		  try{
		    encoded_url=Base64.getUrlEncoder().encodeToString(stringToEncode.getBytes());
		  }catch (Exception ex){
		    throw new Tokenmanagementexception("Error encoding 64URL.");
		  }
		  return encoded_url;
		}

//CHECK DE FORMATOS	
	public void CHECK_FORMAT (Token mytoken) 
			throws Tokenmanagementexception 
	{

		 if (mytoken.GET_DEVICE().length() != 32) 
		 {
				throw new Tokenmanagementexception("Error: invalid Device in token request.");
				}
		// E-mail RFC822 compliant regex adapted for Java:
				Pattern mail_pattern = Pattern.compile("(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^"
						+ "()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\"
						+ "Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?"
						+ ":(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n"
						+ ")?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\"
						+ "n)?[\\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r"
						+ "\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@("
						+ "?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:"
						+ "(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\"
						+ "[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:"
						+ "\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:("
						+ "?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[(["
						+ "^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,"
						+ ";:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=["
						+ "\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:"
						+ "\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ "
						+ "\\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
						+ "\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\"
						+ "]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?"
						+ "[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n"
						+ ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
						+ "\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ "
						+ "\\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?["
						+ " \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
						+ "\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t"
						+ "])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ "
						+ "\\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\"
						+ "]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?"
						+ "(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])"
						+ "+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|"
						+ "\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\."
						+ "(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]"
						+ "+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))"
						+ "|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r"
						+ "\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\"
						+ "] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\"
						+ "\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ "
						+ "\\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] "
						+ "\\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\"
						+ "\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t]"
						+ ")*))*\\>(?:(?:\\r\\n)?[ \\t])*)|(?:[^()<>@,;:\\\\\".\\[\\] \\0"
						+ "00-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\""
						+ ".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\""
						+ "(?:(?:\\r\\n)?[ \\t])*)*:(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@"
						+ ",;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=["
						+ "\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:"
						+ "\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ "
						+ "\\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?["
						+ " \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r"
						+ "\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@("
						+ "?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:"
						+ "(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\"
						+ "[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:"
						+ "\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?"
						+ ":\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\"
						+ "[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:"
						+ "\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=["
						+ "\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:"
						+ "\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ "
						+ "\\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
						+ "\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\["
						+ "\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r"
						+ "\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:"
						+ "\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^"
						+ "\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:"
						+ "\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?"
						+ ":(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\"
						+ "[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:"
						+ "(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?"
						+ ":(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))"
						+ "|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:"
						+ "(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\0"
						+ "31]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\"
						+ "[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?"
						+ ":(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:"
						+ "\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=["
						+ "\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?"
						+ ":\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?"
						+ "[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
						+ "\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\"
						+ "[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r"
						+ "\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:("
						+ "?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[("
						+ "[^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:"
						+ "\\r\\n)?[ \\t])*)(?:,\\s*(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-"
						+ "\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\""
						+ ".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))"
						+ "*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^"
						+ "()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+"
						+ "|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|"
						+ "\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:"
						+ "(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+"
						+ "(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\["
						+ "\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t]"
						+ ")*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] "
						+ "\\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,"
						+ ";:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r"
						+ "\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+("
						+ "?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]"
						+ "]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:"
						+ "(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<"
						+ ">@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|"
						+ "\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]"
						+ "|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ "
						+ "\\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
						+ "\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^"
						+ "\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:"
						+ "(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+"
						+ "(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]"
						+ "]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)"
						+ "(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\00"
						+ "0-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:"
						+ "\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r"
						+ "\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:"
						+ "\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|("
						+ "?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|"
						+ "(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?"
						+ ":\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+("
						+ "?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]"
						+ "]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:("
						+ "?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:"
						+ "\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?"
						+ "=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)"
						+ "*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:"
						+ "[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t"
						+ "])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
						+ "\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?"
						+ "[ \\t])*))*)?;\\s*)");
				if (!mail_pattern.matcher(mytoken.GET_NOTIFICATION_EMAIL()).matches()) 
				{
				  throw new Tokenmanagementexception("Error: invalid E-mail data in JSON structure.");
				}
	       

	}

//VERIFY TOKEN
	public boolean VERIFY_TOKEN(String token) throws Tokenmanagementexception
	{
		boolean result = false;
		Tokenstore my_store = new Tokenstore();
		
		Token token_found = my_store.FIND(token);
		
		if (token_found != null) 
		{
			result = IS_VALID (token_found);
		}
		
		return result;
	}

//ISVALID
	private boolean IS_VALID (Token tokenFound) 
	{
		if ((!tokenFound.IS_EXPIRED()) && (tokenFound.IS_GRANTED())) 
		{
			return true;
		}else 
		{
			return false;
		}
	}
		

	
	
	
}
