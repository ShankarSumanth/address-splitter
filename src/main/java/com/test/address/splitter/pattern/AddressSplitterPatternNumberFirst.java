package com.test.address.splitter.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.test.address.AddressSplitModel;

public class AddressSplitterPatternNumberFirst implements IAddressSplitterPattern {
	private Pattern pattern;

	public AddressSplitterPatternNumberFirst(String numberFirstAddressSplitterPattern) {
		pattern = Pattern.compile(numberFirstAddressSplitterPattern);
	}

	@Override
	public Pattern getPattern() {
		return pattern;
	}

	@Override
	public AddressSplitModel splitAndGet(String addresslineAndNumberAsString) {
		Matcher m = pattern.matcher(addresslineAndNumberAsString);
		m.matches();
		String trimmedNumber = m.group(1).trim().replaceAll(",$", "");
		String trimmedStreet = m.group(2).trim().replaceAll(",$", "");
		return new AddressSplitModel(addresslineAndNumberAsString, removeEndCommaIfAny(trimmedStreet), removeEndCommaIfAny(trimmedNumber));
	}

	@Override
	public boolean isMatch(String addressLineAndNumberAsString) {
		return pattern.matcher(addressLineAndNumberAsString).matches();
	}

}
