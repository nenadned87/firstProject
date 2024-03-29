package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage {

	
	public MealPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);

	}

	

	public WebElement getAddToCartBtn() {
		return this.driver.findElement(By.xpath("//*[contains(@class,'js-proceedtoAddInCart')]"));

	}

	public WebElement getAddToExtraTopingsBtn() {
		return this.driver.findElement(By.xpath("//*[contains(@class,'js-addons-trigger')]"));

	}

	public WebElement getAddToFavouriteBtn() {
		return this.driver.findElement(By.xpath("//*[contains(@class,'favourite')]"));

	}

	public WebElement getProductQuantity() {
		return this.driver.findElement(By.xpath("//*[@name='product_qty']"));

	}

	// Methods

	public void addToFavourites() {
		this.getAddToFavouriteBtn().click();
	}

	public void addToCart(String value) {

		this.getProductQuantity().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		this.getProductQuantity().sendKeys(value);
		this.getAddToCartBtn().click();

	}
}
