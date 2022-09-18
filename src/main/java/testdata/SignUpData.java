package testdata;

import lombok.Getter;
import net.bytebuddy.utility.RandomString;

@Getter
public class SignUpData {
		private final String firstName = "akun";
		private final String lastName = "test";
		private final String email = "email" + RandomString.make(5) + "@mail.com";
		private final String password = "akuntest123";
		private final String phoneNumber = "+1234567890";
		
}