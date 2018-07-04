package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.DepositPageUI;
import interfaces.WithdrawalPageUI;

public class WithdrawalPagePO extends AbstractPage {
	WebDriver driver;

	public WithdrawalPagePO(WebDriver driver_) {
		this.driver = driver_;
	}

	public void inputAccountNo(String accountNo) {
		waitForControlVisible(driver, WithdrawalPageUI.ACCOUNT_NO_TXT);
		sendkeyToElement(driver, WithdrawalPageUI.ACCOUNT_NO_TXT, accountNo);
	}

	public void inputAmount(String value) {
		waitForControlVisible(driver, WithdrawalPageUI.AMOUNT_TXT);
		sendkeyToElement(driver, WithdrawalPageUI.AMOUNT_TXT, value);
	}

	public void inputDescription(String value) {
		waitForControlVisible(driver, WithdrawalPageUI.DESCRIPTION_TXT);
		sendkeyToElement(driver, WithdrawalPageUI.DESCRIPTION_TXT, value);
	}
	public void clickSubmitButton() {
		clickToElement(driver, DepositPageUI.SUBMIT_BTN);
	}

	public String getTransactionWithdrawalSuccessMsg() {
		waitForControlVisible(driver, WithdrawalPageUI.TRANSACTION_WITHDRAWAL_SUCCESS_MSG);
		return getTextElement(driver, WithdrawalPageUI.TRANSACTION_WITHDRAWAL_SUCCESS_MSG);
	}

	public int getCurrentBalance() {
		waitForControlVisible(driver, WithdrawalPageUI.CURRENT_BALANCE_TXT);
		int balance = Integer.parseInt(getTextElement(driver, WithdrawalPageUI.CURRENT_BALANCE_TXT));
		return balance;
	}
}
