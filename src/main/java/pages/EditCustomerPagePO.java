package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.EditCustomerPageUI;

public class EditCustomerPagePO extends AbstractPage {
	WebDriver driver;

	public EditCustomerPagePO(WebDriver driver_) {
		this.driver = driver_;
	}

	public void inputCustomerID(String customerID) {
		waitForControlVisible(driver, EditCustomerPageUI.CUSTOMER_ID_TXT);
		sendkeyToElement(driver, EditCustomerPageUI.CUSTOMER_ID_TXT, customerID);
	}

	public void inputAddess(String value) {
		waitForControlVisible(driver, EditCustomerPageUI.ADDRESS_TXT);
		sendkeyToElement(driver, EditCustomerPageUI.ADDRESS_TXT, value);
	}

	public void inputCity(String value) {
		waitForControlVisible(driver, EditCustomerPageUI.CTIY_TXT);
		sendkeyToElement(driver, EditCustomerPageUI.CTIY_TXT, value);
	}

	public void inputState(String value) {
		waitForControlVisible(driver, EditCustomerPageUI.STATE_TXT);
		sendkeyToElement(driver, EditCustomerPageUI.STATE_TXT, value);
	}

	public void inputPIN(String value) {
		waitForControlVisible(driver, EditCustomerPageUI.PIN_TXT);
		sendkeyToElement(driver, EditCustomerPageUI.PIN_TXT, value);
	}

	public void inputMobile(String value) {
		waitForControlVisible(driver, EditCustomerPageUI.MOBILE_TXT);
		sendkeyToElement(driver, EditCustomerPageUI.MOBILE_TXT, value);
	}

	public void inputEmail(String value) {
		waitForControlVisible(driver, EditCustomerPageUI.EMAIL_TXT);
		sendkeyToElement(driver, EditCustomerPageUI.EMAIL_TXT, value);
	}

	public String getUpdateCustomerSuccessMsg() {
		waitForControlVisible(driver, EditCustomerPageUI.EDIT_CUSTOMER_SUCCESS_MSG);
		return getTextElement(driver, EditCustomerPageUI.EDIT_CUSTOMER_SUCCESS_MSG);
	}

	public void clickSubmitButton() {
		clickToElement(driver, EditCustomerPageUI.SUBMIT_BTN);
	}

}
