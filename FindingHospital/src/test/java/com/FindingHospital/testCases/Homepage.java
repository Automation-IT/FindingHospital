package com.FindingHospital.testCases;

import org.testng.annotations.*;
import com.FindingHospital.Base.MainDriver;
import java.io.*;
import java.util.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import java.util.concurrent.TimeUnit;
import com.FindingHospital.testCases.HospitalSearch;
import com.FindingHospital.utilities.*;
import com.aventstack.extentreports.*;


public class Homepage {
	
	// Create properties reference to read from properties file
	Properties properties = new Properties();
	public static WebDriver driver;
     
	//Create reference of ExtentReports class
	ExtentReports report = ExtentReport.getReportInstance();

	//Declare webElements of HomePage 
	public WebElement citylink;
	public WebElement banglore;
	public WebElement hospitalSearch;
	public WebElement hospt;
	public WebElement filter;

	// Constructor to initialize reader object with our properties file and load it
	@BeforeTest
	public void SetProperty() throws Exception {
		FileReader reader = new FileReader("config.properties");
		properties.load(reader);
	}

	@BeforeSuite
	public void SetDriver() {
		ExtentTest extentTest = report.createTest("Launch Browser");
		try {
			
			MainDriver object = new MainDriver();
			driver = object.mainDriver();
			extentTest.log(Status.INFO, "Browser Launched");
			extentTest.log(Status.INFO, "Navigated to https://www.practo.com/");
			extentTest.pass("Browser launched Successfully");
		} catch (Exception e) {
			extentTest.fail("Unable to launch the browser");
			e.printStackTrace();

		}

	}

	@Test
	public void verifyHomePageTitle() throws Exception {

		System.out.println("Home Page Title:" + driver.getTitle());
		
		//Add wait to capture screenshot
		Thread.sleep(4000);

		// To capture screenshot of Home page
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		try {
			
			FileUtils.copyFile(source, new File("./Screenshots/Hospital HomePage.png"));

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Test(priority = 2)
	public void city() {

		ExtentTest extentTest = report.createTest("City selection");
		try {
			
			// to search banglore city
			citylink = driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[1]/div/input"));
			
			//To Highlight element
		    Highlighter.highLightElement(driver, citylink);
			citylink.clear();

			// Add implicit wait
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			citylink.sendKeys("Bangalore");
			
			// Add implicit wait
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			banglore = driver.findElement(By.xpath("//div[contains(text(),'Bangalore')]"));
			System.out.println(banglore.getText() + " City has been chosen");
           
			//To Highlight element
		    Highlighter.highLightElement(driver,banglore);
			banglore.click();

			// Add implicit wait
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			extentTest.log(Status.INFO, "Selecting city to search");
			extentTest.pass("City selected Successfully");
		} catch (Exception e) {
			extentTest.fail("Unable to select city");
			e.printStackTrace();

		}

	}

	private void highLightElement(WebElement citylink2) {
		// TODO Auto-generated method stub

	}

//search hospitals in Bangalore
	@Test(priority = 3)
	public void searchhospital() {

		ExtentTest extentTest = report.createTest("Hospital keyword selection");
		try {

			hospitalSearch = driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[2]/div[1]/input"));
			
			//To Highlight element
		    Highlighter.highLightElement(driver,hospitalSearch);
			hospitalSearch.sendKeys("Hospital");

			// Add implicit wait
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			hospt = driver.findElement(By.xpath("//div[contains(text(),'Hospital')]"));
			System.out.println(hospt.getText() + " of Bangalore City has been selected");

			// Add implicit wait
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            
			
			//To Highlight element
		    Highlighter.highLightElement(driver,hospt);
			hospt.click();

			extentTest.log(Status.INFO, "Selecting hospital keyword to search");
			extentTest.pass("Hospital keyword selected Successfully");
		} catch (Exception e) {
			extentTest.fail("Unable to select Hospital keyword");
			e.printStackTrace();

		}

	}

	//Navigate to hospital search page
	@Test(priority = 4)
	public void callHospitalSearch() {

		ExtentTest extentTest = report.createTest("Displaying hospital list");
		try {

			HospitalSearch hospitalsearch = new HospitalSearch();
			hospitalsearch.rating();
			extentTest.log(Status.INFO, "Selecting rating filter");

			// HospitalSearch hospitalsearch1=new HospitalSearch();
			hospitalsearch.availability();
			extentTest.log(Status.INFO, "Selecting availibility filter");

			// HospitalSearch hospitalsearch2=new HospitalSearch();
			hospitalsearch.filters();
			extentTest.log(Status.INFO, "Selecting more filters");

			// HospitalSearch hospitalsearch3=new HospitalSearch();
			hospitalsearch.displayHospitalNames();

			extentTest.log(Status.INFO, "Displaying hospital names list as per filters");
			extentTest.pass("Hospital names list displayed Successfully");
		} catch (Exception e) {
			extentTest.fail("Unable to display Hospital names list");
			e.printStackTrace();

		}

	}

	//Navigate to diagnosis page
	@Test(priority = 5)
	public void callDiagnosispage() {
		ExtentTest extentTest = report.createTest("Displaying top cities list");
		try {
			Diagnosispage diagnnosis = new Diagnosispage();
			diagnnosis.click_Diagnosis();
			extentTest.log(Status.INFO, "Navigated to diagnnosis page");

			// Diagnosispage diagnnosis1=new Diagnosispage();
			diagnnosis.Top_cities();
			extentTest.log(Status.INFO, "Displaying top cities list");
			extentTest.pass("Top cities list displayed Successfully");
		} catch (Exception e) {
			extentTest.fail("Unable to display top cities list");
			e.printStackTrace();

		}

	}
	

	//Navigate to corporate wellness page
	@Test(priority = 6)
	public void callCorporateWellness() {

		ExtentTest extentTest = report.createTest("Capturing error message");
		try {
			CorporateWellness corporate = new CorporateWellness();
			corporate.corporateWellness();
			extentTest.log(Status.INFO, "Navigating to Corporate wellness page ");
			extentTest.log(Status.INFO, "Entering invalid details in the form ");

			extentTest.pass("Error message captured Successfully");
		} catch (Exception e) {
			extentTest.fail("Unable to capture error message ");
			e.printStackTrace();

		}
	}

	//To close driver
	@Test(priority = 7)
	public void CloseBrowser() {
		ExtentTest extentTest = report.createTest("Closing Browser");
		try {
			// Close the browser
			driver.quit();
			extentTest.pass("Browser closed Successfully");
		} catch (Exception e) {
			extentTest.fail("Unable to close the browser ");
			e.printStackTrace();

		}
		report.flush();
	}

}
