package com.hrms.testbase;

import com.hrms.pages.AddEmployeePage;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.ViewPersonnelDetails;

public class PageInitializer extends BaseClass {
	
	public static LoginPageElements login;
	public static DashboardPageElements dashboard;
	public static AddEmployeePage addEmp;
	public static ViewPersonnelDetails detail;
	
	public static void initialize() {
		
		login = new LoginPageElements();
		dashboard = new DashboardPageElements();
		addEmp = new AddEmployeePage();
		detail = new ViewPersonnelDetails();
		
		
		
	}

}
