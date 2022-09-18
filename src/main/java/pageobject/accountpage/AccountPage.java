package pageobject.accountpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.BasePage;

public class AccountPage extends BasePage {
		public AccountPage(WebDriver driver) {
				super(driver);
		}
		
		@FindBy(css = ".page-heading")
		private WebElement pageHeading;
		@FindBy(xpath = "//a[@title='Addresses']")
		private WebElement buttonAddress;
		@FindBy(xpath = "//a[@title='Orders']")
		private WebElement buttonOrders;
		@FindBy(xpath = "//a[@title='Credit slips']")
		private WebElement buttonCreditSlips;
		@FindBy(xpath = "//a[@title='Information']")
		private WebElement buttonPersonalInformation;
		@FindBy(xpath = "//a[@title='Home']")
		private WebElement buttonBackToHomePage;
		
		
		public boolean isDisplayed() {
				return isElementDisplayed(pageHeading);
		}
		
		public String getPageHeading() {
				return getTextElement(pageHeading);
		}
		
		public void clickAddress() {
				clickElement(buttonAddress);
		}
		
		public void clickOrderHistory() {
				clickElement(buttonOrders);
		}
		
		public void clickCreditSlips() {
				clickElement(buttonCreditSlips);
		}
		
		public void clickPersonalInformation() {
				clickElement(buttonPersonalInformation);
		}
		
		public void clickBackToHome() {
				clickElement(buttonBackToHomePage);
		}
}
