package pageobject;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
		private final WebDriverWait wait;
		
		public BasePage(WebDriver driver) {
				wait = new WebDriverWait(driver, Duration.ofSeconds(15));
				PageFactory.initElements(driver, this);
		}
		
		protected void waitToBeClickable(WebElement webElement) {
				wait.until(ExpectedConditions.elementToBeClickable(webElement));
		}
		
		protected void waitVisibilityElement(WebElement webElement) {
				wait.until(ExpectedConditions.visibilityOf(webElement));
		}
		
		protected boolean isElementDisplayed(WebElement webElement) {
				try {
						return webElement.isDisplayed();
				} catch (NoSuchElementException e) {
						return false;
				}
		}
		
		protected void clickElement(WebElement webElement) {
				waitToBeClickable(webElement);
				webElement.click();
		}
		
		protected void setTextElement(WebElement webElement, String text) {
				waitVisibilityElement(webElement);
				webElement.clear();
				webElement.sendKeys(text);
		}
		
		protected String getTextElement(WebElement webElement) {
				waitVisibilityElement(webElement);
				return webElement.getText();
		}
}