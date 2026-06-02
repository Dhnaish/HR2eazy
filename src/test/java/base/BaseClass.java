package base;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

import utilities.Utilities;

public class BaseClass {
	public WebDriver driver;

	@BeforeMethod
	public void setUp() throws Exception {
		System.out.println("Before Method");
	    // Setup ChromeDriver
	    WebDriverManager.chromedriver().setup();

	    // Chrome Options for Headless Mode
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--headless=new"); 
	    options.addArguments("--window-size=1920,1080");
	    options.addArguments("--disable-gpu");

	    // Launch Browser in Headless Mode
	    driver = new ChromeDriver(options);

	    // Implicit Wait
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	    Properties property = Utilities.getProperty();
	    String url = property.getProperty("clientUrl");
	    driver.get(url);
	}
	
	@AfterMethod
	public void tearDown() {

		System.out.println("End Time : " + LocalDateTime.now());
		    if(driver != null) {
		        driver.quit();
		    }
		}

	}


