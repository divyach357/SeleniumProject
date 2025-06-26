package DivyaTestPractice.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DivyaTestPractice.AbstractComponents.AbstractComponents;

public class Cartpage extends AbstractComponents{
	
	WebDriver driver;
	
	public Cartpage(WebDriver driver){
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	
	@FindBy (css=".cartSection h3")
	List<WebElement> cartItems ;
	
	@FindBy (css=".totalRow button")
	WebElement checkout ;
	
	By payminfo = By.cssSelector(".payment__info");
	
	public boolean CartList(String name) {
		
		boolean match = cartItems.stream().anyMatch(cartItem->cartItem.getText().equalsIgnoreCase(name));
		return match;
		
		
	}
	
	public CheckoutPage checkOutClick() {
		
		checkout.click();
		WaitForVisibility(payminfo);		
	    return new CheckoutPage(driver);
		
	}
	
	
	
	

}
