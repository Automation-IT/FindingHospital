package testCases;	

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.MainDriver;
//import PageClasses.HospitalSearch;
public class FindingHospitalMainClass {
	//Create properties reference to read from properties file
    Properties properties =new Properties();
   public  static WebDriver driver;
    public WebElement citylink;
    public WebElement banglore;
    public WebElement hospitalSearch;
    public WebElement hospt;
    public WebElement filter;
    
     //Constructor to initialize reader object with our properties file and load it
     @BeforeTest
     public void SetProperty()throws Exception
     {
       FileReader reader = new FileReader("config.properties");        
       properties.load(reader);
     } 
    
   
     @BeforeSuite
     public void SetDriver() throws Exception
     {
       MainDriver object = new MainDriver();
       driver = object.mainDriver();
      } 
     
     
     @Test
	  public void verifyHomePageTitle() throws Exception
      {
   
     
        System.out.println("Home Page Title:"+driver.getTitle());
     Thread.sleep(4000);
	
      }
    
     @Test (priority = 2)
     public void city() {
    	 
    	 
    	//to search banglore city
         
         citylink=driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[1]/div/input"));
         citylink.clear();
         
         //Add wait to capture screenshot
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         
         citylink.sendKeys("Bangalore");
       //Add wait to capture screenshot
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         
         banglore=driver.findElement(By.xpath("//div[contains(text(),'Bangalore')]"));
         System.out.println(banglore.getText()+" City has been chosen");
         
         banglore.click();
         
       //Add wait to capture screenshot
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         
     }
     
     //search hospitals in Bangalore
     @Test (priority = 3)
     public  void searchhospital() {
 		
    	 hospitalSearch=driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[2]/div[1]/input"));
    	 hospitalSearch.sendKeys("Hospital");
    	 
    	//Add wait to capture screenshot
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       
         hospt=driver.findElement(By.xpath("//div[contains(text(),'Hospital')]"));
    	 System.out.println(hospt.getText()+" of Bangalore City has been selected");
    	 
    	//Add wait to capture screenshot
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         
    	 hospt.click();
    	
     }
     
   //Rating filter
     @Test (priority = 4)
     public void rating() throws Exception
     {
 			Thread.sleep(7000);
 		
    	 WebElement rating=driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[1]/div/div/header/div[1]/div/div[2]/label/span/span"));
    	 rating.click();
   	   //Add wait to capture screenshot
         driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
         
        
     }
     
   //24*7 filter
     @Test (priority = 5)
     public void availability() throws Exception
     {
         
 			Thread.sleep(7000);
 	
       WebElement avail=driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[1]/div/div/header/div[1]/div/div[3]/label/span/span"));
 	   avail.click();
 	   //Add wait to capture screenshot
       driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

 	}
     
     //more filters like parking and cafeteria
     @Test (priority = 6)
     public void filters() throws Exception {
    	
			Thread.sleep(7000);

    	 
 	    filter=driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[1]/div/div/header/div[1]/div/div[4]/span/span"));
 		filter.click();
 		
			Thread.sleep(5000);
		
 		WebElement park=driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[1]/div/div/header/div[2]/div/div/div/label[1]/div"));
 		park.click();
 		
			Thread.sleep(7000);
		
 		//cafetaria filter
        filter=driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[1]/div/div/header/div[1]/div/div[4]/span/span"));
 		filter.click();
 		
			Thread.sleep(7000);
	
 	
 		WebElement cafe=driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[1]/div/div/header/div[2]/div/div/div/label[4]/div"));
 		cafe.click();
 	
			Thread.sleep(7000);
	
 		System.out.println("Hospitals have 24*7 open , parking , cafeteria and rating above 3.5");
 	}
     
     
    //hospitals with more than 3.5 rating 
     @Test (priority = 7)
 	 public void displayHospitalNames() throws Exception {
 		
         	JavascriptExecutor js = (JavascriptExecutor) driver;
             //scrolling to get more hotels 
             js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(7000);
       
     
       //list of hospital
 		List<WebElement> name=driver.findElements(By.xpath("//div[@class='u-cushion u-white-fill u-normal-text o-card o-card--separated c-list-card']//descendant::h2"));

 	
			Thread.sleep(7000);
	
     	for(int i=0;i<name.size();i++)
 	    {
 	    		String Name=name.get(i).getText();
 	    		System.out.println(Name);
 	    		
 	    
 	    }
     	
     	//Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
       //Create Excel Sheet
        XSSFSheet sheet = workbook.createSheet("Details");
        //Iterate over the Data
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("SNo.");
        row.createCell(1).setCellValue("Name");
        
        
        //hospitals of Bangalore city with rating more than 3.5
        for(int i=0,j=0;i<name.size();i++)
        {   
                j++;
                row = sheet.createRow(j);
                row.createCell(0).setCellValue(j);
                System.out.println(name.get(i).getText());
                row.createCell(1).setCellValue(name.get(i).getText());
                
            }
        
        //Write Down file on HardDisk

        FileOutputStream fos = new FileOutputStream(new File("Hospitals.xlsx"));

        workbook.write(fos);
        workbook.close();
     	System.out.println("Excel file is being created Successfully......Logging Out");

     
     }
  
     //Click on Diagnosis 
     @Test (priority = 8)
     public void click_Diagnosis() throws Exception {
 		
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
         //scrolling to get more hotels 
         js.executeScript("window.scrollTo(document.body.scrollHeight , 0)");
   
 			Thread.sleep(5000);
 	
        driver.navigate().to("https://www.practo.com/tests?city=bangalore");
    
 	}
     
     
     //display all top cities
     @FindBy(xpath="//*[@id='locationInput']")
     public WebElement topcity;
     
     @FindBys(@FindBy(xpath="//div[@class='u-margint--standard o-f-color--primary']"))
     public List<WebElement> cities;
     
     @Test (priority = 9)
     public void Top_cities() throws Exception 
     {
    	 //driver.findElement(By.xpath("//*[@id='locationInput']"))
    	 topcity.click();
    	        //display all top cities
    	     
    	        XSSFWorkbook workbook = new XSSFWorkbook();
    	         //Create Excel Sheet
    	        XSSFSheet sheet = workbook.createSheet("Details");
    	           //Iterate over the Data
    	        Row row = sheet.createRow(0);
    	         row.createCell(0).setCellValue("SNo.");
    	         row.createCell(1).setCellValue("Top Cities");
    	             
    	         System.out.println(cities.size());
    	        for(int i=0;i<cities.size();i++)
    	             {
    	                 row = sheet.createRow(i+1);
    	                 row.createCell(0).setCellValue(i+1);
    	                 row.createCell(1).setCellValue(cities.get(i).getText());
    	                 System.out.println(cities.get(i).getText());
    	             }
    	         
    	        //Write Down file on HardDisk
    	         FileOutputStream foss = new FileOutputStream(new File("Top_Cities.xlsx"));
    	          workbook.write(foss);
    	          workbook.close();
    	           System.out.println("Excel file is being created Successfully......Logging Out");
    	          cities.get(0).click();
    	 
 	}
    
     @Test (priority = 11)
     public void corporateWellness() throws Exception
     {
    	 driver.navigate().to("https://www.practo.com/");
    	 

      	JavascriptExecutor js = (JavascriptExecutor) driver;
          //scrolling to get more hotels 
          js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
         Thread.sleep(7000);
         
         driver.navigate().to("https://www.practo.com/plus/corporate");
       	 Thread.sleep(10000);
    	 
    	 //Filling value in form
    	 WebElement name=driver.findElement(By.xpath("//*[@id='name']"));
    	 name.sendKeys("psnsp");
    	 Thread.sleep(1000);
    	 driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/form/table/tbody/tr/td[2]/div/input[2]")).sendKeys("Group-3");
    	 Thread.sleep(1000);
    	 driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/form/table/tbody/tr/td[2]/div/input[3]")).sendKeys("psnsp.gmail.com");
    	 Thread.sleep(1000);
    	 driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/form/table/tbody/tr/td[2]/div/input[4]")).sendKeys("9876543210");
    	 Thread.sleep(1000);
    	 driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/form/table/tbody/tr/td[2]/div/button")).click();
    	 Thread.sleep(7000);
    	 
    	 Alert alt=driver.switchTo().alert();
    	 String msg=alt.getText();
    	 alt.accept();
    	 
    	 System.out.println("Message is : "+msg);
    	 
     }
     
     @AfterSuite 
     public void CloseBrowser()
     {
     	//Close the browser
     	 driver.quit();
     }
     
}