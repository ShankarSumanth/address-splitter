package com.test.address;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to split addresses
 * @author sumanthshankar
 *
 */
@RestController
public class AddressSplitController {

	private IAddressSplitService addressService;

	@Autowired
	public AddressSplitController(IAddressSplitService addressService) {
		this.addressService = addressService;
	}

	/**
	 * Resource representing the Address Which was split
	 * @param addressLineAndNumberAsString
	 * @return
	 */
	@RequestMapping(path = "/SplitAddress")
	public AddressSplitVO splitAddressByLineAndNumber(@RequestParam(value="address") String addressLineAndNumberAsString) {
		AddressSplitModel splitAddressModel = addressService
				.splitAddressByLineNameAndNumber(addressLineAndNumberAsString);
		return buildVOFromAddress(splitAddressModel);
	}

	private AddressSplitVO buildVOFromAddress(AddressSplitModel splitAddressModel) {
		return new AddressSplitVO(splitAddressModel.getAddressLineAndNumberAsString(),
				splitAddressModel.getAddressLine(), splitAddressModel.getAddressLineNumber());
	}

	@ExceptionHandler
	void handleAddressSplitterException(AddressSplitterException e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}
}
