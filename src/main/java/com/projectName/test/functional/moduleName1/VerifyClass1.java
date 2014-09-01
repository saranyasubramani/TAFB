package com.projectName.test.functional.moduleName1;

import org.apache.commons.collections.map.HashedMap;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.projectName.testutils.baseclass.TestBaseClass;
import com.projectName.testutils.pages.genericPages.HomePage;
import com.projectName.testutils.pages.projectNamePages.Page1;
import com.projectName.testutils.pages.projectNamePages.Page2;

import com.projectName.testutils.testdatareader.ExcelReader;

public class VerifyClass1 extends TestBaseClass {

	/**
	 * Test to verify card transaction
	 */

	@Test
	public void verifyCardTransaction() {

		try {

			// ------------------------------------------------------------------//
			// Step-1: Get the test data //
			// ------------------------------------------------------------------//
			HashedMap testData = ExcelReader.getTestDataByTestCaseId(
					"TC_CT_001", VerifyClass1.class.getSimpleName());
			log.info(testData.get("TC_ID").toString() + " - ");

			// ------------------------------------------------------------------//
			// Step-2: Load Merchant site //
			// ------------------------------------------------------------------//
			driver = loadURL();

			// ------------------------------------------------------------------//
			// Step-3: Load page elements //
			// ------------------------------------------------------------------//
			homePage = PageFactory.initElements(driver, HomePage.class);
			Page1 abstractObj1 = homePage.navigateToPage1();
			log.info("Successfully loaded merchant site elements");

			Page2 abstractObj2 = homePage.navigateToPage2();
			log.info("Successfully loaded Secure Payment Page elements");

			// ------------------------------------------------------------------//
			// Step-4: Submit merchant details //
			// ------------------------------------------------------------------//

			Assert.assertTrue(
					abstractObj1.reusableFunction1(testData),
					"Submission Failed");
			Assert.assertTrue(
					abstractObj2.resusableFunction2(testData),
					"Submission Failed");
			
		} catch (Exception e) {
			log.info("The following exception has occured : " + e.getMessage());
			assert false;
		}
	}
}
