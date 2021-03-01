package baseClass;

import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationDriver
{
  		// Create properties reference to read from properties file
  		Properties p = new Properties();
  			
  		// Constructor to initialize reader object with our properties file and load it
  		public ApplicationDriver()throws Exception
  		{
  			FileReader reader = new FileReader("config.properties");		
  			 p.load(reader);
  		}

  		// Method to invoke ChromeDriver
  		public WebDriver ChromeDriver()
  		{
  			WebDriver driver;
  				
  			//Set driver properties (driverName, driverLocation)
  			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
  			driver = new ChromeDriver();
  			
  			//Get the value of baseURL by driver to open the website /web application
  			driver.get(p.getProperty("baseUrl"));
  			
  			//Maximize the opened window
  			driver.manage().window().maximize();
  			return driver;
  		}

  		// Method to invoke Firefox driver
  		public WebDriver FirefoxDriver()
  		{
  			WebDriver driver;
  			
  			//Set driver properties (driverName, driverLocation)
  			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
  			driver = new FirefoxDriver();
  			
  			//Get the value of baseURL by driver to open the website/web application
  			driver.get(p.getProperty("baseUrl"));
  			
  			//Maximize the opened window
  			driver.manage().window().maximize();
  			return driver;
  		}
}
