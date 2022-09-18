package testdata;

import lombok.Getter;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;

@Getter
public class AddressData {
		private final String firstName = "";
		private final String lastName = "Akun " + RandomStringUtils.randomAlphabetic(3);
		private final String company = "testcompany";
		private final String address = "testaddress1";
		private final String address2 = "testaddress2";
		private final String city = "testcity";
		private final String postalCode = "12345";
		private final String homePhone = "1234567890";
		private final String mobilePhone = "987654321";
		private final String additionalInformation = "testadditionalinfo";
		private final String addressTitle = "Address " + RandomString.make(4);
}