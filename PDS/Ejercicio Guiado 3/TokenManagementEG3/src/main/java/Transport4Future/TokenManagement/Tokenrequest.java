package Transport4Future.TokenManagement;


public class Tokenrequest
{
	
	private String device_name;
	private String type_device;
	private String driver_version;
	private String support_email;
	private String serial_number;
	private String mac_address;
	
	public Tokenrequest
	(String device_name,String type_device,String driver_version,String email, 
			String serial_number, String mac_address) 
					throws Tokenmanagementexception 
	{
		this.device_name = device_name;
		this.type_device = type_device;
		this.driver_version = driver_version;
		this.serial_number = serial_number;
		this.mac_address = mac_address;
		
		this.support_email = email;
	}
	
	
	public String GETDEVICE_NAME() 
	{
		return device_name;
	}


	public void SETDEVICE_NAME(String device_name) 
	{
		this.device_name = device_name;
	}


	public String GETTYPE_DEVICE() 
	{
		return type_device;
	}


	public void SETTYPE_DEVICE(String type_device) 
	{
		this.type_device = type_device;
	}


	public String GETDRIVER_VERSION() 
	{
		return driver_version;
	}


	public void SETDRIVER_VERSION(String driver_version) 
	{
		this.driver_version = driver_version;
	}


	public String GETSUPPORT_EMAIL() 
	{
		return support_email;
	}


	public void SETSUPPORT_EMAIL(String support_email) 
	{
		this.support_email = support_email;
	}


	public String GETSERIAL_NUMBER() 
	{
		return serial_number;
	}


	public void SETSERIAL_NUMBER(String serial_number) 
	{
		this.serial_number = serial_number;
	}


	public String GETMAC_ADDRESS() 
	{
		return mac_address;
	}


	public void SETMAC_ADDRESS(String mac_address) 
	{
		this.mac_address = mac_address;
	}


	@Override
	public String toString() 
	{
		return "Tokenrequest [\\n\\Device Name="
		+ this.device_name + ",\n\t\\ Support Email="
		+ this.support_email + ",\n\t\\Type of device="
		+ this.type_device + ",\n\t\\Driver Version = "
		+ this.driver_version + ",\t\\Serial Number="
		+ this.serial_number + ",\n\t\\MAC Address=" 
		+ this.mac_address + "\n]";
	}
	
	
	
}

