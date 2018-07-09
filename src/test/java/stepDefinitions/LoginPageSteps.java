package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pages.LoginPagePO;
import pages.PageFactoryManager;

public class LoginPageSteps extends ShareData{
	WebDriver driver;

	private LoginPagePO loginPage;
	private ShareData shareData;

	public LoginPageSteps(ShareData shareData) {
		driver = Hooks.openBrowser();
		loginPage = PageFactoryManager.getLoginPage(driver);
		this.shareData = shareData;
	}

	@Given("^I get login url$")
	public void iGetLoginUrl() {
		shareData.loginUrl = loginPage.getLoginPageUrl();
	}

	@When("^I click to here link$")
	public void iClickToHereLink() {
		loginPage.clickToHereLink();
	}

	@When("^I input to username textbox$")
	public void iInputToUsernameTextbox() {
		loginPage.inputToUsernameTextbox(shareData.username);
	}

	@When("^I input to password textbox$")
	public void iInputToPasswordTextbox() {
		loginPage.inputToPasswordTextbox(shareData.password);
	}

	@When("^I click to submit button at login page$")
	public void iClickToSubmitButtonAtLoginPage() {
		loginPage.clickToSubmitButton();
	}

}
