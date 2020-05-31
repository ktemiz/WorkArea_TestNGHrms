package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class ViewPersonnelDetails {
	
	@FindBy(id = "personal_txtEmpFirstName")
	public WebElement firstName;
	
	@FindBy(id = "id=\"personal_txtEmpMiddleName\"")
	public WebElement middleName;
	
	
	@FindBy(id = "personal_txtEmpLastName")
	public WebElement lastName;
	
	@FindBy(css = "div#profile-pic h1")
	public WebElement textProfilePic;
	
	public ViewPersonnelDetails () {
		PageFactory.initElements(BaseClass.driver, this);
	}

}
