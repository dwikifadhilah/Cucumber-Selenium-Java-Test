package pageobject.accountpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.BasePage;

public class OrderHistoryPage extends BasePage {
		public OrderHistoryPage(WebDriver driver) {
				super(driver);
		}
		
		@FindBy(css = ".page-heading")
		private WebElement pageHeading;
		
		public String getOrderPageHeading() {
				return getTextElement(pageHeading);
		}
}
