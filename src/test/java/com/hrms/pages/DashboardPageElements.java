package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class DashboardPageElements {
	
	@FindBy (xpath = "//a[@id='menu_pim_viewPimModule']/b")
	public WebElement headerPIM;
	
	@FindBy (id = "menu_pim_addEmployee")
	public WebElement headerAddEmp;
	
	@FindBy (xpath = "//a[@id='menu_admin_viewAdminModule']/b")
	public WebElement headerAdmin;
	
	@FindBy(id = "welcome")
	public WebElement welcome;
	
	@FindBy (id = "menu_core_viewDefinedPredefinedReports")
	public WebElement headerReports;
	
	public DashboardPageElements() {
		PageFactory.initElements(BaseClass.driver, this);		
	}


}
