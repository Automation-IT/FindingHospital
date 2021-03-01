package com.FindingHospital.Base;

import java.io.FileReader;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class ApplicationDriver {
	
	// Create properties reference to read from properties file
    Properties properties = new Properties();
     
   // Constructor to initialize reader object with our properties file and load it
    public ApplicationDriver()throws Exception
    {
         FileReader readerobject = new FileReader("config.properties");        
         properties.load(readerobject);
    }     
 
    // Method to invoke Chrome driver
    public WebDriver ChromeDriver()
    {
         WebDriver driver;
         
         //To print on console that Chrome browser is launching
         System.out.println("Launching Chrome Browser");     
          
        
         //Set driver properties (driverName, driverLocation)
         System.setProperty("webdriver.chrome.driver",properties.getProperty("chromepath"));
         driver = new ChromeDriver();
        
         //Get the value of baseURL by driver to open the website/web application
         driver.get(properties.getProperty("baseUrl"));
     
         //Maximize the opened window
         driver.manage().window().maximize();
	     return driver;
        
     }
    
    
    // Method to invoke Firefox driver 
    public WebDriver FirefoxDriver()
    {
        WebDriver driver;
        
        //To print on console that firefox is launching
        System.out.println("Launching Firefox Browser");
        
        //Set driver properties (driverName, driverLocation)
        System.setProperty("webdriver.gecko.driver",properties.getProperty("firefoxpath"));
        driver = new FirefoxDriver();
        
        //Get the value of baseURL by driver to open the website/web application
        driver.get(properties.getProperty("baseUrl"));
        
        //Maximize the opened window
        driver.manage().window().maximize();
        return driver;
     }
    
    
 // Method to invoke Edge driver 
    public WebDriver EdgeDriver()
    {
        WebDriver driver;
        
        //To print on console that edge is launching
        System.out.println("Launching Edge Browser");
        
        //Set driver properties (driverName, driverLocation)
        System.setProperty("webdriver.edge.driver",properties.getProperty("edgepath"));
        driver = new EdgeDriver();
        
        //Get the value of baseURL by driver to open the website/web application
        driver.get(properties.getProperty("baseUrl"));
        
        //Maximize the opened window
        driver.manage().window().maximize();
        return driver;
     }
    
        
        
}
