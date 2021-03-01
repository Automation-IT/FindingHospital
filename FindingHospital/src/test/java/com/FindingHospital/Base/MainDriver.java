package com.FindingHospital.Base;

import org.testng.annotations.Test;
import com.FindingHospital.Base.ApplicationDriver;
import java.util.Scanner;
import org.openqa.selenium.WebDriver;

public class MainDriver {
	@Test
    public WebDriver mainDriver() throws Exception {
        WebDriver driver = null;
      
        //Asking user for his choice of web driver
        System.out.println("Enter the name of the browser from available choices:\n1: Chrome\n2: Firefox\n3:Edge");
        Scanner sc = new Scanner(System.in);
        String choice = sc.next();
        
        //Closing scanner object to prevent leak 
        sc.close();
        
        //Creating object of ApplicationDriver to invoke driver depending upon user choice and available choices
        ApplicationDriver baseobject = new ApplicationDriver();

         if(choice.equalsIgnoreCase("Chrome"))
        {
            // If user enters Chrome as the driver, calling the ChromeDriver class 
            // and storing the returned driver to static variable driver
            driver = baseobject.ChromeDriver();
            return driver;
        }
        
          else if(choice.equalsIgnoreCase("Firefox"))
          {
            // If user enters Firefox as the driver, calling the ChromeDriver class 
            // and storing the returned driver to static variable driver
            driver = baseobject.FirefoxDriver();
            return driver;
          }
         // return driver;
         
          else if(choice.equalsIgnoreCase("Edge"))
          {
            // If user enters Edge as the driver, calling the ChromeDriver class 
            // and storing the returned driver to static variable driver
            driver = baseobject.EdgeDriver();
            return driver;
          }
         return driver;
    }

 
}

