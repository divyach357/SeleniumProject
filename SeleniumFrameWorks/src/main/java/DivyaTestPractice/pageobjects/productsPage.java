package DivyaTestPractice.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DivyaTestPractice.AbstractComponents.AbstractComponents;

public class productsPage extends AbstractComponents{
	
	WebDriver driver;
	
	public productsPage(WebDriver driver){
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy (css=".mb-3")
	List<WebElement> productsList ;
	
	@FindBy (css=".ng-animated3")
	WebElement spinner ;
	
	By productAtt = By.cssSelector(".mb-3");
	By addtocart  =  By.cssSelector(".card-body button:last-of-type");
	By toastmessage = By.id("toast-container");

	
	public List<WebElement> getProductList() {
		
		WaitForVisibility(productAtt);
		
		return productsList;
	}
	
	public WebElement getProductName(String productName) {
		
		WebElement prod = productsList.stream().filter(product -> 
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
		
	}
	
	public void AddToCart(String productName) {
		
		WebElement prod = getProductName(productName) ;
		prod.findElement(addtocart).click();
		WaitForVisibility(toastmessage);
		WaitForInvisibility(spinner);
	
	}

}
