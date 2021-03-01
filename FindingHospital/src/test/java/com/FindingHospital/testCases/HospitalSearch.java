package com.FindingHospital.testCases;

import java.io.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import com.FindingHospital.utilities.Highlighter;

//To access properties and varibles of Homepage we extend that class using extends keyword
public class HospitalSearch extends Homepage {
	// Rating filter
	@Test(priority = 4)
	public void rating() throws Exception {

		//Add wait using sleep method to capture screenshot
		Thread.sleep(8000);

		// To capture screenshot of Home page
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source1 = screenshot.getScreenshotAs(OutputType.FILE);
		try {
			
			FileUtils.copyFile(source1, new File("./Screenshots/Search Hospital Info.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}

		WebElement rating = driver.findElement(
				By.xpath("//*[@id='container']/div[3]/div/div[1]/div/div/header/div[1]/div/div[2]/label/span/span"));
        
		//To Highlight element
	    Highlighter.highLightElement(driver,rating);
		rating.click();

		
	}

	// 24*7 filter
	@Test(priority = 5)
	public void availability() throws Exception {

		Thread.sleep(7000);

		WebElement avail = driver.findElement(
				By.xpath("//*[@id='container']/div[3]/div/div[1]/div/div/header/div[1]/div/div[3]/label/span/span"));
		
		//To Highlight element
	    Highlighter.highLightElement(driver,avail);
		avail.click();

	}
	

	// more filters like parking and cafeteria
	@Test(priority = 6)
	public void filters() throws Exception {

		Thread.sleep(7000);

		filter = driver.findElement(
				By.xpath("//*[@id='container']/div[3]/div/div[1]/div/div/header/div[1]/div/div[4]/span/span"));
		
		//To Highlight element
	    Highlighter.highLightElement(driver,filter);
		filter.click();

		Thread.sleep(5000);

		WebElement park = driver.findElement(
				By.xpath("//*[@id='container']/div[3]/div/div[1]/div/div/header/div[2]/div/div/div/label[1]/div"));
		
		//To Highlight element
	    Highlighter.highLightElement(driver,park);
		park.click();

		Thread.sleep(7000);

		// cafetaria filter
		filter = driver.findElement(
				By.xpath("//*[@id='container']/div[3]/div/div[1]/div/div/header/div[1]/div/div[4]/span/span"));
		
		//To Highlight element
	    Highlighter.highLightElement(driver,filter);
		filter.click();

		Thread.sleep(7000);

		WebElement cafe = driver.findElement(
				By.xpath("//*[@id='container']/div[3]/div/div[1]/div/div/header/div[2]/div/div/div/label[4]/div"));
		
		//To Highlight element
	    Highlighter.highLightElement(driver,cafe);
		cafe.click();

		Thread.sleep(7000);

		System.out.println("Hospitals have 24*7 open , parking , cafeteria and rating above 3.5");
	}

	// hospitals with more than 3.5 rating
	@Test(priority = 7)
	public void displayHospitalNames() throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// scrolling to get more hotels
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(7000);

		// list of hospital
		List<WebElement> name = driver.findElements(By.xpath(
				"//div[@class='u-cushion u-white-fill u-normal-text o-card o-card--separated c-list-card']//descendant::h2"));

		Thread.sleep(7000);

		for (int i = 0; i < name.size(); i++) {
			String Name = name.get(i).getText();
			System.out.println(Name);

		}

		// Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		// Create Excel Sheet
		XSSFSheet sheet = workbook.createSheet("Details");
		// Iterate over the Data
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("SNo.");
		row.createCell(1).setCellValue("Name");

		// hospitals of Bangalore city with rating more than 3.5
		for (int i = 0, j = 0; i < name.size(); i++) {
			j++;
			row = sheet.createRow(j);
			row.createCell(0).setCellValue(j);
			System.out.println(name.get(i).getText());
			row.createCell(1).setCellValue(name.get(i).getText());

		}

		// Write Down file on HardDisk

		FileOutputStream fos = new FileOutputStream(new File("Hospitals.xlsx"));

		workbook.write(fos);

		System.out.println("Excel file is being created Successfully......Logging Out");

	}

}

