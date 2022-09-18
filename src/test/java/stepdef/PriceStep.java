package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pageobject.TheHotelPrimePage;

import static stepdef.Hook.driver;

public class PriceStep {
		private final TheHotelPrimePage hotelPrimePage = new TheHotelPrimePage(driver);
		
		@When("I filter the prices using a slider with a price range between $1000 to $1889")
		public void filterPriceBySlider() {
				
				Actions action = new Actions(driver);
				action.clickAndHold(hotelPrimePage.sliderPriceRight())
							.moveByOffset(-100, 0).release().perform();
		}
		
		@Then("I see that the max price becomes {string}")
		public void priceHasBeenFiltered(String maxPrice) throws InterruptedException {
				
				Assert.assertEquals(hotelPrimePage.getMaxPriceFilter(), maxPrice);
		}
		
		@And("I should see that hotel rooms with prices over $1889 are not shown")
		public void hotelRoomNotShown() {
				
				Assert.assertFalse(hotelPrimePage.luxuryRoomIsDisplayed());
				Assert.assertFalse(hotelPrimePage.executiveRoomIsDisplayed());
		}
		
		@When("I sort price by Highest First")
		public void sortByHighestPrice() {
				
				hotelPrimePage
							.clickSortByHighestPrice();
		}
		
		@Then("I should see that the first room with price {string}")
		public void firstRoomIsTheHighest(String highestPrice) throws InterruptedException {
				
				Assert.assertEquals(hotelPrimePage.getFirstHighestPriceRoom(), highestPrice);
		}
}
