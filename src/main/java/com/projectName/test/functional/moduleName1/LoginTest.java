package com.projectName.test.functional.moduleName1;

import org.apache.commons.collections.map.HashedMap;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.projectName.testutils.baseclass.TestBaseClass;
import com.projectName.testutils.pages.genericPages.LoginPage;
import com.projectName.testutils.testdatareader.ExcelReader;

public class LoginTest extends TestBaseClass {

	/**
	 * Test to verify login
	 */

	@Test
	public void loginTest() {
		try {

			// ------------------------------------------------------------------//
			// Step-1: Get the test data //
			// ------------------------------------------------------------------//
			HashedMap testData = ExcelReader.getTestDataByTestCaseId(
					"TC_EBS_001", LoginTest.class.getSimpleName());
			log.info(testData.get("TC_ID").toString() + " - ");

			// ------------------------------------------------------------------//
			// Step-2: Load the application //
			// ------------------------------------------------------------------//
			
			driver = loadURL();
			homePage = loginUser1();

			LoginPage abstractObj = homePage.navigateToLoginPage();
			log.info("Successfully navigated to Preferences Page.");

			// ------------------------------------------------------------------//
			// Step-3: Verify login //
			// ------------------------------------------------------------------//
			Assert.assertTrue(abstractObj.isTextPresent("Login Successful"),
					"Login Failed");

		} catch (Exception e) {
			log.info("The following exception has occured : " + e.getMessage());
			assert false;
		}
	}
}
