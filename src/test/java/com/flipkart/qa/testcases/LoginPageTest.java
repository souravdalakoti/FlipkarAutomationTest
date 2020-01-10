package com.flipkart.qa.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.LoginPage;
import com.flipkart.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	public LoginPageTest()throws Throwable{
		super();
	}
@BeforeMethod
	public void setup() throws Throwable{
	initialization();
	loginpage= new LoginPage();
	}
@DataProvider
public Object[][] getTestData() throws Throwable {
	Object[][] data=TestUtil.getData();
	return data;
}
@Test  (priority = 2, dataProvider = "getTestData")
public void loginTest(String username, String password)throws Throwable{
 loginpage.Login(username, password);
	TestUtil.screenshot("Logintest");
}
@Test (priority = 1)
public void logInTest() {
	loginpage.LogIn(prop.getProperty("username"), prop.getProperty("password"));
}
@AfterMethod
public void tearDown() {
driver.quit();
	
}
}