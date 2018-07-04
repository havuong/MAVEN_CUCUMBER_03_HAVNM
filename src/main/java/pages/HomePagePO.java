package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.HomePageUI;

public class HomePagePO extends AbstractPage{
	WebDriver driver;
	
	public HomePagePO(WebDriver driver_){
		this.driver = driver_;
	}
	
	public boolean isWelcomeMessageDisplayed() {
		waitForControlVisible(driver, HomePageUI.WELCOM_MESSAGE);
		return isControlDisplayed(driver, HomePageUI.WELCOM_MESSAGE);
	}
}
