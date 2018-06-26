package stepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageBankSteps {
	WebDriver driver;
	WebDriverWait wait;
	String username, password, loginUrl;
	int emailUnique = randomEmail();

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

	@When("^I click to New customer page$")
	public void i_click_to_new_customer_page() {
		WebElement newCustomerPage = driver.findElement(By.xpath("//a[text()='New Customer']"));
		newCustomerPage.click();
	}

	@And("^I input all information to this page$")
	public void i_input_all_information_to_this_page(DataTable table) {
		WebElement nameTextbox = driver.findElement(By.xpath("//input[@name='name']"));
		WebElement genderRadioBtn = driver.findElement(By.xpath("//input[@value='f']"));
		WebElement dataOfBirthTextbox = driver.findElement(By.xpath("//input[@name='dob']"));
		WebElement addressTextbox = driver.findElement(By.xpath("//textarea[@name='addr']"));
		WebElement cityTextbox = driver.findElement(By.xpath("//input[@name='city']"));
		WebElement stateTextbox = driver.findElement(By.xpath("//input[@name='state']"));
		WebElement pinTextbox = driver.findElement(By.xpath("//input[@name='pinno']"));
		WebElement phoneTextbox = driver.findElement(By.xpath("//input[@name='telephoneno']"));
		WebElement emailTextbox = driver.findElement(By.xpath("//input[@name='emailid']"));
		WebElement passwordTextbox = driver.findElement(By.xpath("//input[@name='password']"));
		
		List<Map<String, String>> customer = table.asMaps(String.class, String.class);
		
		nameTextbox.sendKeys(customer.get(0).get("CustomerName"));
		genderRadioBtn.click();
		dataOfBirthTextbox.sendKeys(customer.get(0).get("DateOfBirth"));
		addressTextbox.sendKeys(customer.get(0).get("Address"));
		cityTextbox.sendKeys(customer.get(0).get("City"));
		stateTextbox.sendKeys(customer.get(0).get("State"));
		pinTextbox.sendKeys(customer.get(0).get("Pin"));
		phoneTextbox.sendKeys(customer.get(0).get("Phone"));
		emailTextbox.sendKeys(customer.get(0).get("Email") + emailUnique + "@gmail.com");
		passwordTextbox.sendKeys(customer.get(0).get("Password"));
	}
	
	@And("^I verify customer created success with information$")
	public void i_verify_customer_created_success_with_information(DataTable table) {
		WebElement nameText = driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td"));
		WebElement genderText = driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td"));
		WebElement addressText = driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td"));
		WebElement cityText = driver.findElement(By.xpath("//td[text()='City']/following-sibling::td"));
		WebElement stateText = driver.findElement(By.xpath("//td[text()='State']/following-sibling::td"));
		WebElement pinText = driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td"));
		WebElement mobileNumberText = driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td"));
		WebElement emailText = driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td"));
		
		List<Map<String, String>> customer = table.asMaps(String.class, String.class);
		Assert.assertEquals(nameText.getText(), customer.get(0).get("CustomerName"));
		Assert.assertEquals(genderText.getText(), customer.get(0).get("Gender"));
		Assert.assertEquals(addressText.getText(), customer.get(0).get("Address"));
		Assert.assertEquals(cityText.getText(), customer.get(0).get("City"));
		Assert.assertEquals(stateText.getText(), customer.get(0).get("State"));
		Assert.assertEquals(pinText.getText(), customer.get(0).get("Pin"));
		Assert.assertEquals(mobileNumberText.getText(), customer.get(0).get("Phone"));
		Assert.assertEquals(emailText.getText(), customer.get(0).get("Email") + emailUnique + "@gmail.com");
	}

	@And("^I click to Submit button$")
	public void i_click_to_submit_button() {
		WebElement submitButton = driver.findElement(By.xpath("//input[@name='sub']"));
		submitButton.click();
	}

	@And("^I close the browser$")
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
