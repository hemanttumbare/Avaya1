package com.avaya.preparation;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

public class ChromePreparationTest {
	
    
  @Test
  public void LaunchBrowser() {
	  
	  System.out.println("Launching Chrome Browser...!!!");
	  WebDriver driver=null;
	  
	  System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
	  
	  
	  ChromeOptions opt = new ChromeOptions();
	  
	  opt.addArguments("--no-sandbox");
	  opt.addArguments("--disable-dev-shm-usage");
	  try {
	   driver = new ChromeDriver(opt);
	  }catch(Exception e) {
		  System.out.print("Error message :"+e.getMessage());
		  e.printStackTrace();
	  }
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  driver.manage().window().maximize();
	  
	  driver.get("https://www.google.com/");
	  
	  System.out.println("Website : "+ driver.getCurrentUrl());
	  
      Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	  
	  System.out.println("Browser name : "+ cap.getBrowserName());
	  System.out.println("Browser version : "+ cap.getBrowserVersion());
	  
	  driver.close();

	  System.out.println("Browser Closed...!!!");
  }
}
