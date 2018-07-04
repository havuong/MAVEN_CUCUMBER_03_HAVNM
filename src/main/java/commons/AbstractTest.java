package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

public class AbstractTest {
	WebDriver driver;
	
	public final Log log;
	
	public AbstractTest(){
		log = LogFactory.getLog(getClass());
	}

	public WebDriver openMultiBrowser(String browser, String url, String version) {
		if (browser.equalsIgnoreCase("firefox")) {
			FirefoxDriverManager.getInstance().setup();
			// System.setProperty("webdriver.gecko.driver",
			// ".\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			ChromeDriverManager.getInstance().version(version).setup();
			// System.setProperty("webdriver.chrome.driver",
			// ".\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			InternetExplorerDriverManager.getInstance().version(version).setup();
			driver = new InternetExplorerDriver();
			/*
			 * System.setProperty("webdriver.ie.driver",
			 * ".\\resources\\IEDriverServer.exe"); DesiredCapabilities
			 * capabilities = new DesiredCapabilities();
			 * capabilities.setJavascriptEnabled(true);
			 * capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,
			 * true); capabilities.setCapability("ignoreProtectedModeSettings",
			 * true); driver = new InternetExplorerDriver(capabilities);
			 */
		}

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public int randomData() {
		Random rand = new Random();
		int number = rand.nextInt(999999) + 1;
		return number;
	}

	public void closeBrowser(WebDriver driver) {
		try {
			String os = System.getProperty("os.name").toLowerCase();
			String cmd = "";
			driver.quit();
			if (driver.toString().toLowerCase().contains("chrome")) {
				if (os.toLowerCase().contains("mac")) {
					cmd = "pkill chromedriver";
				} else {
					cmd = "taskkill /IM Chromedriver.exe /F";
				}
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
			if (driver.toString().toLowerCase().contains("internetexplorer")) {
				if (os.toLowerCase().contains("mac")) {
					cmd = "pkill IEDriverServer";
				} else {
					cmd = "taskkill /IM IEDriverServer.exe /F";
				}
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private boolean verifyPassed(boolean condition, boolean flag) {
		boolean pass = true;
		if (flag == false) {
			try {
				Assert.assertTrue(condition);
			} catch (Throwable e) {
				pass = false;
				Reporter.getCurrentTestResult().setThrowable(e);
			}
		} else {
			Assert.assertTrue(condition);
		}
		return pass;
	}

	public boolean verifyTrue(boolean condition) {
		return verifyPassed(condition, false);
	}

	private boolean verifyFailed(boolean condition, boolean flag) {
		boolean pass = true;
		if (flag == false) {
			try {
				Assert.assertFalse(condition);
			} catch (Throwable e) {
				pass = false;
				Reporter.getCurrentTestResult().setThrowable(e);
			}
		} else {
			Assert.assertFalse(condition);
		}
		return pass;
	}

	public boolean verifyFailed(boolean condition) {
		return verifyFailed(condition, false);
	}

	private boolean verifyEquals(Object actual, Object expected, boolean flag) {
		boolean pass = true;
		if (flag == false) {
			try {
				Assert.assertEquals(actual, expected);
			} catch (Throwable e) {
				pass = false;
				Reporter.getCurrentTestResult().setThrowable(e);
			}
		} else {
			Assert.assertEquals(actual, expected);
		}
		return pass;
	}

	public boolean verifyEquals(Object actual, Object expected) {
		return verifyEquals(actual, expected, false);

	}

}
