package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPopupPage extends BasicPage{

	public LocationPopupPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);

	}

	

	public WebElement getLocation() {
		return this.driver.findElement(By.className("location-selector"));

	}

	public WebElement getCloseElement() {
		return this.driver.findElement(By.xpath("//*[contains(@class,'close-btn-white')]"));
	}

	public WebElement getKeyword() {
		return this.driver.findElement(By.id("locality_keyword"));
	}

	public WebElement getLocationItem(String locationName) {
		return this.driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));

	}

	public WebElement getLocationInput() {
		return this.driver.findElement(By.id("location_id"));
	}

	public WebElement submitBtn() {
		return this.driver.findElement(By.name("btn_submit"));
	}

	// Methods

	public void openLocationDialog() {
		this.getLocation().click();

	}

	public void closeLocationDialog() {
		this.getCloseElement().click();

	}

	public void setLocation(String locationName) {

		this.getKeyword().click();
		String value = this.getLocationItem(locationName).getAttribute("data-value");
		js.executeScript("arguments[0].value = arguments[1];", this.getLocationInput(), value);
		js.executeScript("arguments[0].click();", this.submitBtn());

	}
}
