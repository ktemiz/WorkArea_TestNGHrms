package com.hrms.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

public class AddEmployeeTest extends CommonMethods {
	
	/* HRMS Add Employee:
		1. Open chrome browser
		2. Go to “http://166.62.36.207/humanresources/symfony/web/index.php/ auth/login”
		3. Login into the application
		4. Add 5 different Employees and create login credentials by providing:
		● First Name ● Last Name ● Username ● Password
		5. Provide Employee First and Last Name
		6. Verify Employee has been added successfully and take screenshot (you must have 5 different screenshots)
		7. Close the browser
		Specify group for this test case, add it into specific suite and execute from xml file.
	 * 
	 */

	@Test (dataProvider = "userData", groups = { "homework", "addEmp", "regression" })
	public void addEmployeeDataProviding(String firstname, String lastname, String newUsername, String newPassword) {
		addEmp.navigateToAddEmployeePage();
		test.info("navigate to employee add page");
		addEmp.addEmployeeInfo(firstname, lastname);
		test.info("Adding new employee information");
		addEmp.addEmployeeCredentials(newUsername, newPassword);
		test.info("Adding new employee credential information");

		AssertJUnit.assertTrue(detail.textProfilePic.isDisplayed());
		System.out.println("New Employee added susccesfully");
		test.info("Employee added succesfully");
		
		//takeScreenshot();
	}
	
	@DataProvider (name ="userData")
	public Object[][] getData() {

		Object[][] data = {
				{"Kobe_1", "Byrant_1", "KobeBraynt_1", "Hum@nhrm123"}, 
				{"Kobe_2", "Byrant_2", "KobeBraynt_2", "Hum@nhrm123"} ,
				{"Kobe_3", "Byrant_3", "KobeBraynt_3", "Hum@nhrm123"} 
		};
		return data;			
	}
	
	@DataProvider (name = "userDataFromExcel")
	public Object[][] ghetData2() {
		return ExcelUtility.excelIntoArray(Constants.TESTDATA_FILEPATH, "employee");
	
	}


}
