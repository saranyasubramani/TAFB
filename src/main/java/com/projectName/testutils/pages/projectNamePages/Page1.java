package com.projectName.testutils.pages.projectNamePages;

import org.apache.commons.collections.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.projectName.testutils.genericutility.MyException;
import com.projectName.testutils.seleniumutils.SeleniumWebDriver;

public class Page1 extends SeleniumWebDriver {

	public By lstElement1 = By.name("");
	public By txtElement2 = By.name("");
	public By txtElement3 = By.name("");
	public By btnElement4 = By.name("submitted");

	

	/**
	 * Call to super constructor
	 * 
	 * @param driver
	 */
	public Page1(WebDriver driver) {
		super(driver);
	}

	/**
	 * Method to enter details in merchant site
	 * 
	 */

	public boolean reusableFunction1(HashedMap dashboardLibObj)
			throws MyException {

		select(lstElement1, dashboardLibObj.get("option1").toString());
		sendKeys(txtElement2, dashboardLibObj.get("RefNo").toString());
		
		click(btnElement4);
		waitForPageToLoad();
		if (isElementPresent(txtElement3)) {
			return true;
		} else {
			return false;
		}

	}

}