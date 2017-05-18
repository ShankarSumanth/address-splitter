package com.test.address.splitter.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.test.address.AddressSplitModel;

public class AddressSplitterPatternNumberInMiddle implements IAddressSplitterPattern {
	private Pattern pattern;

	public AddressSplitterPatternNumberInMiddle(String numberInMiddleAddressSplitterPattern) {
		this.pattern = Pattern.compile(numberInMiddleAddressSplitterPattern);
	}

	@Override
	public Pattern getPattern() {
		return pattern;
	}

	@Override
	public AddressSplitModel splitAndGet(String addresslineAndNumberAsString) {
		Matcher m = pattern.matcher(addresslineAndNumberAsString);
		m.matches();
		String addressLine = m.group(1).trim().replace(",$", "");
		String addressNumber = m.group(2).trim().replace(",$", "");
		return new AddressSplitModel(addresslineAndNumberAsString, removeEndCommaIfAny(addressLine), removeEndCommaIfAny(addressNumber));
	}

	@Override
	public boolean isMatch(String addressLineAndNumberAsString) {
		return pattern.matcher(addressLineAndNumberAsString).matches();
	}

}
