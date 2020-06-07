package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hrms.utils.CommonMethods;

public class PredefinedReportPage extends CommonMethods {
	
	
	@FindBy (id = "report_report_name")
	public WebElement textBoxReportName;
	
	@FindBy (id = "report_criteria_list")
	public WebElement txtbxCriteriaList;
	
	public void selectCriteriaList(String criteria) {
		selectDdValue(txtbxCriteriaList, criteria);
	}
	
	@FindBy (id = "btnAddConstraint")
	public WebElement addLinkCriteria;
	
	@FindBy (id = "report_include_comparision")
	public WebElement txtbxCriteriaIncludeList;
	
	public void selectCriteriaIncludeList(String criteriaInclude) {
		selectDdValue(txtbxCriteriaIncludeList, criteriaInclude);
	}
	
	@FindBy (xpath = "//label[text()='Employee Name']")
	public WebElement labelEmployeeName;
	
	@FindBy (id = "employee_name_empName")
	public WebElement employeeName;
	
	@FindBy (id = "report_display_groups")
	public WebElement displayFieldGroup;
	
	public void selectDisplayFieldGroupList(String fieldGroup) {
		selectDdValue(displayFieldGroup, fieldGroup);
	}
	
	
	
	
	
	
	

}
