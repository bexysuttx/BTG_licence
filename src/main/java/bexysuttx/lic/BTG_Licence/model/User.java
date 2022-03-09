package bexysuttx.lic.BTG_Licence.model;

public class User {

	private String uid;
	private String macAddress;

	public User(String uid, String macAddress) {
		super();
		this.uid = uid;
		this.macAddress = macAddress;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	@Override
	public String toString() {
		return String.format(" [uid=%s, macAddress=%s]", uid, macAddress);
	}
	


}
