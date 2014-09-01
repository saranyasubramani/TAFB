package com.projectName.testutils.seleniumutils;

import java.awt.AWTException;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.projectName.testutils.genericutility.Constants;
import com.projectName.testutils.genericutility.Keyboard;
import com.projectName.testutils.genericutility.MyException;
import com.thoughtworks.selenium.Selenium;

public class SeleniumWebDriver {

	/**
	 * Creating the web driver object to be used
	 */
	protected static WebDriver driver;
	WebDriverWait wait;
	Boolean result = true;

	public SeleniumWebDriver(WebDriver driver) {
		SeleniumWebDriver.driver = driver;
	}

	/**
	 * Veriy the presence of a text in the page.
	 * 
	 * @param driver
	 * @param text
	 * @return true/false
	 */
	public boolean isTextPresent(String text) {
		return driver.getPageSource().contains(text);
	}

	/**
	 * Veriy the presence of a element in the page.
	 * 
	 * @param By
	 * @param text
	 * @return true/false
	 */
	public boolean isElementPresent(By element) {
		boolean exists = false;
		try {
			exists = driver.findElement(element).isDisplayed();
		} catch (Exception e) {
		}
		return exists;
	}

	/**
	 * Wait for page to load
	 */
	public void causeMinorTimeDelay() {
		driver.manage().timeouts()
				.implicitlyWait(Constants.DELAY_TIME, TimeUnit.SECONDS);
	}

	/**
	 * Wait for page to load
	 */
	public void causeTimeDelay() {
		try {
			int counter = 0;
			Thread.sleep(2000);
			while (true) {
				String ajaxIsComplete = ((JavascriptExecutor) driver)
						.executeScript("return Ajax.activeRequestCount")
						.toString();
				if (Integer.parseInt(ajaxIsComplete) == 0)
					break;
				if (counter == 100)
					break;
				Thread.sleep(100);
			}
		} catch (Exception e) {

		}

	}

	/**
	 * The screen shot is captured
	 * 
	 * @param driver
	 * @return
	 */
	public static File takeScreenshot(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	}

	public boolean waitForElement(final By ajaxElementName, int timeOutValue)
			throws MyException {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, timeOutValue);
		try {
			ExpectedCondition<Boolean> e = new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					return driver.findElement(ajaxElementName).isDisplayed();

				}
			};
			wait.until(e);
			return true;
		} catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			throw new MyException("The Element '" + ajaxElementName
					+ "' did not appear  within " + timeOutValue + " ms."
					+ timeOutValue * 1000);

		}

	}

	// Wait for Element to Load
	public void waitForElementToLoad(Selenium selenium, String elementId)
			throws InterruptedException {
		int i = 0;
		while (!selenium.isElementPresent(elementId)) {
			i++;
			Thread.sleep(3000);
			if (i == 9) {
				// Assert.fail("Time out :-CounldNotFind the Element With ID  : "+elementId
				// );
				break;
			}
		}
	}

	public boolean sendKeys(By elementLocator, String value) {
		try {
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
			driver.findElement(elementLocator).clear();
			driver.findElement(elementLocator).sendKeys(value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Performs mouse hover action with the help of Java script executor
	 * 
	 * @param driver
	 * @param elementName
	 */
	public static void mouseHoverUsingElementProperties(String elementName, String by) {
		String locType = "";
		if (by.equals("ID"))
			locType = "getElementById";
		else if (by.equalsIgnoreCase("name"))
			locType = "getElementsByName";
		String script = "var elem = document." + locType + "('" + elementName + "')[0];"
				+ "if( document.createEvent) {" + "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initEvent( 'mouseover', true, false );" + "elem.dispatchEvent(evObj);"
				+ "} else if( document.createEventObject ) {" + "elem.fireEvent('onmouseover');" + "}";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(script);
	}
	
	public boolean click(final By ajaxElementName) {
		try {
			waitForElement(ajaxElementName, Constants.AVG_WAIT_TIME_FOR_ELEMENT);
			if (driver.findElement(ajaxElementName).isDisplayed()
					&& driver.findElement(ajaxElementName).isEnabled()) {
				driver.findElement(ajaxElementName).click();
			} else {
				result = false;
			}

		} catch (MyException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	/**
	 * isChecked function to verify if the AJAX based Checkbox is checked
	 * 
	 * @param selenium
	 * @param ajaxCheckboxName
	 *            (Name of the ajax Checkbox)
	 * @throws MyException
	 * 
	 * @since March 04, 2013
	 */
	public boolean isChecked(final By ajaxCheckboxName) throws MyException {

		if (waitForElement(ajaxCheckboxName,
				Constants.AVG_WAIT_TIME_FOR_ELEMENT)) {
			driver.findElement(ajaxCheckboxName).isSelected();
			boolean checkBoxStatus = driver.findElement(ajaxCheckboxName)
					.isSelected();
			if (checkBoxStatus) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean type(final By ajaxElementName, String sucessMessage,
			String failureMessage, int timeOutValue) {
		try {
			waitForElement(ajaxElementName, timeOutValue);
			if (driver.findElement(ajaxElementName).isDisplayed()
					&& driver.findElement(ajaxElementName).isEnabled()) {
				driver.findElement(ajaxElementName).click();
			} else {
				result = false;
			}

		} catch (MyException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	public void waitForPageToLoad() {
		try {
			int counter = 0;
			Thread.sleep(1000);
			while (true) {
				String ajaxIsComplete = ((JavascriptExecutor) driver)
						.executeScript(" return Ajax.activeRequestCount")
						.toString();
				if (Integer.parseInt(ajaxIsComplete) == 0)
					break;
				if (counter == 20)
					break;
				Thread.sleep(100);
				counter++;
			}
		} catch (Exception e) {

		}

	}
	

	// Mouse over Method
	public void mouseOver(WebElement element) {
		String code = "var fireOnThis = arguments[0];"
				+ "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initEvent( 'mouseover', true, true );"
				+ "fireOnThis.dispatchEvent(evObj);";
		((JavascriptExecutor) driver).executeScript(code, element);
	}

	public boolean select(By listName, String valueForSelection) {
		valueForSelection = valueForSelection != null ? valueForSelection
				.trim() : "";
		try {
			waitForElement(listName, Constants.AVG_WAIT_TIME_FOR_ELEMENT);
			if (driver.findElement(listName).isDisplayed()) {
				Select elSelect = new Select(driver.findElement(listName));
				elSelect.selectByVisibleText(valueForSelection);
				return true;
			} else {
				return false;
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			
			return false;
		} catch (MyException e) {
			e.printStackTrace();
			return false;
		}

	}

	public String getText(By elementName, int wait) throws MyException {

		try {
			if (waitForElement(elementName, wait)) {
				return driver.findElement(elementName).getText();
			}
		} catch (MyException e) {
			return "";
		}
		return "";
	}

	public void fileUpload(By FileUploader, String filePath)
			throws InterruptedException, AWTException {
		File file = null;
		file = new File(filePath);
		WebElement browseButton = driver.findElement(FileUploader);
		browseButton.click();
		causeTimeDelay();
		causeMinorTimeDelay();
		Keyboard robot = new Keyboard();
		robot.type(file.getAbsolutePath());
		causeTimeDelay();
		causeMinorTimeDelay();
		robot.pressEnter();
	}

	/**
	 * 
	 * @param driver
	 *            - Web driver instance
	 * @param element
	 *            - Element to click on
	 */
	public static void clickUsingJS(WebDriver driver, WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public String getValue(By elementName) throws MyException {

		try {
			if (waitForElement(elementName, Constants.AVG_WAIT_TIME_FOR_ELEMENT)) {
				return driver.findElement(elementName).getAttribute("value");
			} else {
				return "";
			}
		} catch (MyException e) {
			throw new MyException(
					"Could not get The Value From the Field; Either  ");
		}
	}

	public String getSelectedItem(By ComboBox) {
		String actualText = "";
		try {
			// Get the selected value from specified combo box
			Select selectedValue = new Select(driver.findElement(ComboBox));
			actualText = selectedValue.getFirstSelectedOption().getText();
		} catch (Exception e) {
			return actualText;
		}
		return actualText;
	}

	public ArrayList<String> getAllOptions(String comboBox) {
		ArrayList<String> values = new ArrayList<String>();
		int valueCount = driver.findElements(By.xpath(comboBox + "/option"))
				.size();
		for (int i = 1; i <= valueCount; i++) {
			values.add(driver.findElement(
					By.xpath(comboBox + "/option[" + i + "]")).getAttribute(
					"value"));
		}
		return values;
	}

	public ArrayList<String> getOptions(String comboBox) {
		ArrayList<String> values = new ArrayList<String>();
		int valueCount = driver.findElements(By.xpath(comboBox + "/option"))
				.size();
		for (int i = 1; i <= valueCount; i++) {
			values.add(driver.findElement(
					By.xpath(comboBox + "/option[" + i + "]")).getText());
		}
		return values;
	}
}
