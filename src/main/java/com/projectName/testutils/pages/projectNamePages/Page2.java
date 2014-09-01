package com.projectName.testutils.pages.projectNamePages;

import org.apache.commons.collections.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.projectName.testutils.genericutility.MyException;
import com.projectName.testutils.seleniumutils.SeleniumWebDriver;

public class Page2 extends SeleniumWebDriver {

	public By lnkElement10 = By.linkText("");
	public By txtElement11 = By.id("");
	public By btnStxtElement12 = By.xpath("");

	/**
	 * Call to super constructor
	 * 
	 * @param driver
	 */
	public Page2(WebDriver driver) {
		super(driver);
	}

	/**
	 * Method to navigate to payment page
	 * 
	 */

	public boolean resusableFunction2(HashedMap dashboardLibObj)
			throws MyException {

		if (isElementPresent(btnStxtElement12)) {
			click(btnStxtElement12);
			return true;
		} else {
			return false;
		}

	}
}
