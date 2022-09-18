package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import pageobject.HomePage;
import pageobject.LoginPage;

import static stepdef.Hook.driver;

public class LoginStep {
		private final HomePage homePage = new HomePage(driver);
		private final LoginPage loginPage = new LoginPage(driver);
		
		@And("I login with credentials {} and {}")
		public void loginAccount(String email, String password) {
				homePage
							.clickSignIn();
				
				loginPage
							.loginAccount(email, password);
		}
		
		@Then("I could see that {} is showing")
		public void statusLogin(String status) {
				
				if (status.contains("account")) {
						Assert.assertEquals(driver.getTitle(), status);
						
				} else if (status.contains("failed.")) {
						Assert.assertEquals(loginPage.getErrorMessage(), status);
				}
		}
		
		@And("I sign up using {}")
		public void signUpUsingEmail(String email) {
				homePage
							.clickSignIn();
				
				loginPage
							.signUp(email + RandomStringUtils.randomNumeric(2));
		}
		
		@Then("I should see that signup {} is displayed")
		public void signUpStatus(String status) throws InterruptedException {
				if (status.contains("Invalid")) {
						Assert.assertEquals(loginPage.getErrorMessage(), status);
				} else {
						Assert.assertEquals(loginPage.getSubHeader(), status);
				}
		}
}
