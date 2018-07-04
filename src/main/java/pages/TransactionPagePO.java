package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.TransactionPageUI;

public class TransactionPagePO extends AbstractPage{
	WebDriver driver;

	public TransactionPagePO(WebDriver _driver) {
		this.driver = _driver;
	}

	public void inputAcountNo(String accountNo) {
		waitForControlVisible(driver, TransactionPageUI.ACCOUNT_NO_TXT);
		sendkeyToElement(driver, TransactionPageUI.ACCOUNT_NO_TXT, accountNo);
	}

	public void inputAmount(String amount) {
		sendkeyToElement(driver, TransactionPageUI.AMOUNT_TXT, amount);
	}
	
	public void inputDescription(String description) {
		sendkeyToElement(driver, TransactionPageUI.DESCRIPTION_TXT, description);
	}
	
	public void clickSubmitButton() {
		clickToElement(driver, TransactionPageUI.SUBMIT_BTN);
	}

	public String getDisplayMessage() {
		waitForControlVisible(driver, TransactionPageUI.DISPLAY_MSG);
		return getTextElement(driver, TransactionPageUI.DISPLAY_MSG).trim();
	}

	public String getAccountDetails(String detail) {
		waitForControlVisible(driver, TransactionPageUI.ACCOUNT_VALUE, detail);
		return getAttributeValue(driver, TransactionPageUI.ACCOUNT_VALUE, detail);
	}
}
