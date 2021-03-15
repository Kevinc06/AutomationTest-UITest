package uitest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UiTest {
	/* Target website address */
	String url; 
	/* Selenium WebDriver object */
	WebDriver driver; 
	
	@Before
	public void start() {
		/* assign the site that I will use in the test */
		url = "http://demo.cs-cart.com";
		/* I indicated the location where my webdriver file of my browser is located, 
		 * this path will change according to where the test is done */
		System.setProperty("webdriver.chrome.driver", 
	    "C:\\Users\\kevin\\eclipse-workspace\\UITest\\drivers\\chrome\\84\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
	}
	
	@After
	public void finish() {
		driver.quit();
	}
	@Test
	public void itemQuery() {
		/* It will open the browser on the page indicated in the url */
		/* Home Page */
		driver.get(url);
		driver.findElement(By.id("search_input")).clear();
		driver.findElement(By.id("search_input")).sendKeys(Keys.chord("T-Shirt"));
		driver.findElement(By.id("search_input")).sendKeys(Keys.ENTER);
		
		/* Page that lists items */
		driver.findElement(By.id("det_img_11")).click();
		driver.findElement(By.id("button_cart_11")).click();
		}
}
