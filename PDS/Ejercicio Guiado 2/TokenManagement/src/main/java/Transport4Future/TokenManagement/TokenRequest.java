package Transport4Future.TokenManagement;

import java.util.Date;

public class TokenRequest {
	
	private String deviceName;
	private Date requestDate;
	private String serialNumber;
	private String macAddress;
	
	public TokenRequest(String deviceName, Date creationDate, String serialNumber, String macAddress) {
		this.deviceName = deviceName;
		this.requestDate = creationDate;
		this.serialNumber = serialNumber;
		this.macAddress = macAddress;
	}
	
	@Override
	public String toString() {
		return "TokenRequest [\\n\\Device Name=" + this.deviceName + ",\n\t\\Request Date=" + this.requestDate + ",\n\t\\Serial Number="
				+ this.serialNumber + ",\n\t\\MAC Address=" + this.macAddress + "\n]";
	}
}
