package Transport4Future.TokenManagement;

import java.util.Date;

public class Tokenrequest
{
	
	private String device_name;
	private Date request_date;
	private String serial_number;
	private String mac_address;
	
	public Tokenrequest
	(String device_name, Date creation_date, String serial_number, String mac_address) 
	{
		this.device_name = device_name;
		this.request_date = creation_date;
		this.serial_number = serial_number;
		this.mac_address = mac_address;
	}
	
	@Override
	public String toString() 
	{
		return "Tokenrequest [\\n\\Device Name=" + this.device_name + ",\n\t\\Request Date="
	    + this.request_date + ",\n\t\\Serial Number=" 
		+ this.serial_number + ",\n\t\\MAC Address=" 
	    + this.mac_address + "\n]";
	}
}
