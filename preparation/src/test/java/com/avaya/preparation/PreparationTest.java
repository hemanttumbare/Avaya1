package com.avaya.preparation;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

public class PreparationTest {
	
    
  @Test
  public void LaunchBrowser() {
	  
	  System.out.println("Launching Edge Browser...!!!");
	  WebDriver driver=null;
	  
	  System.setProperty("webdriver.edge.driver","/usr/bin/microsoft-edge");
	  
	  
	  EdgeOptions opt = new EdgeOptions();
	  opt.addArguments("--no-sandbox");
	  
	  try {
	   driver = new EdgeDriver(opt);
	  }catch(Exception e) {
		  System.out.print("++++++++++++"+e.getMessage());
		  e.printStackTrace();
	  }
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  driver.manage().window().maximize();
	  
	  driver.get("https://www.google.com/");
	  
	  System.out.println("Website : "+ driver.getCurrentUrl());
	  
	  driver.close();
  }
}
