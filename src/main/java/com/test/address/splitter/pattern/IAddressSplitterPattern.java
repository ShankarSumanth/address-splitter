package com.test.address.splitter.pattern;

import java.util.regex.Pattern;

import com.test.address.AddressSplitModel;

public interface IAddressSplitterPattern {

	Pattern getPattern();

	AddressSplitModel splitAndGet(String addresslineAndNumberAsString);

	boolean isMatch(String addressLineAndNumberAsString);

	default String removeEndCommaIfAny(String string) {
		if (string.endsWith(","))
			return string.substring(0, string.length()-1);
		return string;
	}
}
