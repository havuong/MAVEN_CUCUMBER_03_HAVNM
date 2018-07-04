package interfaces;

public class TransactionPageUI {
	public static final String ACCOUNT_NO_TXT = "//input[@name='accountno']";
	public static final String AMOUNT_TXT = "//input[@name='ammount']";
	public static final String DESCRIPTION_TXT = "//input[@name='desc']";
	public static final String SUBMIT_BTN = "//input[@name='AccSubmit']";
	public static final String DISPLAY_MSG = "//p[@class='heading3']";
	public static final String CURRENT_BALANCE = "//td[contains(text(),'Current Balance')]/following-sibling::td";
	public static final String ACCOUNT_VALUE = "//td[contains(text(),'%s')]/following-sibling::td";
}
