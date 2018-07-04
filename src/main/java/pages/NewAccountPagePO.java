package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.NewAccountPageUI;

public class NewAccountPagePO extends AbstractPage {
	WebDriver driver;

	public NewAccountPagePO(WebDriver _driver) {
		this.driver = _driver;
	}

	public void inputCustomerID(String customerID) {
		waitForControlVisible(driver, NewAccountPageUI.CUSTOMER_ID_TXT);
		sendkeyToElement(driver, NewAccountPageUI.CUSTOMER_ID_TXT, customerID);
	}

	public void selectAccountType(String accountType) {
		selectItemInDropdown(driver, NewAccountPageUI.ACCOUNT_TYPE_DROPDOWN, accountType);
	}

	public void inputInitialDeposit(String initialDeposit) {
		sendkeyToElement(driver, NewAccountPageUI.INITIAL_DEPOSIT_TXT, initialDeposit);
	}

	public void clickSubmitButton() {
		clickToElement(driver, NewAccountPageUI.SUBMIT_BTN);
	}

	public String getSuccessfulMessage() {
		waitForControlVisible(driver, NewAccountPageUI.SUCCESSFUL_MSG);
		return getTextElement(driver, NewAccountPageUI.SUCCESSFUL_MSG).trim();
	}

	public String getAccountID() {
		waitForControlVisible(driver, NewAccountPageUI.ACCOUNT_NO_TXT);
		return getTextElement(driver, NewAccountPageUI.ACCOUNT_NO_TXT).trim();
	}

	public int getCurrentAmount() {
		int amount = Integer.parseInt(getTextElement(driver, NewAccountPageUI.CURRENT_AMOUNT_TXT));
		return amount;
	}
}
