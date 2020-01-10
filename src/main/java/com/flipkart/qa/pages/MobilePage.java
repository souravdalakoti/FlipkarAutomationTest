package com.flipkart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.flipkart.qa.base.TestBase;

public class MobilePage extends TestBase {
	public MobilePage() {
		
	}
	@FindBy (xpath="//*[@class='_30P0WS' and contains(text(),'Mobile Phones')]")
	WebElement mobilePhones;
	
	@FindBy (xpath="//*[//p[@class='yHn1qE' and contains(text(),'realme')]")
	WebElement realme;
	@FindBy (xpath="////*[//p[@class='yHn1qE' and contains(text(),'Mi')]")
	WebElement mi;
	@FindBy (xpath="////*[//p[@class='yHn1qE' and contains(text(),iIPhone')]")
	WebElement iPhone;
	@FindBy (xpath="////*[//p[@class='yHn1qE' and contains(text(),'Samsung')]")
	WebElement Samsung;
	@FindBy (xpath="////*[//p[@class='yHn1qE' and contains(text(),'VIVO')]")
	WebElement vivo;
	@FindBy (xpath="////*[//p[@class='yHn1qE' and contains(text(),'OPPO')]")
	WebElement oppo;
	@FindBy (xpath="////*[//p[@class='yHn1qE' and contains(text(),'Honor')]")
	WebElement honor;
	@FindBy (xpath="////*[//p[@class='yHn1qE' and contains(text(),'Asus')]")
	WebElement asus;
}
