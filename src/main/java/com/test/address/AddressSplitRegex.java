package com.test.address;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Type-safe Properties Configuration for AddressSplitRegex
 * @author sumanthshankar
 *
 */
@Component
@ConfigurationProperties("regex")
@PropertySource("classpath:/com/test/address/AddressSplitRegex.properties")
public class AddressSplitRegex {

	private String simpleAddress;

	private String advancedNumberFirst;

	private String advancedNumberInMiddle;

	public String getSimpleAddress() {
		return simpleAddress;
	}

	public void setSimpleAddress(String simpleAddress) {
		this.simpleAddress = simpleAddress;
	}

	public String getAdvancedNumberFirst() {
		return advancedNumberFirst;
	}

	public void setAdvancedNumberFirst(String advancedNumberFirst) {
		this.advancedNumberFirst = advancedNumberFirst;
	}

	public String getAdvancedNumberInMiddle() {
		return advancedNumberInMiddle;
	}

	public void setAdvancedNumberInMiddle(String advancedNumberInMiddle) {
		this.advancedNumberInMiddle = advancedNumberInMiddle;
	}


}
