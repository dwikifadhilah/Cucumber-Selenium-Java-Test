package pageobject.orderpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.BasePage;

public class OrderConfirmationPage extends BasePage {
		public OrderConfirmationPage(WebDriver driver) {
				super(driver);
		}
		
		
		@FindBy(css = ".alert")
		private WebElement successMessage;
		@FindBy(xpath = "//div[@id='center_column']/h2")
		private WebElement failedHeadingPaypal;
		@FindBy(css = "b")
		private WebElement failedMessagePaypal;
		@FindBy(xpath = "//tr[4]//td[3]/span")
		private WebElement dueAmount;
		
		public String getSuccessBookingMessage() {
				return getTextElement(successMessage);
		}
		
		public String getDueAmount() {
				return getTextElement(dueAmount);
		}
		
		public String getPaypalFailedHeading() {
				return getTextElement(failedHeadingPaypal);
		}
		
		public String getPaypalFailedMessage() {
				return getTextElement(failedMessagePaypal);
		}
}
