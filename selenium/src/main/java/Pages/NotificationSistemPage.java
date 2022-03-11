package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSistemPage extends BasicPage {

	
	public NotificationSistemPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);

	}

	

	public WebElement getLoginMessage() {
		return this.driver.findElement(By.xpath("//*[contains(@class, 'alert--success') OR contains(@class, 'alert--danger')][contains(@style,'display: block')]"));

	}

	public String getLoginMessageText() {
		return this.getLoginMessage().getText();
	}

	public WebElement getSetupMessage() {
		return this.driver.findElement(By.className("content"));

	}

	public String getSetupMsgText() {
		return this.getSetupMessage().getText();

	}

	public WebElement getMealMessage() {
		return this.driver.findElement(By.className("div_error"));

	}

	public WebElement getMealMessageSecond() {
		return this.driver.findElement(By.xpath("//*[@class ='div_error']/ul/li"));

	}

	public String getMealMessageTextFirst() {
		return this.getMealMessage().getText();

	}

	public String getMealMessageTextSecond() {
		return this.getMealMessageSecond().getText();

	}

	// Methods

	public void messageIsGone() {
		waiter.until(ExpectedConditions.attributeToBe(By.xpath("//*[contains(@class, 'system_message')]"), "style","display: none;"));
	}
}
