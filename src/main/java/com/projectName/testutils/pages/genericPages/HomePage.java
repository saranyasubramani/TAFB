package com.projectName.testutils.pages.genericPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectName.testutils.genericutility.MyException;
import com.projectName.testutils.pages.projectNamePages.Page1;
import com.projectName.testutils.pages.projectNamePages.Page2;
import com.projectName.testutils.seleniumutils.SeleniumWebDriver;


public class HomePage extends SeleniumWebDriver {

	/***
	 * Call to super constructor
	 */
	public HomePage(WebDriver driver) {
		super(driver);
	}

	public String getLoggedInUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void logOut() {
		// TODO Auto-generated method stub

	}

	

	public LoginPage navigateToLoginPage() throws MyException {
		LoginPage createRequestPage = PageFactory.initElements(driver,
				LoginPage.class);
		return createRequestPage;

	}

	public Page1 navigateToPage1() throws MyException {
		Page1 createRequestPage = PageFactory.initElements(driver,
				Page1.class);
		return createRequestPage;

	}



	public Page2 navigateToPage2() throws MyException {
		Page2 createRequestPage = PageFactory.initElements(driver,
				Page2.class);
		return createRequestPage;

	}

}
