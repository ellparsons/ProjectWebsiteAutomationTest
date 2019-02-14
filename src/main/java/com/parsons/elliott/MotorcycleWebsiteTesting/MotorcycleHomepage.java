package com.parsons.elliott.MotorcycleWebsiteTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MotorcycleHomepage { 
	
	WebElement driver;
	
	@FindBy(xpath= "//*[@id=\"searchButton\"]")
					
	WebElement motorcycleSearchButton; 
	
	@FindBy(xpath= "//*[@id=\"navbarResponsive\"]/ul/li[2]/a")
	WebElement motorcycleCreateButton; 
	
	public void navigateToSearchPage(WebDriver driver) {
		motorcycleSearchButton.click();
	} 
	 
	public void navigateToCreationPage() {
		motorcycleCreateButton.click();
	}
}