package stepDefinitions;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageSteps {
	WebDriver driver;
	WebDriverWait wait;
	String username, password, loginUrl;

	@Given("^I open brower$")
	public void iOpenBrower() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 30);

		driver.get("http://demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Given("^I get login url$")
	public void iGetLoginUrl() {
		loginUrl = driver.getCurrentUrl();

	}

	@When("^I click to here link$")
	public void iClickToHereLink() {
		driver.findElement(By.xpath("//a[text()='here']")).click();
	}

	@When("^I input to email textbox$")
	public void iInputToEmailTextbox() {
		WebElement emailTextbox = driver.findElement(By.xpath("//input[@name='emailid']"));
		waitForElementVisible(emailTextbox);
		emailTextbox.sendKeys("automation" + randomEmail() + "@yopmail.com");

	}

	@When("^I click to submit button at register page$")
	public void iClickToSubmitButtonAtRegisterPage() {
		WebElement submitButton = driver.findElement(By.xpath("//input[@name='btnLogin']"));
		submitButton.click();
	}

	@When("^I get to username information$")
	public void iGetToUsernameInformation() {
		WebElement usernameText = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td"));
		waitForElementVisible(usernameText);
		username = usernameText.getText();

	}

	@When("^I get to password information$")
	public void iGetToPasswordInformation() {
		WebElement passwordText = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td"));
		password = passwordText.getText();

	}

	@When("^I open to login page$")
	public void iOpenToLoginPage() {
		driver.get(loginUrl);

	}

	@When("^I input to username textbox$")
	public void iInputToUsernameTextbox() {
		WebElement usernameTextbox = driver.findElement(By.xpath("//input[@name='uid']"));
		waitForElementVisible(usernameTextbox);
		usernameTextbox.sendKeys(username);
	}

	@When("^I input to password textbox$")
	public void iInputToPasswordTextbox() {
		WebElement passwordTextbox = driver.findElement(By.xpath("//input[@name='password']"));
		passwordTextbox.sendKeys(password);

	}

	@When("^I click to submit button at login page$")
	public void iClickToSubmitButtonAtLoginPage() {
		WebElement submitButton = driver.findElement(By.xpath("//input[@name='btnLogin']"));
		submitButton.click();

	}

	@Then("^verify homepage welcome message displayed$")
	public void verifyHomepageWelcomeMessageDisplayed() {
		WebElement homePageWelcomeMsg = driver.findElement(By.xpath("//marquee[contains(.,'Welcome To Manager')]"));
		Assert.assertTrue(homePageWelcomeMsg.isDisplayed());

	}

	@Then("^I close the brower$")
	public void iCloseTheBrowser() {
		driver.quit();
	}

	public void waitForElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public int randomEmail() {
		Random random = new Random();
		int number = random.nextInt(9999999);
		return number;
	}
}
