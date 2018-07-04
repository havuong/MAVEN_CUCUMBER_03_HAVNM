package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.DeleteAccountPageUI;

public class DeleteAccountPagePO extends AbstractPage {
	WebDriver driver;

	public DeleteAccountPagePO(WebDriver _driver) {
		this.driver = _driver;
	}

	public void inputAccountID(String accountID) {
		waitForControlVisible(driver, DeleteAccountPageUI.ACCOUNT_NO_TXT);
		sendkeyToElement(driver, DeleteAccountPageUI.ACCOUNT_NO_TXT, accountID);
	}

	public void clickSubmitButton() {
		clickToElement(driver, DeleteAccountPageUI.SUBMIT_BTN);
	}

	public void clickOKButtonOnAlert() {
		waitForAlertPresence(driver);
		acceptAlert(driver);
	}

	public String getTextOnAlert() {
		waitForAlertPresence(driver);
		return getTextAlert(driver);
	}
}
