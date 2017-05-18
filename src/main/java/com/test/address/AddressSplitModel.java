package com.test.address;

/**
 * AddressSplit model
 * @author sumanthshankar
 *
 */
public class AddressSplitModel {
	private String addressLineAndNumberAsString;
	private String addressLine;
	private String addressLineNumber;

	public AddressSplitModel(String addressLineAndNumberAsString, String addressLine, String addressLineNumber) {
		super();
		this.addressLineAndNumberAsString = addressLineAndNumberAsString;
		this.addressLine = addressLine;
		this.addressLineNumber = addressLineNumber;
	}

	public String getAddressLineAndNumberAsString() {
		return addressLineAndNumberAsString;
	}
	public void setAddressLineAndNumberAsString(String addressLineAndNumberAsString) {
		this.addressLineAndNumberAsString = addressLineAndNumberAsString;
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
