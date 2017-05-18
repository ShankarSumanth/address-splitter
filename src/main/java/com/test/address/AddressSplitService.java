package com.test.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.address.splitter.pattern.IAddressSplitterPattern;

@Service
public class AddressSplitService implements IAddressSplitService {

	List<IAddressSplitterPattern> splitterPatterns;

	@Autowired
	public AddressSplitService(List<IAddressSplitterPattern> splitterPatterns) {
		this.splitterPatterns = splitterPatterns;
	}

	@Override
	public AddressSplitModel splitAddressByLineNameAndNumber(String addressLineAndNumberAsString) {
		return splitterPatterns.stream()
				.filter(pattern -> pattern.isMatch(addressLineAndNumberAsString))
				.findFirst()
				.map(pattern -> pattern.splitAndGet(addressLineAndNumberAsString))
				.orElse(new AddressSplitModel(addressLineAndNumberAsString, "", ""));
	}

}
