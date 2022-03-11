package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorPage extends BasicPage {
	
	

		public AuthorPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
			super(driver, waiter, js);

		}

		

		public WebElement getName() {
			return this.driver.findElement(By.xpath("//*[contains(@class,'after-arrow')]"));

		}

		public WebElement getMyAccount() {
			return this.driver.findElement(By.xpath("//*[contains(text(),'My Account')]"));

		}

		public WebElement getLogout() {
			return this.driver.findElement(By.xpath("//*[contains(text(),'Logout')]"));

		}

		// Methods

		public void userLogout() {

			this.getName().click();
			this.getLogout().click();
		}

	
}
