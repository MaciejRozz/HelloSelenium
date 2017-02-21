package pl.swa.maintests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.util.regex.Pattern;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewTest4 {

	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void beforeTest() throws Exception {
		System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		System.setProperty("webdriver.ie.driver", "driver/IEDriverServer.exe");
		//driver = new FirefoxDriver();
		//driver = new InternetExplorerDriver();
		//driver = new HtmlUnitDriver(true);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);	
		
		baseUrl = "http://szukajwarchiwach.pl/";

	}

	@Test
	public void f() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.name("_generic")).clear();
		driver.findElement(By.name("_generic")).sendKeys("wtorek");
		driver.findElement(By.cssSelector("input.submit.search_button")).click();
		new WebDriverWait(driver, 4).until(ExpectedConditions.visibilityOfElementLocated(By.name("_generic")));
		//driver.findElement(By.name("_generic")).clear();
		//driver.findElement(By.name("_generic")).sendKeys("œroda");
		driver.findElement(By.cssSelector("input.search_button.submit")).click();
		String licznik = driver.findElement(By.xpath("//div[@id='contentBox']/div/div[2]/div/strong")).getText();
		
//		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		try {
//			FileUtils.copyFile(scrFile,  new File("abc.png"));
//		}
//		catch (IOException e){
//					e.printStackTrace();
//		}
//		// ERROR: Caught exception [ERROR: Unsupported command [getEval | var t;
		// t= ${licznik} > 1 | ]]
	}

	@AfterClass(alwaysRun = true)
	public void afterTest() throws Exception {
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
