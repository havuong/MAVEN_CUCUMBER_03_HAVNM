package interfaces;

public class BalanceEnquiryPageUI {
	public static final String ACCOUNT_NO_TXT = "//input[@name='accountno']";
	public static final String SUBMIT_BTN = "//input[@name='AccSubmit']";
	public static final String DISPLAY_MSG = "//table[@id='balenquiry']//p[@class='heading3']";
	public static final String CURRENT_BALANCE = "//td[contains(text(),'Balance')]/following-sibling::td";
}
