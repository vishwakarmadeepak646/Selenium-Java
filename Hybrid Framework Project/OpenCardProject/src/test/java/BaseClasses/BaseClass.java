package BaseClasses;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager; // Log4J2
import org.apache.logging.log4j.Logger; //Log4J2


public class BaseClass {

	public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass
	@Parameters({ "os", "browser" })
	public void setUp(String os, String br) throws IOException {
		// reading value from property file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);

		// Logger msg
		logger = LogManager.getLogger(this.getClass()); // Log4J2

		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid browser name...");
			return;
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(p.getProperty("url")); // reading url from properties file
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {

		driver.quit();
	}

	public String randomString() {
		String randomStr = RandomStringUtils.randomAlphanumeric(6);
		return randomStr;
	}

	public String randomNumeric() {
		String randomNum = RandomStringUtils.randomNumeric(10);
		return randomNum;
	}

	public String randomAlphaNumeric() {
		String randomStr = RandomStringUtils.randomAlphanumeric(6);
		String randomNum = RandomStringUtils.randomNumeric(10);
		return (randomStr + "@" + randomNum);
	}
}
