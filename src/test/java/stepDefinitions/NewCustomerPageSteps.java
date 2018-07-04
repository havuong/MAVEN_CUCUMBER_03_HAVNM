package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pages.NewCustomerPagePO;
import pages.PageFactoryManager;

public class NewCustomerPageSteps {
	WebDriver driver;
	String emailUnique;
	
	private NewCustomerPagePO newCustomerPage;

	public NewCustomerPageSteps() {
		driver = Hooks.openBrowser();
		newCustomerPage = PageFactoryManager.getNewCustomerPage(driver);
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
}
