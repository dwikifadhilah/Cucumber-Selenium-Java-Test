package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TheHotelPrimePage extends BasePage {
		
		public TheHotelPrimePage(WebDriver driver) {
				super(driver);
		}
		
		/**
		 * Booking
		 */
		@FindBy(xpath = "//a[@data-id-product='1']")
		private WebElement buttonBookNowGeneralRoom;
		@FindBy(xpath = "//a[@data-id-product='3']")
		private WebElement buttonBookNowExecutiveRoom;
		@FindBy(xpath = "//a[@data-id-product='4']")
		private WebElement buttonBookNowLuxuryRoom;
		@FindBy(xpath = "//a[@class='btn btn-default button button-medium']")
		private WebElement buttonProceedCheckOut;
		
		/**
		 * Price feature
		 */
		@FindBy(xpath = "//div[@id='filter_price_silder']/a[2]")
		private WebElement priceSlider;
		@FindBy(xpath = "//span[@class='pull-right']")
		private WebElement maxPriceSlider;
		@FindBy(xpath = "//p[.='luxury Rooms']")
		private WebElement luxuryRoom;
		@FindBy(xpath = "//p[.='Executive Rooms']")
		private WebElement executiveRoom;
		
		/**
		 * Sort By Highest Price
		 */
		@FindBy(id = "price_ftr")
		private WebElement dropDownSortByPrice;
		@FindBy(xpath = "(//a)[@data-value='2'][2]")
		private WebElement sortByPriceHighestFirst;
		@FindBy(xpath = "(//span)[@class='pull-left rm_price_val '][1]")
		private WebElement highestPriceRoom;
		
		public TheHotelPrimePage clickBookNow(String rooms) {
				
				if (rooms.equalsIgnoreCase("General Rooms")) {
						clickElement(buttonBookNowGeneralRoom);
				} else if (rooms.equalsIgnoreCase("Executive rooms")) {
						clickElement(buttonBookNowExecutiveRoom);
				} else if (rooms.equalsIgnoreCase("Luxury Rooms")) {
						clickElement(buttonBookNowLuxuryRoom);
				}
				return this;
		}
		
		public void clickProceedCheckOut() {
				clickElement(buttonProceedCheckOut);
		}
		
		public WebElement sliderPriceRight() {
				waitVisibilityElement(priceSlider);
				return priceSlider;
		}
		
		public String getMaxPriceFilter() throws InterruptedException {
				Thread.sleep(1000);
				return getTextElement(maxPriceSlider);
		}
		
		public String getFirstHighestPriceRoom() throws InterruptedException {
				Thread.sleep(1000);
				return getTextElement(highestPriceRoom);
		}
		
		public boolean luxuryRoomIsDisplayed() {
				return isElementDisplayed(luxuryRoom);
		}
		
		public boolean executiveRoomIsDisplayed() {
				return isElementDisplayed(executiveRoom);
		}
		
		public void clickSortByHighestPrice() {
				clickElement(dropDownSortByPrice);
				clickElement(sortByPriceHighestFirst);
		}
}
