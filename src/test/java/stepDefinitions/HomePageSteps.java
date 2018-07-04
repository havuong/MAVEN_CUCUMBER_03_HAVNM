package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import cucumber.api.java.en.Then;
import cucumberOptions.Hooks;
import pages.HomePagePO;
import pages.PageFactoryManager;

public class HomePageSteps {
	WebDriver driver;
	private HomePagePO homePage;
	private AbstractTest abstractTest;
	
	public HomePageSteps() {
		driver = Hooks.openBrowser();
		homePage = PageFactoryManager.getHomePage(driver);
		abstractTest = new AbstractTest();
	}
	
	@Then("^verify homepage welcome message displayed$")
	public void verifyHomepageWelcomeMessageDisplayed() {
		abstractTest.verifyTrue(homePage.isWelcomeMessageDisplayed());
	}
}
