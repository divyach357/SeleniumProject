package DivyaTestPractice.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DivyaTestPractice.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents{
	
	WebDriver driver;
	
	public OrderPage(WebDriver driver){
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	
	@FindBy (css="tr td:nth-child(3)")
	List<WebElement> orderItems ;
	
	@FindBy (css=".totalRow button")
	WebElement checkout ;
	
	By payminfo = By.cssSelector(".payment__info");
	
	public boolean checkOrderHistory(String name) {
		
		boolean match = orderItems.stream().anyMatch(orderItem->orderItem.getText().equalsIgnoreCase(name));
		return match;
		
		
	}
	
	
	
	
	

}
