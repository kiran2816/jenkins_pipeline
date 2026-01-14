package com.practice.configue_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Parameters;



public class BaseClass {
	 public WebDriver driver;
	 public static WebDriver sdriver;
	 
//	 @Parameters("browser")
	 @BeforeMethod(alwaysRun = true)
	 public void configueBM() {
		 String browser= System.getProperty("browser");
		 if(browser.equals("safari")) {
			 driver= new SafariDriver();
		 }
		 else if(browser.equals("firefox")) {
			 driver=new FirefoxDriver();
		 }
		 else if(browser.equals("edge")) {
			 driver=new EdgeDriver();
		 }else {
			 driver=new ChromeDriver();
		 }
		 
		 sdriver=driver;
	 }
	 
	 @AfterMethod(alwaysRun = true)
	 public void configueAM() {
		 driver.quit();
	 }
}
