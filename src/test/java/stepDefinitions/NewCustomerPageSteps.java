package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.AbstractPage;
import commons.AbstractTest;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pages.NewCustomerPagePO;
import pages.PageFactoryManager;

public class NewCustomerPageSteps {
	WebDriver driver;
	int emailUnique;
	String customerName, dob, address, city, state, pin, mobile, email, pass;

	private NewCustomerPagePO newCustomerPage;
	private AbstractPage abstractPage;
	private AbstractTest abstractTest;

	public NewCustomerPageSteps() {
		driver = Hooks.openBrowser();
		newCustomerPage = PageFactoryManager.getNewCustomerPage(driver);
		abstractPage = new AbstractPage();
		abstractTest = new AbstractTest();
		emailUnique = abstractTest.randomData();
	}

	@When("^I click to New customer page$")
	public void i_click_to_new_customer_page() {
		abstractPage.openNewCustomerPage(driver);
	}

	@And("^I input all information to this page$")
	public void i_input_all_information_to_this_page(DataTable table) {

		List<Map<String, String>> customer = table.asMaps(String.class, String.class);

		newCustomerPage.inputCustomerName(customer.get(0).get("CustomerName"));
		newCustomerPage.selectGender();
		newCustomerPage.inputDob(customer.get(0).get("DateOfBirth"));
		newCustomerPage.inputAddress(customer.get(0).get("Address"));
		newCustomerPage.inputCity(customer.get(0).get("City"));
		newCustomerPage.inputState(customer.get(0).get("State"));
		newCustomerPage.inputPIN(customer.get(0).get("Pin"));
		newCustomerPage.inputMobile(customer.get(0).get("Phone"));
		newCustomerPage.inputEmail(customer.get(0).get("Email") + emailUnique + "@gmail.com");
		newCustomerPage.inputPassword(customer.get(0).get("Password"));
	}

	@And("^I verify customer created success with information$")
	public void i_verify_customer_created_success_with_information(DataTable table) {
		List<Map<String, String>> customer = table.asMaps(String.class, String.class);

		Assert.assertEquals(newCustomerPage.getCustomerName(), customer.get(0).get("CustomerName"));
		Assert.assertEquals(newCustomerPage.getCustomerGender(), customer.get(0).get("Gender"));
		Assert.assertEquals(newCustomerPage.getCustomerAddress(), customer.get(0).get("Address"));
		Assert.assertEquals(newCustomerPage.getCustomerCity(), customer.get(0).get("City"));
		Assert.assertEquals(newCustomerPage.getCustomerState(), customer.get(0).get("State"));
		Assert.assertEquals(newCustomerPage.getCustomerPin(), customer.get(0).get("Pin"));
		Assert.assertEquals(newCustomerPage.getCustomerMobile(), customer.get(0).get("Phone"));
		Assert.assertEquals(newCustomerPage.getCustomerEmail(),
				customer.get(0).get("Email") + emailUnique + "@gmail.com");
	}

	@And("^I click to Submit button$")
	public void i_click_to_submit_button() {
		 newCustomerPage.clickToSubmit();
	}
}
