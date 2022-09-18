package pageobject.accountpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.BasePage;
import testdata.EditProfileData;

public class PersonalInformationPage extends BasePage {
		
		private final EditProfileData editProfileData;
		
		public PersonalInformationPage(WebDriver driver) {
				super(driver);
				editProfileData = new EditProfileData();
		}
		
		@FindBy(className = "page-subheading")
		private WebElement editInfoPageHeading;
		@FindBy(id = "firstname")
		private WebElement inputFirstName;
		@FindBy(id = "lastname")
		private WebElement inputLastName;
		@FindBy(id = "old_passwd")
		private WebElement inputOldPassword;
		@FindBy(xpath = "//div[@class='alert alert-danger']/ol/li")
		private WebElement errorMessage;
		@FindBy(name = "submitIdentity")
		private WebElement buttonSave;
		@FindBy(css = ".alert-success")
		private WebElement successMessage;
		
		public void editLastName() {
				setTextElement(inputLastName, editProfileData.getLastName());
		}
		
		public void inputOldPassword(String password) {
				setTextElement(inputOldPassword, password);
		}
		
		public String getErrorMessage() {
				return getTextElement(errorMessage);
		}
		
		public String getSuccessEditProfileMessage() {
				return getTextElement(successMessage);
		}
		
		public void clickSaveButton() {
				clickElement(buttonSave);
		}
		
		public void inputFirstName(String text) {
				setTextElement(inputFirstName, text);
				setTextElement(inputOldPassword, editProfileData.getPassword());
				clickSaveButton();
		}
		
		public void inputLastName(String text) {
				setTextElement(inputLastName, text);
				setTextElement(inputOldPassword, editProfileData.getPassword());
				clickSaveButton();
		}
}
