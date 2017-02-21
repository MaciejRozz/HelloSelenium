package pl.swa.maintests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class NewTest2 {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	
  @Test
  public void f() {
	  	String str = "wtorek";
		driver.get( "http://google.pl/");
		//driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("wtorek");
		driver.findElement(By.name("q")).submit();
		new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains(str));
		AssertJUnit.assertTrue(driver.getTitle().contains(str));
//		driver.findElement(By.cssSelector("input.submit.search_button")).click();
//		driver.findElement(By.id("pole_wyszukiwania_search")).clear();
//		driver.findElement(By.id("pole_wyszukiwania_search")).sendKeys("œroda");
//		driver.findElement(By.cssSelector("input.search_button.submit")).click();
  }
  @BeforeClass
  public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new FirefoxDriver();
		//driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);		
  }

  @AfterClass
  public void afterTest() {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
  }

}
