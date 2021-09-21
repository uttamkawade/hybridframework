package com.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.Testbase;
import com.pages.DashboardPage;
import com.pages.LoginPage;


public class LoginTest extends Testbase {  //extends becouse of we get all methods as well as varibles.
	WebDriver driver;
	 LoginPage lp;
	 DashboardPage dp;
	 private static Logger log= Logger.getLogger(LoginTest.class);    //by adding same class name use them 
	 @BeforeTest
	 public void OpenBrowser(){
		 driver=initialization();
		 lp=new LoginPage(driver);
	 }
	 
	 @AfterTest
	 public void closeBrowser(){
		 driver.quit();
	 }
	 
	 //login test
	 @Test(priority=1)
	 public void login(){
		 
		 
		 log.info("login to the application");
		dp=lp.validLogin();
		 log.info("login sucessfull");
		 dp.clickLogout();
		 log.info("Logout Sucessfull");
		// Assert.assertEquals(driver.getTitle(), "javay");
	 }
	 
}
