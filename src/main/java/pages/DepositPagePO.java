package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.DepositPageUI;

public class DepositPagePO extends AbstractPage {
	WebDriver driver;

	public DepositPagePO(WebDriver driver_) {
		this.driver = driver_;
	}

	public void inputAccountNo(String accountNo) {
		waitForControlVisible(driver, DepositPageUI.ACCOUNT_NO_TXT);
		sendkeyToElement(driver, DepositPageUI.ACCOUNT_NO_TXT, accountNo);
	}

	public void inputAmount(String value) {
		waitForControlVisible(driver, DepositPageUI.AMOUNT_TXT);
		sendkeyToElement(driver, DepositPageUI.AMOUNT_TXT, value);
	}

	public void inputDescription(String value) {
		waitForControlVisible(driver, DepositPageUI.DESCRIPTION_TXT);
		sendkeyToElement(driver, DepositPageUI.DESCRIPTION_TXT, value);
	}

	public void clickSubmitButton() {
		clickToElement(driver, DepositPageUI.SUBMIT_BTN);
	}

	public String getTransactionDepositSuccessMsg() {
		waitForControlVisible(driver, DepositPageUI.TRANSACTION_DEPOSIT_SUCCESS_MSG);
		return getTextElement(driver, DepositPageUI.TRANSACTION_DEPOSIT_SUCCESS_MSG);
	}

	public int getCurrentBalance() {
		waitForControlVisible(driver, DepositPageUI.CURRENT_BALANCE_TXT);
		int balance = Integer.parseInt(getTextElement(driver, DepositPageUI.CURRENT_BALANCE_TXT));
		return balance;
	}
}
