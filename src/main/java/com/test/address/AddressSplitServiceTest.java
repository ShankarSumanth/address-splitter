package com.test.address;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.test.address.splitter.pattern.AddressSplitterPatternNumberFirst;
import com.test.address.splitter.pattern.AddressSplitterPatternNumberInMiddle;
import com.test.address.splitter.pattern.AddressSplitterPatternSimpleAddress;
import com.test.address.splitter.pattern.IAddressSplitterPattern;

@RunWith(Parameterized.class)
public class AddressSplitServiceTest {

	List<IAddressSplitterPattern> splitterPatterns;

	Properties properties;

	private AddressSplitService addressSplitService;

	@Parameter
	public String simpleAddressValues;

	@Before
	public void setup() throws IOException {
		loadProperties();
		loadPatterns();
	}

	private void loadPatterns() {
		splitterPatterns = new ArrayList<>();
		addressSplitService = new AddressSplitService(splitterPatterns);

		/* Simple Address Pattern */
		IAddressSplitterPattern simplePattern = new AddressSplitterPatternSimpleAddress(
				properties.getProperty("regex.simpleAddress"));
		splitterPatterns.add(simplePattern);

		/* Number First Address Pattern */
		IAddressSplitterPattern numberFirstPattern = new AddressSplitterPatternNumberFirst(
				properties.getProperty("regex.advancedNumberFirst"));
		splitterPatterns.add(numberFirstPattern);

		/* Number in middle Address Pattern */
		IAddressSplitterPattern numberInMiddlePattern = new AddressSplitterPatternNumberInMiddle(
				properties.getProperty("regex.advancedNumberInMiddle"));
		splitterPatterns.add(numberInMiddlePattern);


	}

	private void loadProperties() throws IOException {
		properties = new Properties();
		InputStream stream = new FileInputStream("src/main/java/com/test/address/AddressSplitRegex.properties");
		properties.load(stream);
	}

	@Test
	public void testSplitAddressByLineNameAndNumber_GIVEN_simpleSingleLineAddresses_RETURN_notNullAndNotEmptyAddressLineAndAddressLineNumber() {

		AddressSplitModel splitModel = addressSplitService.splitAddressByLineNameAndNumber(simpleAddressValues);
		Assert.assertNotNull(splitModel);
		Assert.assertNotNull(splitModel.getAddressLine());
		Assert.assertTrue(!splitModel.getAddressLine().isEmpty());
		Assert.assertNotNull(splitModel.getAddressLineNumber());
		Assert.assertTrue(!splitModel.getAddressLineNumber().isEmpty());
	}

	@Parameters
	public static Iterable<String> data() throws IOException {

		File file = new File("src/test/resources/address-data.txt");
		LineIterator it = FileUtils.lineIterator(file, "UTF-8");
		List<String> inputs = new ArrayList<>();
		try {
			while (it.hasNext()) {
				inputs.add(it.nextLine());
			}
		} finally {
			LineIterator.closeQuietly(it);
		}
		return inputs;
	}

}
