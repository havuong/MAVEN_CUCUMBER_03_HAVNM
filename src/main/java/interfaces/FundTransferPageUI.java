package interfaces;

public class FundTransferPageUI {
	public static final String PAYER_ACCOUNT_NO_TXT = "//input[@name='payersaccount']";
	public static final String PAYEE_ACCOUNT_NO_TXT = "//input[@name='payeeaccount']";
	public static final String AMOUNT_TXT = "//input[@name='ammount']";
	public static final String DESCRIPTION_TXT = "//input[@name='desc']";
	public static final String SUBMIT_BTN = "//input[@name='AccSubmit']";
	public static final String FUND_TRANSFER_SUCCESS = "//p[text()='Fund Transfer Details']";
	public static final String FROM_ACCOUNT_TXT = "//td[text()='From Account Number']//following-sibling::td";
	public static final String TO_ACCOUNT_TXT = "//td[text()='To Account Number']//following-sibling::td";
	public static final String DISPLAY_MSG = "//p[@class='heading3']";
	public static final String AMOUNT = "//td[contains(text(),'Amount')]/following-sibling::td";
	public static final String DESCRIPTION = "//td[contains(text(),'Description')]/following-sibling::td";
}
