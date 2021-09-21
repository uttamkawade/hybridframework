package com.listener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.base.Testbase;



public class Mylistener implements ITestListener{
	
	SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss");

	public void onFinish(ITestContext arg0) {
				
	}

	public void onStart(ITestContext result) {
		//log.info("testcase is started with name " + result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		Testbase.log.info("testcase is failed with name " + result.getName());
		TakesScreenshot ts = (TakesScreenshot) Testbase.driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		//String path=System.getProperty("user.dir")+"/Screenshots/Demo"+new Date().getDate()+".png";  // only date save ex.demo25.png
		String path=System.getProperty("user.dir")+"/Screenshots/Demo"+sdf.format(new Date())+".png";
		try {
			Testbase.log.info("Saving a screenshot for failed testcase");
			FileUtils.copyFile(src, new File(path));
		} catch (IOException e) {
			Testbase.log.error("screenshot is not saved");
			Testbase.log.error(e.getClass().getName());
		}
	}

	public void onTestSkipped(ITestResult result) {
		Testbase.log.info("testcase is skipped with name " + result.getName());
		
	}

	public void onTestStart(ITestResult result) {
		Testbase.log.info("testcase is started with name " + result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		Testbase.log.info("testcase is success with name " + result.getName());
		
	}

}
