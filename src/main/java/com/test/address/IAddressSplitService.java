package com.test.address;

/**
 * Service component responsible for business logic
 * @author sumanthshankar
 *
 */
public interface IAddressSplitService {

	/**
	 * Split give single line address as line number and street name
	 * @param addressLineAndNumberAsString single string address name and number
	 * @return {@link AddressSplitModel} with split address and number else {@code empty AddressSplitModel}
	 */
	AddressSplitModel splitAddressByLineNameAndNumber(String addressLineAndNumberAsString);
}
