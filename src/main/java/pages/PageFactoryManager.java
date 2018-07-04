package pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
	private static HomePagePO homePage;
	private static LoginPagePO loginPage;
	private static RegisterPagePO registerPage;
	private static NewCustomerPagePO newCustomerPage;
	private static EditCustomerPagePO editCustomerPage;
	private static DeleteCustomerPagePO deleteCustomerPage;
	private static NewAccountPagePO newAccountPage;
	private static TransactionPagePO transactionPage;
	private static FundTransferPagePO fundTransferPage;
	private static BalanceEnquiryPagePO balanceEnquiryPage;
	private static DeleteAccountPagePO deleteAccountPage;
	private static EditAccountPagePO editAccountPage;
	private static DepositPagePO depositPage;
	private static WithdrawalPagePO withdrawalPage;

	public static HomePagePO getHomePage(WebDriver driver_) {
		if (homePage == null) {
			return new HomePagePO(driver_);
		}
		return homePage;
	}

	public static LoginPagePO getLoginPage(WebDriver driver_) {
		if (loginPage == null) {
			return new LoginPagePO(driver_);
		}
		return loginPage;
	}

	public static RegisterPagePO getRegisterPage(WebDriver driver_) {
		if (registerPage == null) {
			return new RegisterPagePO(driver_);
		}
		return registerPage;
	}

	public static NewCustomerPagePO getNewCustomerPage(WebDriver driver_) {
		if (newCustomerPage == null) {
			return new NewCustomerPagePO(driver_);
		}
		return newCustomerPage;
	}

	public static EditCustomerPagePO getEditCustomerPage(WebDriver driver_) {
		if (editCustomerPage == null) {
			return new EditCustomerPagePO(driver_);
		}
		return editCustomerPage;
	}

	public static DeleteCustomerPagePO getDeleteCustomerPage(WebDriver driver_) {
		if (deleteCustomerPage == null) {
			return new DeleteCustomerPagePO(driver_);
		}
		return deleteCustomerPage;
	}

	public static NewAccountPagePO getNewAccountPage(WebDriver driver) {
		if (newAccountPage == null) {
			return new NewAccountPagePO(driver);
		}
		return newAccountPage;
	}

	public static TransactionPagePO getTransactionPage(WebDriver driver) {
		if (transactionPage == null) {
			return new TransactionPagePO(driver);
		}
		return transactionPage;
	}

	public static FundTransferPagePO getFundTransferPage(WebDriver driver) {
		if (fundTransferPage == null) {
			return new FundTransferPagePO(driver);
		}
		return fundTransferPage;
	}

	public static BalanceEnquiryPagePO getBalanceEnquiryPage(WebDriver driver) {
		if (balanceEnquiryPage == null) {
			return new BalanceEnquiryPagePO(driver);
		}
		return balanceEnquiryPage;
	}

	public static DeleteAccountPagePO getDeleteAccountPage(WebDriver driver) {
		if (deleteAccountPage == null) {
			return new DeleteAccountPagePO(driver);
		}
		return deleteAccountPage;
	}
	
	public static EditAccountPagePO getEditAccountPage(WebDriver driver) {
		if (editAccountPage == null) {
			return new EditAccountPagePO(driver);
		}
		return editAccountPage;
	}
	
	public static DepositPagePO getDepositPage(WebDriver driver) {
		if (depositPage == null) {
			return new DepositPagePO(driver);
		}
		return depositPage;
	}
	
	public static WithdrawalPagePO getWithdrawalPage(WebDriver driver) {
		if (withdrawalPage == null) {
			return new WithdrawalPagePO(driver);
		}
		return withdrawalPage;
	}

}
