package DivyaTestPractice.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DivyaTestPractice.pageobjects.Cartpage;
import DivyaTestPractice.pageobjects.OrderPage;

public class AbstractComponents {
	
	WebDriver driver ;
	
	public AbstractComponents(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css = "[routerlink *= 'cart']")
	WebElement cartIcon ;
	
	@FindBy (css = "[routerlink *= 'myorders']")
	WebElement ordericon ;
	
	By cartList = By.cssSelector(".cart");

	public void WaitForVisibility(By att) 
	{
		
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(att));
		
	}
	public void WaitForInvisibility(WebElement Elem) 
	{
		
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.invisibilityOf(Elem));
		
	}
	
	public Cartpage CartClick()
	
	{
		cartIcon.click();
		WaitForVisibility(cartList);
		Cartpage cartpage = new Cartpage(driver);
		return cartpage;
	}
	public OrderPage GoToOrder()
	
	{
		ordericon.click();
		OrderPage orderpage = new OrderPage(driver);
		return orderpage;
	}
	
	

}
