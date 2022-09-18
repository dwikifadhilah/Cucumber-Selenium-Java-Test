package testdata;

import lombok.Getter;
import org.apache.commons.lang3.RandomStringUtils;

@Getter
public class EditProfileData {
		private final String lastName = "name " + RandomStringUtils.randomAlphabetic(3);
		private final String password = "punya.dwiki";
		
}
