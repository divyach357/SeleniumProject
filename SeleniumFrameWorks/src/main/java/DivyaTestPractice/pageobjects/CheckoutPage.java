package DivyaTestPractice.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import DivyaTestPractice.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents{
	
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	
	}
	
	@FindBy (css="[placeholder = 'Select Country']")
	WebElement typecountry ;
	
	@FindBy (css=".ta-results button:nth-of-type(2)")
	WebElement clickCountry;
	
	@FindBy (css=".action__submit")
	WebElement submitButton;
	
	
	
	By countryResults = By.cssSelector(".ta-results");
	
	
	
	public void SelectCountry(String countryname) {
		Actions keys = new Actions(driver);
		keys.sendKeys(typecountry, countryname).build().perform();
		WaitForVisibility(countryResults);
		clickCountry.click();
		
	}
	
	public ConfirmationPage clickOnSubmit()
	{
		submitButton.click();
		return new ConfirmationPage(driver);
	}
	
	
	
	
	
	

}
