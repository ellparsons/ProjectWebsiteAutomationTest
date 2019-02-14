package com.parsons.elliott.MotorcycleWebsiteTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MotorcycleSearchpage {
	
	@FindBy(xpath="//*[@id=\"searchText\"]")
	WebElement searchTextBox;
	
	@FindBy(xpath = "//*[@id=\"contentRow\"]/div[1]/div/a[2]")
	WebElement searchResult;
					
	@FindBy(xpath = "//*[@id=\"searchButton\"]")
	WebElement submitSearchButton;
	
	public void InputSearchText(WebDriver driver, String text) {
		WebElement searchTextBoxClick = (new WebDriverWait(driver,10))
				.until(ExpectedConditions.elementToBeClickable(searchTextBox));
		searchTextBoxClick.click();
		searchTextBox.sendKeys(text);
	} 
	
	public String SearchResult(WebDriver driver) {
		WebElement searchResultClick = (new WebDriverWait(driver,10))
				.until(ExpectedConditions.elementToBeClickable(searchResult));
		return searchResultClick.getText(); 
	}
	
	public void SubmitSearch() {
		submitSearchButton.click();
	}
	
}
     
