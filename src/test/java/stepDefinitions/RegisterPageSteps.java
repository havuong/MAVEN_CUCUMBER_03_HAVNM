package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pages.PageFactoryManager;
import pages.RegisterPagePO;

public class RegisterPageSteps {
	WebDriver driver;
	private RegisterPagePO registerPage;
	String username, password, loginUrl = "http://demo.guru99.com/v4/";
	private AbstractTest abstractTest;

	public RegisterPageSteps() {
		driver = Hooks.openBrowser();
		registerPage = PageFactoryManager.getRegisterPage(driver);
		abstractTest = new AbstractTest();
	}

	@When("^I input to email textbox$")
	public void iInputToEmailTextbox() {
		registerPage.inputToEmailIDTextbox("Email" + abstractTest.randomData() + "@gmail.com");
	}

	@When("^I click to submit button at register page$")
	public void iClickToSubmitButtonAtRegisterPage() {
		registerPage.clickToSubmitButton();
	}

	@When("^I get to username information$")
	public void iGetToUsernameInformation() {
		username = registerPage.getUserIDInfo();
	}

	@When("^I get to password information$")
	public void iGetToPasswordInformation() {
		password = registerPage.getPasswordInfo();
	}

	@When("^I open to login page$")
	public void iOpenToLoginPage() {
		registerPage.openLoginPage(loginUrl);
	}
}
