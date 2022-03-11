package Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfilTest extends BasicTest{
	
	@Test

	public void editProfileTest() throws InterruptedException {

		
		driver.get(loginFormUrl);
		locationPopupPage.closeLocationDialog();
		loginPage.login(email, password);
		sa.assertTrue(notificationSistemPage.getLoginMessageText().contains("Login Successfull"),
				"Error, login unsuccessful ");

		
		driver.get(profilePageUrl);
		profilPage.updateUser("Zarko", "Popara", "Topolska 18", "06000001", "18000", "United States",
				"Arizona", "Pine");
		Thread.sleep(2000);
		sa.assertTrue(notificationSistemPage.getSetupMsgText().contains("Setup Successful"),
				"Error, setup unsuccessful ");

		// Logout
		authorPage.userLogout();
		sa.assertTrue(notificationSistemPage.getLoginMessageText().contains("Logout Successfull"),
				"Error, logout unsuccessful ");

	}

	@Test

	public void changeProfileImage() throws AWTException, InterruptedException {

		// Login
		driver.get(loginFormUrl);
		locationPopupPage.closeLocationDialog();
		loginPage.login(email, password);
		sa.assertTrue(notificationSistemPage.getLoginMessageText().contains("Login Successfull"),
				"Error, login unsuccessful ");

		// Upload photo
		driver.get(profilePageUrl);
		profilPage.uploadPhoto();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		sa.assertTrue(notificationSistemPage.getSetupMsgText().contains("Profile Image Uploaded Successfully"),
				"Error, Profile image in not uploaded ");
		notificationSistemPage.messageIsGone();

		// Remove photo
		profilPage.removePhoto();
		Thread.sleep(2000);
		sa.assertTrue(notificationSistemPage.getSetupMsgText().contains("Profile Image Deleted Successfully"),
				"Error, Profile image is not deleted ");
		notificationSistemPage.messageIsGone();

		// Logout
		authorPage.userLogout();
		sa.assertTrue(notificationSistemPage.getLoginMessageText().contains("Logout Successfull"),
				"Error, logout unsuccessful ");

	}
}
