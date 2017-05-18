package com.test.address.splitter.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.test.address.AddressSplitModel;

public class AddressSplitterPatternSimpleAddress implements IAddressSplitterPattern {

	private Pattern pattern;

	public AddressSplitterPatternSimpleAddress(String simpleAddressSplitterPattern) {
		this.pattern = Pattern.compile(simpleAddressSplitterPattern);
	}

	@Override
	public Pattern getPattern() {
		return pattern;
	}

	@Override
	public AddressSplitModel splitAndGet(String addresslineAndNumberAsString) {
		Matcher m = pattern.matcher(addresslineAndNumberAsString);
		m.matches();
		String addressline = m.group(1).trim();
		String addressLineNumber = m.group(2).trim();
		return new AddressSplitModel(addresslineAndNumberAsString, removeEndCommaIfAny(addressline), removeEndCommaIfAny(addressLineNumber));
	}

	@Override
	public boolean isMatch(String addressLineAndNumberAsString) {
		return pattern.matcher(addressLineAndNumberAsString).matches();
	}

}
