package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.HomePage;
import pageobject.TheHotelPrimePage;
import pageobject.accountpage.AccountPage;
import pageobject.orderpage.OrderConfirmationPage;
import pageobject.orderpage.OrderPage;

import static stepdef.Hook.driver;

public class BookingStep {
		private final OrderPage orderPage = new OrderPage(driver);
		private final OrderConfirmationPage confirmationPage = new OrderConfirmationPage(driver);
		
		/**
		 * Order Without Login
		 */
		@When("I choose hotel and choose a booking date")
		public void chooseHotel() {
				
				HomePage homePage = new HomePage(driver);
				homePage
							.clickSelectHotel()
							.clickDateBooking()
							.clickSearchNow();
		}
		
		@And("I choose a {}")
		public void chooseRooms(String rooms) {
				
				TheHotelPrimePage roomPage = new TheHotelPrimePage(driver);
				roomPage
							.clickBookNow(rooms)
							.clickProceedCheckOut();
		}
		
		@And("I followed the order step and signup")
		public void followedTheBookingStepAndSignUp() {
				
				orderPage
							.clickProceed()
							.setCustomerData()
							.clickProceedToPayment();
		}
		
		@And("I select {} payment method")
		public void choosePayment(String payment) {
				
				orderPage
							.selectPaymentMethod(payment);
		}
		
		@Then("I should see the booking status {}")
		public void seeStatusBooking(String message) {
				
				if (message.contains("try")) {
						
						Assert.assertEquals(confirmationPage.getPaypalFailedMessage(), message);
						
				} else {
						
						Assert.assertEquals(confirmationPage.getSuccessBookingMessage(), message);
				}
		}
		
		@And("I should see total amount include tax is {}")
		public void totalPaymentAmount(String amount) {
				
				if (amount.contains("Error")) {
						Assert.assertEquals(confirmationPage.getPaypalFailedHeading(), amount);
				} else {
						Assert.assertEquals(confirmationPage.getDueAmount(), amount);
						
				}
		}
		
		/**
		 * Order After Login
		 */
		@And("I back to homepage after login")
		public void backToHomePageAfterLogin() {
				
				AccountPage accountPage = new AccountPage(driver);
				accountPage
							.clickBackToHome();
		}
		
		@And("I followed the order step")
		public void followTheOrderStep() {
				
				orderPage
							.clickProceed()
							.clickProceedToPayment();
		}
}
