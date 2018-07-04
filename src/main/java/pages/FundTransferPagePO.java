package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.FundTransferPageUI;

public class FundTransferPagePO extends AbstractPage {
	WebDriver driver;

	public FundTransferPagePO(WebDriver _driver) {
		this.driver = _driver;
	}

	public void inputPayerAcountNo(String payerAccountNo) {
		waitForControlVisible(driver, FundTransferPageUI.PAYER_ACCOUNT_NO_TXT);
		sendkeyToElement(driver, FundTransferPageUI.PAYER_ACCOUNT_NO_TXT, payerAccountNo);
	}

	public void inputPayeeAcountNo(String accountNo) {
		sendkeyToElement(driver, FundTransferPageUI.PAYEE_ACCOUNT_NO_TXT, accountNo);
	}

	public void inputAmount(String amount) {
		sendkeyToElement(driver, FundTransferPageUI.AMOUNT_TXT, amount);
	}

	public void inputDescription(String description) {
		sendkeyToElement(driver, FundTransferPageUI.DESCRIPTION_TXT, description);
	}

	public String getDisplayMessage() {
		waitForControlVisible(driver, FundTransferPageUI.DISPLAY_MSG);
		return getTextElement(driver, FundTransferPageUI.DISPLAY_MSG);
	}

	public int getAmount() {
		waitForControlVisible(driver, FundTransferPageUI.AMOUNT);
		int amount = Integer.parseInt(getTextElement(driver, FundTransferPageUI.AMOUNT));
		return amount;
	}

	public String getDescription() {
		waitForControlVisible(driver, FundTransferPageUI.DESCRIPTION);
		return getTextElement(driver, FundTransferPageUI.DESCRIPTION);
	}
}
