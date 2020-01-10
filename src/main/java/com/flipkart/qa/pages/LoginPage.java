package com.flipkart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page factory/ OR
 @FindBy(xpath ="//input[@class='_2zrpKA _1dBPDZ']")
WebElement username;

@FindBy(xpath = "//input[@type='password']")
WebElement password;

@FindBy(xpath = "//*[@class='_2AkmmA _1LctnI _7UHT_c']")
WebElement login;
@FindBy(xpath = "//*[@class='ZAtlA-']")
WebElement invalidmsg;
//initializing page objects
public LoginPage() throws Throwable{
	
	PageFactory.initElements(driver, this);
}
//Actions
public String ValidateLoginPage() {
	return driver.getTitle();
	}
// login with multiple data
public HomePage Login(String un ,String psw) {
	username.sendKeys(un);
	password.sendKeys(psw);
	login.click();

	return new HomePage();
}
// login with valid data
public HomePage LogIn(String un ,String psw) {
	username.sendKeys(un);
	password.sendKeys(psw);
	login.click();

	return new HomePage();
}

}