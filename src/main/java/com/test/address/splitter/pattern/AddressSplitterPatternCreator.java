package com.test.address.splitter.pattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.test.address.AddressSplitRegex;

@Component
public class AddressSplitterPatternCreator {

	AddressSplitRegex regex;

	@Autowired
	public AddressSplitterPatternCreator(AddressSplitRegex regex) {
		this.regex = regex;
	}

	@Bean
	public List<IAddressSplitterPattern> getSplitterPatterns() {
		List<IAddressSplitterPattern> patterns = new ArrayList<>();
		patterns.add(new AddressSplitterPatternSimpleAddress(regex.getSimpleAddress()));
		patterns.add(new AddressSplitterPatternNumberFirst(regex.getAdvancedNumberFirst()));
		patterns.add(new AddressSplitterPatternNumberInMiddle(regex.getAdvancedNumberInMiddle()));
		return Collections.unmodifiableList(patterns);
	}

}
