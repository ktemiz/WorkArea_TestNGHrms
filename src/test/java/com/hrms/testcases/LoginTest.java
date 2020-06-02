package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class LoginTest extends CommonMethods {

	@Test (groups = "smoke")
	public void validAdminLogin() {
	//In login page, enter valid username and psw
		test.info("Entering valid admin credentilas");
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);

		//check "welcome Admin" text to confirm login succesfully
		String expectedUser = "Welcome Admin";
		String actualUser = dashboard.welcome.getText();
		Assert.assertEquals(actualUser, expectedUser, "Admin is NOT Logged in");
		Assert.assertTrue(actualUser.contains(ConfigsReader.getProperty("username")));
		test.info("Login is successful and get welcome admin");
	}

	@Test (groups = "regression")
	public void invalidPasswordLogin() {
		//use invalid psw and confirm that login is not succesfull
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, "uiuguig");
		click(login.loginBtn);

		String expected = "Invalid credentials";
		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message text is not matched");
		test.info("Login is not succesfull and Error message is created");
	}

	@Test(groups = "regression")
	public void emptyUsernameLogin() {
		
		//leave empty username text box and check error message
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);

		String expected = "Username cannot be empty";

		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message text is not matched");
		test.info("Login is not succesfull and error message is created");
	}

}
