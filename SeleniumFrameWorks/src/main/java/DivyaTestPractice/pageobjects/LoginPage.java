package DivyaTestPractice.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DivyaTestPractice.AbstractComponents.AbstractComponents;

public class LoginPage extends AbstractComponents{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy (id="userEmail")
	WebElement userMail ;
	
	@FindBy (id="userPassword")
	WebElement password ;
	
	@FindBy (id="login")
	WebElement logInButton ;
	
	public productsPage LoginApp(String idName , String pswd)
	{
		userMail.sendKeys(idName);
		password.sendKeys(pswd);
		logInButton.click();
		productsPage productpage = new productsPage(driver);
		return productpage;
		
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");

	}
	

}
