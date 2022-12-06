package com.qualityworkscg.tests;


import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qualityworkscg.pages.Page;

public abstract class  AbstractTest {
  
  protected static Page page;
  
  @BeforeTest
  @Parameters({"url"})
  public void setup(String url) {
    // Set the path to the geckodriver
   // System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
    System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
   EdgeOptions options = new EdgeOptions();
		options.addArguments("--remote-debugging-port=9222");
options.addArguments("--headless");
		  		  options.addArguments("--no-sandbox");
		  		  options.addArguments("--disable-setuid-sandbox");
		  		  options.addArguments("--disable-dev-shm-usage");
		  		  options.addArguments("--disable-extensions");
    // Instantiate a new Page and navigate 
    // to the url specified in the testng.xml
  //  page = new Page(new FirefoxDriver());
  
		    	
    page = new Page(new EdgeDriver(options));
    
    page.navigate(url);
  }

  @AfterTest
  public void afterTest() {
    page.tearDown();
  }
}
