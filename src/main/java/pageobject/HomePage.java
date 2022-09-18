package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
		
		public HomePage(WebDriver driver) {
				super(driver);
		}
		
		/**
		 * Button
		 */
		@FindBy(css = ".user_login")
		private WebElement buttonSignIn;
		@FindBy(id = "hotel_location")
		private WebElement inputHotelLocation;
		@FindBy(id = "id_hotel_button")
		private WebElement buttonSelectHotel;
		@FindBy(id = "check_in_time")
		private WebElement buttonDateCheckIn;
		@FindBy(xpath = "//input[@id='check_out_time']")
		private WebElement buttonDateCheckOut;
		@FindBy(css = ".ui-datepicker-next")
		private WebElement buttonNextMonth;
		@FindBy(id = "search_room_submit")
		private WebElement buttonSearchNow;
		
		/**
		 * Test Data
		 */
		@FindBy(xpath = "//ul[@class='location_search_results_ul']/li")
		private WebElement selectAlabama;
		@FindBy(css = ".search_result_li")
		private WebElement selectTheHotelPrime;
		@FindBy(xpath = "//a[.='20']")
		private WebElement selectDateCheckIn;
		@FindBy(xpath = "//a[.='21']")
		private WebElement selectDateCheckOut;
		
		/**
		 * Cart
		 */
		@FindBy(css = ".shopping_cart")
		private WebElement buttonCart;
		@FindBy(css = ".alert")
		private WebElement verifyCart;
		
		/**
		 * NavBar
		 */
		@FindBy(css = ".nav_toggle")
		private WebElement buttonNavbar;
		@FindBy(css = ".close_navbar")
		private WebElement closeNavbar;
		
		@FindBy(xpath = "//ul[@class='nav nav-pills nav-stacked wk-nav-style']/li[8]")
		private WebElement buttonContact;
		@FindBy(css = ".contact-header")
		private WebElement getContactHeader;
		
		/**
		 * Booking Scenario
		 */
		public HomePage inputHotelLocation() {
				setTextElement(inputHotelLocation, "ala");
				clickElement(selectAlabama);
				return this;
		}
		
		public HomePage clickSelectHotel() {
				clickElement(buttonSelectHotel);
				clickElement(selectTheHotelPrime);
				
				return this;
		}
		
		public HomePage clickDateBooking() {
				
				clickElement(buttonDateCheckIn);
				
				for (int i = 0; i <= 5; i++) {
						clickElement(buttonNextMonth);
						if (i == 5) {
								break;
						}
				}
				
				clickElement(selectDateCheckIn);
				clickElement(selectDateCheckOut);
				return this;
		}
		
		public HomePage selectDateCheckIn() {
				
				clickElement(buttonDateCheckIn);
				
				for (int i = 0; i <= 5; i++) {
						clickElement(buttonNextMonth);
						if (i == 5) {
								break;
						}
				}
				clickElement(selectDateCheckIn);
				return this;
		}
		
		public HomePage selectDateCheckOut() {
				
				clickElement(buttonDateCheckOut);
				
				for (int i = 0; i <= 5; i++) {
						clickElement(buttonNextMonth);
						if (i == 5) {
								break;
						}
				}
				
				clickElement(selectDateCheckOut);
				return this;
		}
		
		public void clickSearchNow() {
				clickElement(buttonSearchNow);
		}
		
		/**
		 * Login
		 */
		public void clickSignIn() {
				clickElement(buttonSignIn);
		}
		
		/**
		 * Cart
		 */
		public void clickCart() {
				clickElement(buttonCart);
		}
		
		public String getVerifyCart() {
				return getTextElement(verifyCart);
		}
		
		public void clickContact() {
				clickElement(buttonNavbar);
				clickElement(buttonContact);
		}
		
		public String getContactHeader() {
				return getTextElement(getContactHeader);
		}
		
		public void openNavbar() {
				clickElement(buttonNavbar);
		}
		
		public void closeNavbar() throws InterruptedException {
				clickElement(closeNavbar);
				Thread.sleep(1000);
		}
		
		public boolean navbarMenuClosed() {
				return closeNavbar.isDisplayed();
		}
		
}
