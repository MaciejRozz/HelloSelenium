package pl.swa.maintests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * @author Administrator
 *
 */
public class NewTest {
	private WebDriver driver;
	
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	
	
	@Test
	public void test() {
		//fail("Not yet implemented");
		driver.get( "http://google.pl/");
		driver.findElement(By.name("_generic")).clear();
		driver.findElement(By.name("_generic")).sendKeys("wtorek");
		driver.findElement(By.cssSelector("input.submit.search_button")).click();
		driver.findElement(By.id("pole_wyszukiwania_search")).clear();
		driver.findElement(By.id("pole_wyszukiwania_search")).sendKeys("œroda");
		driver.findElement(By.cssSelector("input.search_button.submit")).click();
		String licznik = driver.findElement(By.xpath("//div[@id='contentBox']/div/div[2]/div/strong")).getText();		
	}

	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:/selenium/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");
		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		//baseUrl = "http://swa-tst.nac.gov.pl/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}
}
