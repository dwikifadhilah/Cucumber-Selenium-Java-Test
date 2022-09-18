package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobject.accountpage.*;

import static stepdef.Hook.driver;

public class AccountStep {
		private final AccountPage accountPage = new AccountPage(driver);
		private MyAddressPage addAddress;
		private final PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
		
		/**
		 * Add Address
		 */
		@Given("I already in {string} page")
		public void openMyAccountPage(String page) {
				
				Assert.assertEquals(driver.getTitle(), page);
		}
		
		@When("I click MY ADDRESSES")
		public void openMyAddresses() {
				
				Assert.assertTrue(accountPage.isDisplayed());
				accountPage.clickAddress();
		}
		
		@And("I add a new address")
		public void addNewAddress() {
				
				addAddress = new MyAddressPage(driver);
				addAddress
							.clickAddNewAddress()
							.inputAddress()
							.submitAddress();
		}
		
		@Then("I should see my address has been added")
		public void successAddAddress() {
				
				Assert.assertEquals(addAddress.getLastAddressText(), addAddress.addressTitle());
		}
		
		/**
		 * Order History
		 */
		@When("I select Order History and Details")
		public void openOrderHistory() {
				
				Assert.assertTrue(accountPage.isDisplayed());
				accountPage.clickOrderHistory();
		}
		
		@Then("I should see order history page with page heading {string}")
		public void successOpenOrderHistory(String pageTitle) {
				
				OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);
				Assert.assertEquals(orderHistoryPage.getOrderPageHeading(), pageTitle);
		}
		
		/**
		 * Credit Slips
		 */
		@When("I select My Credit Slips")
		public void openCreditSlips() {
				
				Assert.assertTrue(accountPage.isDisplayed());
				accountPage.clickCreditSlips();
		}
		
		@Then("I should see credit slips page with page heading {string}")
		public void successOpenCreditSlips(String pageHeading) {
				
				CreditSlipsPage creditSlipsPage = new CreditSlipsPage(driver);
				Assert.assertEquals(creditSlipsPage.getCreditSlipsPageHeading(), pageHeading);
		}
		
		/**
		 * Personal Information
		 */
		@When("I select My Personal Information")
		public void openPersonalInformation() {
				
				Assert.assertTrue(accountPage.isDisplayed());
				accountPage
							.clickPersonalInformation();
		}
		
		@And("I edit my last name")
		public void editMyInfo() {
				
				personalInformationPage.editLastName();
		}
		
		@And("I input {} credentials with a {}")
		public void inputPassword(String type, String password) {
				
				personalInformationPage.inputOldPassword(password);
				personalInformationPage.clickSaveButton();
		}
		
		@Then("I should get message {}")
		public void successChangeProfile(String status) {
				
				if (status.contains("password")) {
						
						Assert.assertEquals(personalInformationPage.getErrorMessage(), status);
						
				} else if (status.contains("successfully")) {
						
						Assert.assertEquals(personalInformationPage.getSuccessEditProfileMessage(), status);
				}
		}
		
		@And("I change {} using number {}")
		public void changeNameWithNumber(String name, String number) {
				if (name.contains("first")) {
						personalInformationPage
									.inputFirstName(number);
				} else {
						personalInformationPage
									.inputLastName(number);
				}
		}
		
		@Then("I should get error message {}")
		public void getErrorNameMessage(String error) {
				
				Assert.assertEquals(personalInformationPage.getErrorMessage(), error);
		}
}
