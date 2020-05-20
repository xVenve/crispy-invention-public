package Transport4Future.TokenManagement.Data;

import java.util.HashMap;

import Transport4Future.TokenManagement.Exceptions.Tokenmanagementexception;
import Transport4Future.TokenManagement.IO.Tokenrequestparser;
import Transport4Future.TokenManagement.Store.Tokenrequeststore;
import Transport4Future.TokenManagement.Utils.Hashermd;

public class Tokenrequest 
{
	
	private Devicename device_name;
	private Typeofdevice type_of_device;
	private Driverversion driver_version;
	private Email support_email;
	private Serialnumber serial_number;
	private Macaddress mac_address;
	private String hash_md5;
		
	public Tokenrequest(String json_license) throws Tokenmanagementexception 
	{
		Tokenrequestparser myParser = new Tokenrequestparser();
		HashMap<String, String> items = myParser.PARSE(json_license);
		
		this.device_name = new Devicename(items.get(Tokenrequestparser.DEVICE_NAME));
		this.type_of_device = new Typeofdevice(items.get(Tokenrequestparser.TYPE_OF_DEVICE));
		this.driver_version = new Driverversion(items.get(Tokenrequestparser.DRIVER_VERSION));
		this.support_email = new Email(items.get(Tokenrequestparser.SUPPORT_E_MAIL));
		this.serial_number = new Serialnumber(items.get(Tokenrequestparser.SERIAL_NUMBER));
		this.mac_address = new Macaddress(items.get(Tokenrequestparser.MAC_ADDRESS));
		this.hash_md5= this.GENERATE_HASH();
		this.STORE_REQUEST();
	}
	
	public String GENERATE_HASH() throws Tokenmanagementexception 
	{
		Hashermd myHasher = new Hashermd();
			
		String hex = myHasher.HASH(this.toString());
		return hex;
	}
	
	private void STORE_REQUEST() throws Tokenmanagementexception 
	{
		Tokenrequeststore myStore = Tokenrequeststore.GET_INSTANCE();
		myStore.SAVE_TOKEN_REQUEST(this, this.hash_md5);
	}
	
	public String GET_HASH() throws Tokenmanagementexception 
	{
		return this.hash_md5;
	}
	
	public String GET_DEVICE_NAME() 
	{
		return device_name.GETDATA();
	}

	public String GET_TYPE_OF_DEVICE() 
	{
		return type_of_device.GETDATA();
	}

	public String GET_DRIVER_VERSION() 
	{
		return driver_version.GETDATA();
	}

	public String GET_SUPPORT_EMAIL() 
	{
		return support_email.GETDATA();
	}

	public String GET_SERIAL_NUMBER() 
	{
		return serial_number.GETDATA();
	}

	public String GET_MAC_ADDRESS() 
	{
		return mac_address.GETDATA();
	}
	
	@Override
	public String toString() 
	{
		return "TokenRequest [\\n\\" + Tokenrequestparser.DEVICE_NAME + "=" + this.GET_DEVICE_NAME() +
				",\n\t\\"+ Tokenrequestparser.TYPE_OF_DEVICE + "=" + this.GET_TYPE_OF_DEVICE() +
				",\n\t\\"+ Tokenrequestparser.DRIVER_VERSION + "=" + this.GET_DRIVER_VERSION() +	
				",\n\t\\"+ Tokenrequestparser.SUPPORT_E_MAIL + "=" + this.GET_SUPPORT_EMAIL() +	
				",\n\t\\"+ Tokenrequestparser.SERIAL_NUMBER + "=" + this.GET_SERIAL_NUMBER() +
				",\n\t\\"+ Tokenrequestparser.MAC_ADDRESS + "=" + this.GET_MAC_ADDRESS() + "\n]";
	}
	
}
