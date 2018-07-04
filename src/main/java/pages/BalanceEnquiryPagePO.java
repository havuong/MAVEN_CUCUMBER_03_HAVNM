package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.BalanceEnquiryPageUI;

public class BalanceEnquiryPagePO extends AbstractPage {
	WebDriver driver;

	public BalanceEnquiryPagePO(WebDriver _driver) {
		this.driver = _driver;
	}

	public void inputAccountID(String accountID) {
		waitForControlVisible(driver, BalanceEnquiryPageUI.ACCOUNT_NO_TXT);
		sendkeyToElement(driver, BalanceEnquiryPageUI.ACCOUNT_NO_TXT, accountID);
	}

	public void clickSubmitButton() {
		clickToElement(driver, BalanceEnquiryPageUI.SUBMIT_BTN);
	}

	public String getDisplayMessage() {
		waitForControlVisible(driver, BalanceEnquiryPageUI.DISPLAY_MSG);
		return getTextElement(driver, BalanceEnquiryPageUI.DISPLAY_MSG).trim();
	}

	public int getCurrentBalance() {
		waitForControlVisible(driver, BalanceEnquiryPageUI.CURRENT_BALANCE);
		int balance = Integer.parseInt(getTextElement(driver, BalanceEnquiryPageUI.CURRENT_BALANCE).trim());
		return balance;
	}
}
