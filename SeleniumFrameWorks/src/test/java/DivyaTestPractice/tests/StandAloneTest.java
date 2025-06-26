package DivyaTestPractice.tests;

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

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		String name = "ZARA COAT 3";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("divyabhanunaidu@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("DB@testing1");
		driver.findElement(By.id("login")).click();
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod = products.stream().filter(product -> 
		product.findElement(By.cssSelector("b")).getText().equals(name)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animated")));

		driver.findElement(By.cssSelector("[routerlink *= 'cart']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart")));

		
		List<WebElement> cartItems = driver.findElements(By.cssSelector(".cartSelection h3"));
		boolean match = cartItems.stream().anyMatch(cartItem->cartItem.getText().equalsIgnoreCase(name));
		Assert.assertTrue(true);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".payment__info")));
		
		Actions keys = new Actions(driver);
		keys.sendKeys(driver.findElement(By.cssSelector("[placeholder = 'Select Country']")), "India").build().perform();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.cssSelector(".ta-results button:nth-of-type(2)")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		String endTitle = driver.findElement(By.cssSelector(".hero-primary")).getText();

		Assert.assertTrue(endTitle.equalsIgnoreCase("Thank you for the order"));
	


	}

}
