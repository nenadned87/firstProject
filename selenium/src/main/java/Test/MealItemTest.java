package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class MealItemTest extends BasicTest{

	@Test

	public void addMealToCart() throws InterruptedException {

		// Add to cart 
		driver.get(mealPageUrlLobster);
		locationPopupPage.closeLocationDialog();
		mealPage.addToCart("2");
		sa.assertTrue(notificationSistemPage.getMealMessageTextFirst().contains("The Following Errors Occurred:"),
				"Error, Error message does not appear");
		sa.assertTrue(notificationSistemPage.getMealMessageTextSecond().contains("Please Select Location"),
				"Error, 'Please select location'message does not appear");
		notificationSistemPage.messageIsGone();

		// Set location
		locationPopupPage.getLocation().click();
		locationPopupPage.setLocation("City Center - Albany");
		Thread.sleep(2000);

		// Add to cart
		mealPage.addToCart("2");
		Thread.sleep(3000);
		
		sa.assertTrue(notificationSistemPage.getSetupMsgText().contains("Meal Added To Cart"),
				"Error, meal is not added to cart");
		Thread.sleep(3000);

	}

	@Test

	public void AddMealToFavorite() throws InterruptedException {

		// Add to favorites without login
		driver.get(mealPageUrlLobster);
		locationPopupPage.closeLocationDialog();
		mealPage.addToFavourites();
		Thread.sleep(2000);
		sa.assertTrue(notificationSistemPage.getSetupMsgText().contains("Please login first!"),
				"Error, 'please login first' message does not appear");

		// Login
		driver.get(loginFormUrl);
		loginPage.login(email, password);

		// Add to favorites
		driver.get(mealPageUrlLobster);
		mealPage.addToFavourites();
		sa.assertTrue(
				notificationSistemPage.getSetupMsgText().contains("Product has been added to your favorites"),
				"Error, product has not been added");

	}

	@Test

	public void clearCart() throws IOException, InterruptedException {

		
		driver.get(mealsPageUrl);
		locationPopupPage.setLocation("City Center - Albany");

		// Input meal
		File file = new File("data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet mealsSheet = wb.getSheet("Meals");

		for (int i = 1; i <= mealsSheet.getLastRowNum(); i++) {
			String url = mealsSheet.getRow(i).getCell(0).getStringCellValue();
			Thread.sleep(2000);
			driver.get(url);
			Thread.sleep(2000);
			mealPage.addToCart("3");

			Thread.sleep(2000);
			sa.assertTrue(notificationSistemPage.getSetupMsgText().contains("Meal Added To Cart"),
					"Error, meal is not added to cart");
		}

		// Clear 
		Thread.sleep(2000);
		cartSummaryPage.clearAll();
		Thread.sleep(3000);
		sa.assertTrue(
				notificationSistemPage.getSetupMsgText().contains("All meals removed from Cart successfully"),
				"Error, meals are not removed from the cart");
		sa.assertAll();
		

	}
	
}
