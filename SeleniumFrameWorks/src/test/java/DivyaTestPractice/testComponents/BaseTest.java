package DivyaTestPractice.testComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import DivyaTestPractice.pageobjects.LoginPage;

public class BaseTest {
	
	WebDriver driver;
	public LoginPage loginpage;
	
	public WebDriver initializeDriver() throws IOException
	{
		
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//DivyaTestPractice//GlobalComponents//GlobalComponents.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome") )
		{
			driver = new ChromeDriver();

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
	}
	
	@BeforeMethod
	public LoginPage launchApp() throws IOException {
		
		driver = initializeDriver();		
		loginpage = new LoginPage (driver);
		loginpage.goTo();
		return loginpage;
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
