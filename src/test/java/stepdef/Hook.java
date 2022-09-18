package stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.HomePage;
import pageobject.LoginPage;

public class Hook {
		protected static WebDriver driver;
		
		/**
		 * Background
		 */
		@Given("I navigated to homepage")
		public void openLandingPage() {
				
				driver.get("http://qa.cilsy.id:8080/");
		}
		
		@And("I login with existing account")
		public void loginWithExistingAccount() {
				HomePage homePage = new HomePage(driver);
				homePage
							.clickSignIn();
				
				LoginPage loginPage = new LoginPage(driver);
				loginPage
							.loginExistingAccount();
		}
		
		@Before
		public void setup() {
				WebDriverManager.chromedriver().setup();
				
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
		}
		
		@After
		public void tearDown() {
				driver.quit();
		}
}
