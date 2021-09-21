package com.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testbase {
	
	public static WebDriver driver ;
	public static Logger log= Logger.getLogger(Testbase.class); //("Testbase")
	
	public static String readProperty(String key){
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
		
	}
	
	public static WebDriver initialization(){
		log.info("initialising browser");
		try{
		log.warn("chromedriver file should present at the location" );	
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		driver = new ChromeDriver();
		}catch (Exception e) {
			log.error("chromedriver file is not available");   // if get in error like chrome file not proper path
			log.error(e.getClass().getName());
		}
		log.info("chromdriver opened");
	    driver.get(readProperty("url"));
	    driver.manage().window().maximize();
	    log.info("jbk offline application launched");
	    return driver;
		
	}

}
