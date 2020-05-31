package com.hrms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class AddEmployeePage extends CommonMethods {
	
	public void navigateToAddEmployeePage() {
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		wait(2);
		click(dashboard.headerPIM);
		wait(2);
		click(dashboard.headerAddEmp);
		wait(1);	
	}
	
	public void addEmployeeInfo(String firstname, String lastname) {
		wait(2);
		//define name, lastname
		sendText(firstName,firstname);
		sendText(lastName, lastname);
	}
	
	public void addEmployeeCredentials(String newUsername, String newPassword) {
		addEmp.checkBoxLogin();
		
		//define username and password
		sendText(createUserName, newUsername);
		sendText(createPassword, newPassword);
		sendText(ConfirmCreatePassword,newPassword);
		//select "enabled" option
		selectDdValue(statusUser, "Enabled");
		click(addEmp.btnSave);
		wait(2);
	}
	
	@FindBy(xpath = "//label[text()='Full Name']")
	public WebElement labelFullName;
	
	@FindBy(xpath = "//label[text()='Employee Id']")
	public WebElement labelEmpId;
	
	@FindBy(xpath = "//label[text()='Photograph']")
	public WebElement labelPhoto;
	
	@FindBy(xpath = "//label[text()='Create Login Details']")
	public WebElement labelCreateLoginDetail;
	
	@FindBy(id = "firstName")
	public WebElement firstName;
	
//	@FindBy(xpath = "//input[@id='firstName']/following-sibling::span")
//	public WebElement errorMsgFirstName;
	
	public String errorMsgFirstName () {
		String errorMsgFirstName = driver.findElement(By.xpath("//input[@id='firstName']/following-sibling::span")).getText();
		return errorMsgFirstName;
	}
	
	public String errorMsgLastName () {
		String errorMsgLastName = driver.findElement(By.xpath("//input[@id='lastName']/following-sibling::span")).getText();
		return errorMsgLastName;
	}
	
//	@FindBy(xpath = "//input[@id='lastName']/following-sibling::span")
//	public WebElement errorMsgLastName;
	
	
	@FindBy(id = "middleName")
	public WebElement middleName;
	
	@FindBy(id = "lastName")
	public WebElement lastName;
	
	@FindBy(id = "photofile")
	public WebElement btnChoosePhoto;
	
	@FindBy(css = "input#chkLogin")
	public WebElement checkBoxLogin;
	
	public void checkBoxLogin() {
		if(!checkBoxLogin.isSelected()) {
			click(checkBoxLogin);
		}
	}
	
	@FindBy(id = "user_name")
	public WebElement createUserName;
	
	@FindBy(id = "user_password")
	public WebElement createPassword;
	
	@FindBy(id = "re_password")
	public WebElement ConfirmCreatePassword;
	
	@FindBy(id = "status")
	public WebElement statusUser;
	
	@FindBy(id = "btnSave")
	public WebElement btnSave;
	
	
	
	
	public AddEmployeePage () {
		PageFactory.initElements(BaseClass.driver, this);
	}


}
