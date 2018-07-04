package stepDefinitions;

import org.openqa.selenium.WebDriver;

import pages.PageFactoryManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pages.LoginPagePO;

public class LoginPageSteps {
	WebDriver driver;
	String username = "mngr141058", password = "UbehEqy", loginUrl;

	private LoginPagePO loginPage;

	public LoginPageSteps() {
		driver = Hooks.openBrowser();
		loginPage = PageFactoryManager.getLoginPage(driver);
	}

	@Given("^I get login url$")
	public void iGetLoginUrl() {
		loginUrl = loginPage.getLoginPageUrl();
	}

	@When("^I click to here link$")
	public void iClickToHereLink() {
		loginPage.clickToHereLink();
	}

	@When("^I input to username textbox$")
	public void iInputToUsernameTextbox() {
		loginPage.inputToUsernameTextbox(username);
	}

	@When("^I input to password textbox$")
	public void iInputToPasswordTextbox() {
		loginPage.inputToPasswordTextbox(password);
	}

	@When("^I click to submit button at login page$")
	public void iClickToSubmitButtonAtLoginPage() {
		loginPage.clickToSubmitButton();
	}

}
