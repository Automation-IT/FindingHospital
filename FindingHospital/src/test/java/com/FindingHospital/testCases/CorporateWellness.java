package com.FindingHospital.testCases;

import java.io.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import com.FindingHospital.utilities.Highlighter;

//To access properties and varibles of Homepage we extend that class using extends keyword
public class CorporateWellness extends Homepage {
	
	//For Corporate Wellness Page
	@Test(priority = 10)
	public void corporateWellness() throws Exception {
		
		//Navigate Home page
		driver.navigate().to("https://www.practo.com/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// scrolling to get more hotels
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		//Add wait using sleep method of thread class
		Thread.sleep(7000);
         
		//Navigate to corporate wellness page
		driver.navigate().to("https://www.practo.com/plus/corporate");
		Thread.sleep(10000);

		// Filling details in form
		
		
		WebElement name = driver.findElement(By.xpath("//*[@id='name']"));
		
		//To Highlight element
	    Highlighter.highLightElement(driver,name);
		name.sendKeys("psnsp");
		Thread.sleep(1000);
		
		WebElement group=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/form/table/tbody/tr/td[2]/div/input[2]"));
		//To Highlight element
	    Highlighter.highLightElement(driver,group);
		 group.sendKeys("Group-3");
		 Thread.sleep(1000);
		 
		WebElement gmail=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/form/table/tbody/tr/td[2]/div/input[3]"));
		//To Highlight element
	    Highlighter.highLightElement(driver,gmail);
		gmail.sendKeys("psnsp.gmail.com");
		Thread.sleep(1000);
		
		WebElement phone=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/form/table/tbody/tr/td[2]/div/input[4]"));
		//To Highlight element
	    Highlighter.highLightElement(driver,phone);
		phone.sendKeys("9876543210");
		Thread.sleep(1000);
		
		WebElement submit= driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/form/table/tbody/tr/td[2]/div/button"));
		//To Highlight element
	    Highlighter.highLightElement(driver,submit);
		submit.click();
		Thread.sleep(7000);
        
		//To handle error message in alert box
		Alert alt = driver.switchTo().alert();
		String msg = alt.getText();
		
		alt.accept();
		
		//add wait to capture the screenshot
		Thread.sleep(3000);

		// To capture screenshot of Corporate Wellness page
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		try {
			
			FileUtils.copyFile(source, new File("./Screenshots/CorporateWelllness Error Message.png"));

		} catch (IOException e) {

			e.printStackTrace();
		}
        
		//Display error message on console output
		System.out.println("Message is : " + msg);

	}

}
