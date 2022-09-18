package pageobject.orderpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.BasePage;
import testdata.SignUpData;

public class OrderPage extends BasePage {
		private final SignUpData signUpData;
		
		public OrderPage(WebDriver driver) {
				super(driver);
				signUpData = new SignUpData();
		}
		
		@FindBy(xpath = "//a[@class='btn btn-default button button-medium pull-right']")
		private WebElement buttonProceed;
		
		/**
		 * Sign Up
		 */
		@FindBy(id = "customer_firstname")
		private WebElement inputFirstName;
		@FindBy(id = "customer_lastname")
		private WebElement inputLastName;
		@FindBy(id = "email")
		private WebElement inputEmail;
		@FindBy(id = "passwd")
		private WebElement inputPassword;
		@FindBy(id = "phone_mobile")
		private WebElement inputPhoneNumber;
		@FindBy(id = "submitAccount")
		private WebElement buttonSave;
		
		/**
		 * Proceed To Payment
		 */
		@FindBy(xpath = "//a[@title='Proceed to Payment']")
		private WebElement buttonProceedPayment;
		@FindBy(css = ".checkbox")
		private WebElement checkBoxAgreement;
		
		/**
		 * Payment Method
		 */
		@FindBy(css = ".bankwire")
		private WebElement selectBankWirePayment;
		@FindBy(css = ".cheque")
		private WebElement selectCheckPayment;
		@FindBy(xpath = "//a[@title='Pay with PayPal']")
		private WebElement selectPaypalPayment;
		
		/**
		 * Confirm Payment
		 */
		@FindBy(css = ".pull-right.btn")
		private WebElement buttonConfirmOrder;
		
		public OrderPage clickProceed() {
				
				clickElement(buttonProceed);
				return this;
		}
		
		public OrderPage setCustomerData() {
				
				setTextElement(inputFirstName, signUpData.getFirstName());
				setTextElement(inputLastName, signUpData.getLastName());
				setTextElement(inputEmail, signUpData.getEmail());
				setTextElement(inputPassword, signUpData.getPassword());
				setTextElement(inputPhoneNumber, signUpData.getPhoneNumber());
				clickElement(buttonSave);
				return this;
		}
		
		public void clickProceedToPayment() {
				
				clickElement(buttonProceedPayment);
		}
		
		public void selectPaymentMethod(String payment) {
				
				clickElement(checkBoxAgreement);
				
				if (payment.equalsIgnoreCase("bank wire")) {
						
						clickElement(selectBankWirePayment);
						clickElement(buttonConfirmOrder);
						
				} else if (payment.equalsIgnoreCase("check")) {
						
						clickElement(selectCheckPayment);
						clickElement(buttonConfirmOrder);
						
				} else if (payment.equalsIgnoreCase("paypal")) {
						
						clickElement(selectPaypalPayment);
						
				}
		}
}
