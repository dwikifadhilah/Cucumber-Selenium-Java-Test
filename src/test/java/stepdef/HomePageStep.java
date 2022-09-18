package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.HomePage;

import static stepdef.Hook.driver;

public class HomePageStep {
		
		HomePage homePage = new HomePage(driver);
		
		@When("I open my booking cart")
		public void openMyBookingCart() {
				homePage
							.clickCart();
		}
		
		@Then("My booking cart should be open and message is {string}")
		public void bookingCartShouldBeOpen(String message) {
				Assert.assertEquals(homePage.getVerifyCart(), message);
		}
		
		@When("I open contact")
		public void openContact() {
				homePage
							.clickContact();
		}
		
		@Then("I see {string} page heading")
		public void contactPageIsDisplayed(String heading) {
				Assert.assertEquals(homePage.getContactHeader(), heading);
		}
		
		@And("I already open navbar")
		public void openNavbar() {
				homePage
							.openNavbar();
		}
		
		@When("I close navbar")
		public void closeNavbar() throws InterruptedException {
				homePage
							.closeNavbar();
		}
		
		@Then("I see navbar has been closed")
		public void navbarClosed() {
				Assert.assertFalse(homePage.navbarMenuClosed());
		}
		
		/**
		 * Search Hotel
		 */
		@When("I didn't fill in the {} but filled in other details")
		public void fillDetailsRooms(String data) {
				if (data.equalsIgnoreCase("Hotel Location")) {
						homePage
									.clickSelectHotel()
									.clickDateBooking()
									.clickSearchNow();
						
				} else if (data.equalsIgnoreCase("Select Hotel")) {
						homePage
									.inputHotelLocation()
									.clickDateBooking()
									.clickSearchNow();
						
				} else if (data.equalsIgnoreCase("Check In Date")) {
						homePage
									.inputHotelLocation()
									.clickSelectHotel()
									.selectDateCheckOut()
									.clickSearchNow();
						
				} else if (data.equalsIgnoreCase("Check Out Date")) {
						homePage
									.inputHotelLocation()
									.clickSelectHotel()
									.selectDateCheckIn()
									.clickSearchNow();
				}
		}
		
		@Then("I should see that failed to find a room and stayed on the {string} page")
		public void notDirectToRoomHotelPages(String page) {
				Assert.assertEquals(driver.getTitle(), page);
		}
}
