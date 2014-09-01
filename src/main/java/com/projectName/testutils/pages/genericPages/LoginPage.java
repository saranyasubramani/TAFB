package com.projectName.testutils.pages.genericPages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.projectName.testutils.genericutility.MyException;
import com.projectName.testutils.seleniumutils.SeleniumWebDriver;

public class LoginPage extends SeleniumWebDriver {

	protected By txtUserName = By.id("frmUsername");
	protected By txtPassword = By.id("frmPassword");

	protected By logoutButton = By.linkText("Logout");

	protected By loginButton = By.id("submitted");
	protected By lnkChangePwd = By.linkText("change password");

	/***
	 * Call to super constructor
	 */
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	/***
	 * Login to the application
	 * 
	 * @throws MyException
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public HomePage login(String userName, String userPassword)
			throws MyException, AWTException, InterruptedException {
		Assert.assertTrue(sendKeys(txtUserName, userName),
				"Could not enter user name");
		Assert.assertTrue(sendKeys(txtPassword, userPassword),
				"Could not enter password");

		Assert.assertTrue(click(loginButton), "Could not click on login button");
		waitForPageToLoad();

		Assert.assertTrue(isElementPresent(lnkChangePwd), "Could not Login");
		waitForPageToLoad();

		return new HomePage(driver);
	}

	
	public void logOut() {
		try {
			if (waitForElement(logoutButton, 5)) {
				click(logoutButton);
				waitForPageToLoad();
			}
		} catch (MyException e) {
		}
	}

}
