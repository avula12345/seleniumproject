package com.intuit;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Utility {

	 protected Properties prop =null;
	 FileInputStream propfile = new FileInputStream("src/test/resources/ipntestdata.properties");
	 static String Path_ScreenShot = "D://IntuitPaymentNetwork//screenshots";
	 
	 public Utility() throws Exception {
		 
		 prop = new Properties();
		 prop.load(propfile);
	 }
	 
	 public String getUrl(){
		 return prop.getProperty("ipnurl");
	 }

	 public void takeScreenshot(WebDriver driver, String sTestCaseName) throws Exception{
		 
		 Log.info("Calling Screenshot method");
			try{
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(Path_ScreenShot +"_"+sTestCaseName +".jpg"));	
			} catch (Exception e){
				//Log.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "+e.getMessage());
				throw new Exception();
			}
		
		}

}