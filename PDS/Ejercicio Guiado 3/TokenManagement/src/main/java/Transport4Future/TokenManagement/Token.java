package Transport4Future.TokenManagement;


import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;


public class Token 
{
	private String alg;
	private String typ;
	private String device;
	private Date request_date;
	private String notification_email;
	private long iat;
	private long exp;
	private String signature;
	private String token_value;
	
	



	public Token (String device, Date requestd, String email) 
	{
		this.alg = "HS256";
		this.typ = "PDS";
		this.device = device;
		this.request_date = requestd;
		this.notification_email = email;
		//this.iat = System.currentTimeMillis();
		this.iat = 1584523340892l;
        this.exp = 160480000000000l;
        this.signature = null;
        this.token_value= null;
	}
	
	
	public String GET_HEADER() 
	{
		return "Alg==" + this.alg + "\\n Typ=" +this.typ + "\\n";
	}
	
	public String GET_PAYLOAD() 
	{
		Date iat_date = new Date(this.iat);
		Date exp_date = new Date(this.exp);
	
		DateFormat df= new SimpleDateFormat("dd/mm/yyyy HH:MM:SS");
		
		return "Dev=" + this.device
				+ "\\n iat=" + df.format(iat_date)
				+ "\\n exp=" + df.format(exp_date);

	}
	
	public String GET_SIGNATURE() 
	{
		return this.signature;
	}
	
	public boolean IS_EXPIRED() 
	{
		if (this.exp > System.currentTimeMillis())
			return false;
		else
			return true;
	}
	
	public boolean IS_GRANTED()
	{
		  if (this.iat < System.currentTimeMillis())
		  {
		    return true;
		  }else
		  {
		    return false;
		  }
		}

	public String GET_ALG() 
	{
		return alg;
	}

	public void SET_ALG(String alg) 
	{
		this.alg = alg;
	}
	public void SET_SIGNATURE(String sig) 
	{
		this.signature = sig;
	}
	public void SET_TOKEN_VALUE (String val) 
	{	
		this.token_value = val;
	}

	public String GET_TYPE() 
	{
		return typ;
	}
	
	public String GET_TOKEN_VALUE() 
	{
		return this.token_value;
	}
	
	public void SET_TYP(String typ) 
	{
		this.typ = typ;
	}

	public String GET_DEVICE() 
	{
		return device;
	}

	public void SET_DEVICE(String device) 
	{
		this.device = device;
	}

	public Date GET_REQUEST_DATE() 
	{
		return request_date;
	}

	public void SET_REQUEST_DATE(Date request_date) 
	{
		this.request_date = request_date;
	}

	public String GET_NOTIFICATION_EMAIL() 
	{
		return notification_email;
	}

	public void SET_NOTIFICATION_EMAIL(String email) 
	{
		this.notification_email = email;
	}

	public long GET_IAT() 
	{
		return iat;
	}

	public void SET_IAT(long iat) 
	{
		this.iat = iat;
	}

	public long GET_EXP() 
	{
		return exp;
	}

	public void SET_EXP(long exp) 
	{
		this.exp = exp;
	}
	

}
