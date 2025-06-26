package DivyaTestPractice.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import DivyaTestPractice.pageobjects.Cartpage;
import DivyaTestPractice.pageobjects.CheckoutPage;
import DivyaTestPractice.pageobjects.ConfirmationPage;
import DivyaTestPractice.pageobjects.LoginPage;
import DivyaTestPractice.pageobjects.OrderPage;
import DivyaTestPractice.pageobjects.productsPage;
import DivyaTestPractice.testComponents.BaseTest;

public class OrderE2ETest extends BaseTest{

	String name = "ZARA COAT 3";	
	@Test
	
	public void submitOrder () throws IOException
	{
		// TODO Auto-generated method stub
			
		productsPage productpage = loginpage.LoginApp("divyabhanunaidu@gmail.com", "DB@testing1");

		List<WebElement> productsList = productpage.getProductList();
		productpage.AddToCart(name);
		
		Cartpage cartpage = productpage.CartClick();
		boolean match = cartpage.CartList(name);
		Assert.assertTrue(match);
		
						
		CheckoutPage checkoutpage = cartpage.checkOutClick();;
		checkoutpage.SelectCountry("india");
		ConfirmationPage confirmationpage = checkoutpage.clickOnSubmit();
		String endTitle = confirmationpage.ConfirmationNote();
		
		Assert.assertTrue(endTitle.equalsIgnoreCase("Thankyou for the order."));
		

	}
	
	//to verify zara coat 3 is displayed in order history
	@Test(dependsOnMethods = {"submitOrder"})
	public void checkOrderHistory() {
		productsPage productpage = loginpage.LoginApp("divya@gmail.com", "DB@testing1");
		OrderPage orderpage = productpage.GoToOrder();
		Assert.assertTrue(orderpage.checkOrderHistory(name));
		
	}

}
