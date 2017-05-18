package com.test.address;

public class AddressSplitVO {
	private String addressLineAndNumber;
	private String addressLine;
	private String addressLineNumber;

	public AddressSplitVO(String addressLineAndNumber, String addressLine, String addressLineNumber) {
		super();
		this.addressLineAndNumber = addressLineAndNumber;
		this.addressLine = addressLine;
		this.addressLineNumber = addressLineNumber;
	}
	public String getAddressLineAndNumber() {
		return addressLineAndNumber;
	}
	public void setAddressLineAndNumber(String addressLineAndNumber) {
		this.addressLineAndNumber = addressLineAndNumber;
	}
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public String getAddressLineNumber() {
		return addressLineNumber;
	}
	public void setAddressLineNumber(String addressLineNumber) {
		this.addressLineNumber = addressLineNumber;
	}

}
