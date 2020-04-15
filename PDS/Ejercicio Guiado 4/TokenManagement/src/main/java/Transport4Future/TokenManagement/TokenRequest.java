package Transport4Future.TokenManagement;

public class TokenRequest {
	
	private String deviceName;
	private String typeOfDevice;
	private String driverVersion;
	private String supportEMail;
	private String serialNumber;
	private String macAddress;
		
	public TokenRequest(String deviceName, String typeOfDevice, String driverVersion, String supportEMail, String serialNumber, String macAddress) {
		this.deviceName = deviceName;
		this.typeOfDevice = typeOfDevice;
		this.driverVersion = driverVersion;
		this.supportEMail = supportEMail;
		this.serialNumber = serialNumber;
		this.macAddress = macAddress;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public String getTypeOfDevice() {
		return typeOfDevice;
	}

	public String getDriverVersion() {
		return driverVersion;
	}

	public String getSupportEMail() {
		return supportEMail;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public String getMacAddress() {
		return macAddress;
	}
	
	@Override
	public String toString() {
		return "TokenRequest [\\n\\Device Name=" + this.deviceName +
				",\n\t\\Type of Device=" + this.typeOfDevice +
				",\n\t\\Driver Version=" + this.driverVersion +	
				",\n\t\\Support e-Mail=" + this.supportEMail +	
				",\n\t\\Serial Number=" + this.serialNumber +
				",\n\t\\MAC Address=" + this.macAddress + "\n]";
	}
}
