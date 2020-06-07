package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class ReportPage extends CommonMethods {
	
	public void navigateToReportsPage() {
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		wait(2);
		click(dashboard.headerPIM);
		wait(2);
		click(dashboard.headerReports);
		wait(1);	
	}
	
	@FindBy (id = "search_search")
	public WebElement textBoxReportName;
	
	@FindBy (xpath = "//input[@class='searchBtn']")
	public WebElement searchBtn;
	
	@FindBy (id = "btnAdd")
	public WebElement addBtn;

}
