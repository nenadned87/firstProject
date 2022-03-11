package Test;

import java.awt.AWTException;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import Pages.AuthorPage;
import Pages.CartSummaryPage;
import Pages.LocationPopupPage;
import Pages.LoginPage;
import Pages.MealPage;
import Pages.NotificationSistemPage;
import Pages.ProfilPage;

public class BasicTest {

	
	protected WebDriver driver;
	protected JavascriptExecutor js;
	protected WebDriverWait waiter;
	protected SoftAssert sa;
	

	protected LocationPopupPage locationPopupPage;
	protected LoginPage loginPage;
	protected NotificationSistemPage notificationSistemPage;
	protected ProfilPage profilPage;
	protected AuthorPage authorPage;
	protected MealPage mealPage;
	protected CartSummaryPage cartSummaryPage;

	
	protected String baseUrl = "http://demo.yo-meals.com";
	protected String loginFormUrl = baseUrl + "/guest-user/login-form";
	protected String profilePageUrl = baseUrl + "/member/profile";
	protected String mealPageUrlLobster = baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo";
	protected String mealsPageUrl = baseUrl + "/meals";

	
	protected String email = "customer@dummyid.com";
	protected String password = "12345678a";

	@BeforeMethod

	public void beforeMethod() throws AWTException {

		
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		waiter = new WebDriverWait(driver, 10);
		SoftAssert sa = new SoftAssert();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		
		locationPopupPage = new LocationPopupPage(driver, waiter, js);
		loginPage = new LoginPage(driver, waiter, js);
		notificationSistemPage = new NotificationSistemPage(driver, waiter, js);
		profilPage = new ProfilPage(driver, waiter, js);
		authorPage = new AuthorPage(driver, waiter, js);
		mealPage = new MealPage(driver, waiter, js);
		cartSummaryPage = new CartSummaryPage(driver, waiter, js);

	}

	@AfterMethod

	public void afterMethod(ITestResult result) {

		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				FileHandler.copy(source, new File("./Screenshots/" + ".png"));
				System.out.println("Screenshot taken");

			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		}
		driver.quit();
	}



}
