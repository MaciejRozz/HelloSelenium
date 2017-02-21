package pl.swa.maintests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Tc1 {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		baseUrl = "http://swa-tst.nac.gov.pl/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testTc1() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.name("_generic")).clear();
		driver.findElement(By.name("_generic")).sendKeys("wtorek");
		driver.findElement(By.cssSelector("input.submit.search_button")).click();
		driver.findElement(By.id("pole_wyszukiwania_search")).clear();
		driver.findElement(By.id("pole_wyszukiwania_search")).sendKeys("œroda");
		driver.findElement(By.cssSelector("input.search_button.submit")).click();
		String licznik = driver.findElement(By.xpath("//div[@id='contentBox']/div/div[2]/div/strong")).getText();
		// ERROR: Caught exception [ERROR: Unsupported command [getEval | var t;
		// t= ${licznik} > 1 | ]]
	}

	
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}