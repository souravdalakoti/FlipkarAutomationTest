package com.flipkart.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	public HomePage homepage;
	public LoginPage loginpage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod()
	@Parameters
	public void setUp() throws Throwable {
		
		initialization();
		
		loginpage= new LoginPage();
		homepage= new HomePage();
		//homepage= loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority = 1)
	public void productSearchBarTest(){
		
		homepage.productSearchBar(prop.getProperty("searchdata"));
			
	}
	@Test(priority = 2)
	public void validatePageTitleTest() {
		homepage.validatePageTitle();
	}
	@Test(priority = 3)
	public void validateDealsOftheDayTest() {
		homepage.validateDealsOftheDay();
	}
	@Test(priority = 4)
	public void clickOnCartTest() {
		homepage.clickOnCart();
	}
	@Test(priority = 5)
	public void validatTopSelection() {
		homepage.validatTopSelection();
	}

		
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
