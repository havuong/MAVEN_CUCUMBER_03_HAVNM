package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.DeleteCustomerPageUI;

public class DeleteCustomerPagePO extends AbstractPage{
	WebDriver driver;

	public DeleteCustomerPagePO(WebDriver driver_) {
		this.driver = driver_;
	}
	public void inputCustomerID(String customerID) {
		waitForControlVisible(driver, DeleteCustomerPageUI.CUSTOMER_ID_TXT);
		sendkeyToElement(driver, DeleteCustomerPageUI.CUSTOMER_ID_TXT, customerID);
	}
	public String getSuccessMsg(WebDriver driver){
		String text = getTextAlert(driver);
		acceptAlert(driver);
		return text;
	}
}
