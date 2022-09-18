package pageobject.accountpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.BasePage;
import testdata.AddressData;

public class MyAddressPage extends BasePage {
		private final AddressData data;
		
		public MyAddressPage(WebDriver driver) {
				super(driver);
				data = new AddressData();
		}
		
		@FindBy(css = ".page-heading")
		private WebElement pageHeading;
		@FindBy(xpath = "//a[@title='Add an address']")
		private WebElement buttonAddNewAddress;
		@FindBy(xpath = "(//h3[@class='page-subheading'])[last()]")
		private WebElement lastAddressTitle;
		
		/**
		 * Input Address Information
		 */
		@FindBy(id = "lastname")
		private WebElement inputLastName;
		@FindBy(id = "company")
		private WebElement inputCompany;
		@FindBy(id = "address1")
		private WebElement inputAddress1;
		@FindBy(id = "address2")
		private WebElement inputAddress2;
		@FindBy(id = "city")
		private WebElement inputCity;
		@FindBy(xpath = "//option[@value='5']")
		private WebElement inputStateCalifornia;
		@FindBy(id = "postcode")
		private WebElement inputPostalCode;
		@FindBy(id = "phone")
		private WebElement inputHomePhone;
		@FindBy(id = "phone_mobile")
		private WebElement inputMobilePhone;
		@FindBy(id = "other")
		private WebElement inputAdditionalInfo;
		@FindBy(id = "alias")
		private WebElement inputForAddressTitle;
		@FindBy(id = "submitAddress")
		private WebElement buttonSaveAddress;
		
		public boolean isDisplayed() {
				return isElementDisplayed(pageHeading);
		}
		
		public MyAddressPage clickAddNewAddress() {
				clickElement(buttonAddNewAddress);
				return this;
		}
		
		public MyAddressPage inputAddress() {
				setTextElement(inputLastName, data.getLastName());
				setTextElement(inputCompany, data.getCompany());
				setTextElement(inputAddress1, data.getAddress());
				setTextElement(inputAddress2, data.getAddress2());
				setTextElement(inputCity, data.getCity());
				clickElement(inputStateCalifornia);
				setTextElement(inputPostalCode, data.getPostalCode());
				setTextElement(inputHomePhone, data.getHomePhone());
				setTextElement(inputMobilePhone, data.getMobilePhone());
				setTextElement(inputAdditionalInfo, data.getAdditionalInformation());
				setTextElement(inputForAddressTitle, data.getAddressTitle());
				return this;
		}
		
		public void submitAddress() {
				clickElement(buttonSaveAddress);
		}
		
		public String addressTitle() {
				return data.getAddressTitle().toUpperCase();
		}
		
		public String getLastAddressText() {
				return getTextElement(lastAddressTitle);
		}
}
