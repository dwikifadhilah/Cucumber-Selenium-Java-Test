package pageobject.accountpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.BasePage;

public class CreditSlipsPage extends BasePage {
		public CreditSlipsPage(WebDriver driver) {
				super(driver);
		}
		
		@FindBy(css = ".page-heading")
		private WebElement pageHeading;
		
		public String getCreditSlipsPageHeading(){
				return getTextElement(pageHeading);
		}
}
