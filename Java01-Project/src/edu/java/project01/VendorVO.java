package edu.java.project01;

import java.io.Serializable;

public class VendorVO implements Serializable{

	private int vendorId;
	private String vendorName;
	private String vendorPhone;
	private String vendorEmail;

	public VendorVO() {
		super();		
	}
	public VendorVO(int vendorId, String vendorName, String vendorPhone, String vendorEmail) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorPhone = vendorPhone;
		this.vendorEmail = vendorEmail;
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorPhone() {
		return vendorPhone;
	}
	public void setVendorPhone(String vendorPhone) {
		this.vendorPhone = vendorPhone;
	}
	public String getVendorEmail() {
		return vendorEmail;
	}
	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}
	@Override
	public String toString() {
		return "VendorVO [vendorId=" + vendorId + ", vendorName=" + vendorName + ", vendorPhone=" + vendorPhone
				+ ", vendorEmail=" + vendorEmail + "]";
	}	
	
}//end VendorVO
