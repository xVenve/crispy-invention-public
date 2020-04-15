package Transport4Future.TokenManagement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Token {
	private String alg;
	private String typ;
	private String device;
	private String requestDate;
	private String notificationEmail;
	private long iat;
	private long exp;
	private String signature;
	private String tokenValue;
	
	public Token (String Device, String RequestDate, String NotificationEmail) {
		this.alg = "HS256";
		this.typ = "PDS";
		this.device = Device;
		this.requestDate = RequestDate;
		this.notificationEmail = NotificationEmail;
//		this.iat = System.currentTimeMillis();
		// SOLO PARA PRUEBAS
		this.iat = 1584523340892l;
		if ((this.device.startsWith("5"))){
			this.exp = this.iat + 604800000l;
		}
		else {
			this.exp = this.iat + 65604800000l;
		}
		this.signature = null;
		this.tokenValue = null;
	}
	
	public String getDevice() {
		return device;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public String getNotificationEmail() {
		return notificationEmail;
	}
	
	public boolean isGranted () {
		if (this.iat < System.currentTimeMillis()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isExpired () {
		if (this.exp > System.currentTimeMillis()) {
			return false;
		}
		else {
			return true;
		}
	}

	public String getHeader () {
		return	"Alg=" + this.alg + "\\n Typ=" + this.typ + "\\n";
	}
	
	public String getPayload () {
		Date iatDate = new Date(this.iat);
		Date expDate = new Date(this.exp);
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		return	"Dev=" + this.device 
				+ "\\n iat=" + df.format(iatDate)
				+ "\\n exp=" + df.format(expDate);
	}
	
	public void setSignature(String value) {
		this.signature = value;
	}

	public String getSignature() {
		return this.signature;
	}
	
	public void setTokenValue(String value) {
		this.tokenValue = value;
	}
	
	public String getTokenValue() {
		return this.tokenValue;
	}	
}
