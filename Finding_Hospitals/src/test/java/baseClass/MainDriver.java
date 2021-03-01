package baseClass;

import org.testng.annotations.Test;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;

public class MainDriver 
{
	@Test
	public WebDriver mainDriver() throws Exception 
	{
		 WebDriver driver=null;
			
		// Asking user for his choice of web driver
		System.out.println("Enter the name of the browser from available choices:\n1: Chrome\n2: Firefox");
		Scanner sc = new Scanner(System.in);
		String choice = sc.next();
		 
		// Closing scanner object to prevent leak 
		sc.close();
		
		// Creating object obj Application_Driver class to invoke driver depending upon user choice and available choices
		ApplicationDriver obj = new ApplicationDriver();

		if(choice.equalsIgnoreCase("chrome"))
		{
			// If user enters chrome as the driver, calling the ChromeDriver class 
			// and storing the returned driver to static variable
			
			driver = obj.ChromeDriver();
			return driver;
		}
		 
		else if(choice.equalsIgnoreCase("firefox"))
		{
			// If user enters firefox as the driver, calling the ChromeDriver class 
			// and storing the returned driver to static variable
				
			driver = obj.FirefoxDriver();
			return driver;
		}
	return driver;
	}
}
