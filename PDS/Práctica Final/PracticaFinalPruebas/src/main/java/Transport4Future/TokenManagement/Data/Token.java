package Transport4Future.TokenManagement.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


import java.util.Date;
import java.util.HashMap;

import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;
import Transport4Future.TokenManagement.IO.Tokenparser;
import Transport4Future.TokenManagement.Store.Tokenrequeststore;
import Transport4Future.TokenManagement.Store.Tokenstore;
import Transport4Future.TokenManagement.Utils.Encoder;
import Transport4Future.TokenManagement.Utils.Hashersha;


public class Token 
{
	private String algorithm;
	private String type;
	private Device device;
	private Dateclass request_date;
	private Email notification_email;
	private long creation_date;
	private long expiration_date;
	private String signature;
	
	public Token (String file_name) throws Tokenmanagementexception 
	{
		Tokenparser myParser = new Tokenparser();
		HashMap<String, String> items = myParser.PARSE(file_name);

		this.algorithm = "HS256";
		this.type = "PDS";
		this.device = new Device(items.get(Tokenparser.TOKEN_REQUEST));
		this.request_date = new Dateclass(items.get(Tokenparser.REQUEST_DATE));
		this.notification_email = new Email(items.get(Tokenparser.NOTIFICATION_E_MAIL));
		this.CHECK_TOKEN_REQUEST_EMISSION();
		//this.creation_date = System.currentTimeMillis();
		//this.expiration_date = this.creation_date + 604800000l
		//Fechas para las pruebas
		DATES_TO_TEST();
		this.signature = this.GENERATE_SIGNATURE();
				
		STORE_TOKEN();
	}

	private void DATES_TO_TEST() 
	{
		this.creation_date = 1584523340892l;
		if ((this.device.GETDATA().startsWith("5")))
		{
			this.expiration_date = this.creation_date + 60480000000l;
		}
		else 
		{
			this.expiration_date = this.creation_date + 6560480000000l;
		}
	}

	private void STORE_TOKEN() throws Tokenmanagementexception 
	{
		Tokenstore myStore = Tokenstore.GET_INSTANCE();
		myStore.ADD(this);
	}
	
	public String GET_DEVICE() 
	{
		return device.GETDATA();
	}

	public String GET_REQUEST_DATE() 
	{
		return request_date.GETDATA();
	}

	public String GET_NOTIFICATION_EMAIL() 
	{
		return notification_email.GETDATA();
	}
	
	private String GENERATE_SIGNATURE() throws Tokenmanagementexception 
	{
		Hashersha myHasher = new Hashersha();
		String dataToSign = this.GET_HEADER() + this.GET_PAYLOAD();
		return (myHasher.HASH(dataToSign));
	}
	
	public boolean IS_GRANTED () 
	{
		if (this.creation_date < System.currentTimeMillis()) 
			return true;
		return false;
	}
	
	public boolean IS_EXPIRED () 
	{
		if (this.expiration_date > System.currentTimeMillis()) 
			return false;
		return true;
		
	}
	
	public boolean IS_VALID () 
	{ 
		if ((!this.IS_EXPIRED()) && (this.IS_GRANTED()))
			return true;
		return false;
	}

	public String GET_HEADER () 
	{
		return "Alg=" + this.algorithm + "\\n Typ=" + this.type + "\\n";
	}
	
	public String GET_PAYLOAD () 
	{
		Date creationDate = new Date(this.creation_date);
		Date expirationDate = new Date(this.expiration_date);
		
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		return "Dev=" + this.device.GETDATA() 
				+ "\\n iat=" + format.format(creationDate)
				+ "\\n exp=" + format.format(expirationDate);
	}
	
	public void SET_SIGNATURE(String value) 
	{
		this.signature = value;
	}

	public String GET_SIGNATURE() 
	{
		return this.signature;
	}
	
	
	public String GENERATE_TOKEN_VALUE()
	{
		Encoder myEncoder = new Encoder();
		String encode64 = myEncoder.URL64ENCODE(this, this.signature);
		return encode64;
	}
	
	
	private void CHECK_TOKEN_REQUEST_EMISSION() throws Tokenmanagementexception
    {
        Tokenrequeststore myStore = Tokenrequeststore.GET_INSTANCE();
        if (myStore.FIND(this.GET_DEVICE()) == null) 
        {
            throw new Tokenmanagementexception ("Error: Token Request not previously registered");
        }

    }
	
}
