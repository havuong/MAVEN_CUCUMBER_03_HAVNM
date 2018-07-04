package interfaces;

public class DepositPageUI {
	public static final String ACCOUNT_NO_TXT = "//input[@name='accountno']";
	public static final String AMOUNT_TXT = "//input[@name='ammount']";
	public static final String DESCRIPTION_TXT = "//input[@name='desc']";
	public static final String TRANSACTION_DEPOSIT_SUCCESS_MSG = "//table[@id='deposit']//p[@class='heading3']";
	public static final String CURRENT_BALANCE_TXT = "//td[text()='Current Balance']/following-sibling::td";
	public static final String SUBMIT_BTN = "//input[@name='AccSubmit']";
}
