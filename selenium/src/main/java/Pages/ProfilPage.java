package Pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilPage extends BasicPage {

	public ProfilPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);

	}

	

	public WebElement getFirstName() {
		return this.driver.findElement(By.name("user_first_name"));
	}

	public WebElement getLastName() {
		return this.driver.findElement(By.name("user_last_name"));
	}

	public WebElement getEmail() {
		return this.driver.findElement(By.name("user_email"));

	}

	public WebElement getAddress() {
		return this.driver.findElement(By.name("user_address"));

	}

	public WebElement getPhoneNumber() {
		return this.driver.findElement(By.name("user_phone"));

	}

	public WebElement getZipCode() {
		return this.driver.findElement(By.name("user_zip"));

	}

	public Select getCountry() {
		return new Select(driver.findElement(By.id("user_country_id")));

	}

	public Select getState() {
		return new Select(driver.findElement(By.id("user_state_id")));

	}

	public Select getCity() {
		return new Select(driver.findElement(By.id("user_city")));

	}

	public WebElement getRemovePhotoBtn() {
		return this.driver.findElement(By.xpath("//*[@title = 'Remove']"));

	}

	public WebElement getUploadPhotoBtn() {
		return this.driver.findElement(By.xpath("//*[@title = 'Uplaod']"));

	}

	public WebElement getSubmitBtn() {
		return this.driver.findElement(By.name("btn_submit"));

	}

	// Methods

	public void uploadPhoto() {

		File image = new File("img/pic.jpg");
		String imgPath = image.getAbsolutePath();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.className("avatar"))).perform();
		getUploadPhotoBtn().click();
		driver.findElement(By.name("file")).sendKeys(imgPath);

	}

	public void removePhoto() {
		this.getRemovePhotoBtn().click();

	}

	public void updateUser(String firstName, String lastName, String address, String phoneNum, String zipCode,
			String contry, String state, String city) {

		this.getFirstName().clear();
		this.getFirstName().sendKeys(firstName);
		this.getLastName().clear();
		this.getLastName().sendKeys(lastName);
		this.getAddress().clear();
		this.getAddress().sendKeys(address);
		this.getPhoneNumber().clear();
		this.getPhoneNumber().sendKeys(phoneNum);
		this.getZipCode().clear();
		this.getZipCode().sendKeys(zipCode);
		// Select
		this.getCountry().selectByVisibleText(contry);
		this.getState().selectByVisibleText(state);
		this.getCity().selectByVisibleText(city);
		// Click
		this.getSubmitBtn().click();

	}

	
}
