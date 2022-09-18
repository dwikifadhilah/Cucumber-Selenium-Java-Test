package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testdata.LoginData;

public class LoginPage extends BasePage {
		private final LoginData loginData;
		
		public LoginPage(WebDriver driver) {
				super(driver);
				loginData = new LoginData();
		}
		
		/**
		 * Login
		 */
		@FindBy(id = "email")
		private WebElement inputEmail;
		@FindBy(id = "passwd")
		private WebElement inputPassword;
		@FindBy(id = "SubmitLogin")
		private WebElement buttonSubmitLogin;
		
		/**
		 * Sign Up
		 */
		@FindBy(id = "email_create")
		private WebElement inputCreateEmail;
		@FindBy(id = "SubmitCreate")
		private WebElement buttonCreateAccount;
		@FindBy(css = ".page-subheading")
		private WebElement subHeader;
		
		@FindBy(xpath = "//div[@class='alert alert-danger']/ol/li")
		private WebElement errorLoginMessage;
		
		public void loginExistingAccount() {
				
				setTextElement(inputEmail, loginData.getEmail());
				setTextElement(inputPassword, loginData.getPassword());
				clickElement(buttonSubmitLogin);
		}
		
		public void loginAccount(String email, String password) {
				
				setTextElement(inputEmail, email);
				setTextElement(inputPassword, password);
				clickElement(buttonSubmitLogin);
		}
		
		public String getErrorMessage() {
				return getTextElement(errorLoginMessage);
		}
		
		public String getSubHeader() throws InterruptedException {
				Thread.sleep(1000);
				return getTextElement(subHeader);
		}
		
		public void signUp(String email) {
				setTextElement(inputCreateEmail, email);
				clickElement(buttonCreateAccount);
		}
}
