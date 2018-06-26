package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageGuruSteps {
	WebDriver driver;
	
	@Given("^I open to live guru site$")
    public void i_open_to_live_guru_site() {
        driver = new FirefoxDriver();
        driver.get("http://live.guru99.com");
        driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
    }

    @And("^I open to my account page$")
    public void i_open_to_my_account_page() {
        WebElement myAccountLink = driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']"));
        myAccountLink.click();
    }
    
    @When("^I input to username textbox is \"([^\"]*)\"$")
    public void i_input_to_username_textbox_is(String username) {
    	WebElement userTextbox = driver.findElement(By.xpath("//input[@id='email']"));
        userTextbox.sendKeys(username);
    }

    @And("^I input to password textbox is \"([^\"]*)\"$")
    public void i_input_to_password_textbox_is(String password) {
        WebElement passwordTextbox = driver.findElement(By.xpath("//input[@id='pass']"));
        passwordTextbox.sendKeys(password);
    }

    @And("^I click to login button$")
    public void i_click_to_login_button() {
    	WebElement loginButton = driver.findElement(By.xpath("//button[@id='send2']"));
    	loginButton.click();
    }
    
    @Then("^I verify homepage displayed with message is \"([^\"]*)\"$")
    public void i_verify_homepage_displayed(String message) {
        WebElement myDashboard = driver.findElement(By.xpath("//h1[text()='"+ message +"']"));
        Assert.assertTrue(myDashboard.isDisplayed());
    }
    
    @When("^I click to Account link$")
    public void i_click_to_account_link() {
        WebElement accountLink = driver.findElement(By.xpath("//span[text()='Account']"));
        accountLink.click();
    }
    
    @And("^I click to Logout link$")
    public void i_click_to_logout_link() {
        WebElement logoutLink = driver.findElement(By.xpath("//a[text()='Log Out']"));
        logoutLink.click();
    }

}
