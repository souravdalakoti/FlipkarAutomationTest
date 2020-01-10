package com.flipkart.qa.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;

public class HomePage extends TestBase {
	public Actions action ;
	
	@FindBy(xpath = "//*[@class='LM6RPg']")
	WebElement productsearchbar;
	@FindBy(className  = "vh79eN")
	WebElement productsearchsubmit;
	@FindBy(xpath="//*[contains(text(),'Deals of the Day')]")
	WebElement dealsoftheday;
	@FindBy (linkText  = "Cart")
	WebElement cart;
	@FindBy (xpath = "//*[contains(text(),'Top Selection')]")
	WebElement topselection;
	@FindBy (xpath="//*[@class='_1QZ6fC _3Lgyp8' and contains(text(),'Electronics')]")
	WebElement electronics;
	@FindBy (xpath = "//*[@title='Mobiles']")
	WebElement mobile;
	public HomePage() {
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
		
		action.sendKeys(Keys.ESCAPE).build().perform();;
	}
	
	public void productSearchBar(String searchiteml) {
		
		productsearchbar.sendKeys(searchiteml);
		productsearchsubmit.click();
	}
	public void validatePageTitle() {
		String title= driver.getTitle();
		assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!", "page title is not matched");
		}
	public boolean validateDealsOftheDay() {
		dealsoftheday.isDisplayed();
		return true;	
	}
	public Cart clickOnCart() {
		cart.click();
		return new Cart();
	}
	public boolean validatTopSelection() {
		
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		topselection.isDisplayed();
		return true;
	}
	public MobilePage clickOnMobiles() {
		action= new Actions(driver);
		action.moveToElement(electronics).build().perform();
		mobile.click();
		return new MobilePage();
	}
}
