package com.parsons.elliott.MotorcycleWebsiteTesting;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MotorcycleSearchSteps {
	
	static WebDriver driver;
	static Actions action;
	static ExtentTest test;
	static ExtentReports extent;  
	static String testVariable = "Yamaha R1"; 
	static String testVariable1 = "Honda MSX125";
	static String testVariable2 = "MSX125";
 
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
		extent = new ExtentReports("C:\\Users\\Admin\\Documents\\Motorcycle.html",false); 
		test = extent.startTest("Motorcycle Search Test : ");
		driver = new ChromeDriver();
		System.out.print("testing driver "+driver); 
	}
	 
	@After
	public static void teardown() {  
		extent.flush();   
		driver.quit();  
	} 
	
	@Given("^the correct web address$")
	public void the_correct_web_address()   {
		driver.manage().window().maximize(); 
		driver.get("file:///C:/Users/Admin/Documents/Project/Website/startbootstrap-modern-business-gh-pages/motorcycleHomepage.html");
		test.log(LogStatus.INFO,"Loading browser and homepage");
	}

	@When("^I navigate to the 'Search' page$")
	public void i_navigate_to_the_Search_page()   {
	    MotorcycleHomepage homepage = PageFactory.initElements(driver, MotorcycleHomepage.class);
	    	homepage.navigateToSearchPage(driver); 
	}
 
	@Then("^I can browse all the motorcycles\\.$")
	public void i_can_browse_all_the_motorcycles()   {
		MotorcycleSearchpage search = PageFactory.initElements(driver, MotorcycleSearchpage.class);
		boolean testResult=false;
		if(search.SearchResult(driver).equals(testVariable)) {
			test.log(LogStatus.PASS, "PASS");
			testResult=true;  
		}
	}  
 
	@When("^I input a motorcycle and click the search button$")
	public void i_input_a_motorcycle_and_click_the_search_button() throws InterruptedException      {
		MotorcycleSearchpage search = PageFactory.initElements(driver, MotorcycleSearchpage.class);
		MotorcycleHomepage homepage = PageFactory.initElements(driver, MotorcycleHomepage.class);
    	homepage.navigateToSearchPage(driver); 
		test.log(LogStatus.INFO,"Inputting search choices");
		search.InputSearchText(driver, testVariable2); 
		Thread.sleep(5000);
		test.log(LogStatus.INFO,"Click search button"); 
		search.SubmitSearch(); 
		Thread.sleep(5000); 
	} 
	  
	@Then("^I am shown motorcycles relating to my search$")
	public void i_am_shown_motorcycles_relating_to_my_search()   {
		MotorcycleSearchpage search = PageFactory.initElements(driver, MotorcycleSearchpage.class);
		test.log(LogStatus.INFO,"View search results");
		boolean testResult = false; 
		if(search.SearchResult(driver).equals(testVariable1)) {
			test.log(LogStatus.PASS, "PASS");
			testResult = true;
		}
		assertEquals(true,testResult );
	}
}
