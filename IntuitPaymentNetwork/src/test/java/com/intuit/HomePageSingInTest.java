package com.intuit;

import java.io.FileInputStream;
import java.util.List;

import junit.framework.Assert;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.intuit.pageobjects.IPNHomePage;
import com.intuit.pageobjects.overviewpage;
import com.intuit.pageobjects.invalidLoginPage;
import com.intuit.pageobjects.IPNSingInPage;

public class HomePageSingInTest {

	static IPNHomePage ipnhomepage;
	static overviewpage overviewpage;
	static invalidLoginPage invalidLoginPage;
	static IPNSingInPage IPNSingInPage;
	static WebDriver driver;
	static Utility util;

	@BeforeTest
	public void Setup() throws Exception {
		
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("HomePageSingInTest");
		
		util = new Utility();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		String url = util.getUrl();
		driver.get(url);
		Log.info("URL is invoked");
		
	}

	@Test
	public static void singInTest() throws Exception {

		String uName, passwd = null;
		int i, j;
		ipnhomepage = PageFactory.initElements(driver, IPNHomePage.class);
		overviewpage = PageFactory.initElements(driver, overviewpage.class);
		invalidLoginPage = PageFactory.initElements(driver,invalidLoginPage.class);
		IPNSingInPage = PageFactory.initElements(driver,IPNSingInPage.class);
		
		ipnhomepage.clickSignInButton();

		FileInputStream fis = new FileInputStream("src/test/resources/ipn_testData.xls");
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sheet = wb.getSheet("sheet1");

		int rowCount = sheet.getLastRowNum();// getting no of rows
		
		Log.info("Row count = " + rowCount);
		
		for (i = 1; i <= rowCount; i++) {

			HSSFRow row = sheet.getRow(i);

			for (j = 0; j < row.getLastCellNum(); j++) {

				System.out.print(row.getCell(j).getStringCellValue() + "|| ");

				if (j == 0) {

					uName = row.getCell(j).getStringCellValue();
					IPNSingInPage.setUsename(uName);
					Log.info("Entering the username = " + uName);
				} else {
					passwd = row.getCell(j).getStringCellValue();
					IPNSingInPage.setPassword(passwd);
					Log.info("Entering the username = " + passwd);
				}
			}
			IPNSingInPage.clickSignInButton();
			Log.info("Clicking SignIn Button after entering username and password");
			
			Thread.sleep(10000);

			String title = driver.getTitle();

			if (title.contains("My PaymentNetwork Home")) {
				boolean val = overviewpage.isRequestPaymentButtonvisible();
				Assert.assertTrue(val);
				util.takeScreenshot(driver, "SuccessLogin");
				overviewpage.clickSignoutLink();
				Log.info("Clicking SignOut Button");
				ipnhomepage.clickSignInButton();
				Log.info("Clicking on Sign-In Button after sign-out in the IPN overview page");

			} /* else {
				invalidLoginPage.clickCancelButton();
				Log.info("Clicking Cancel Button");
			} */

		}

	}

	@AfterTest
	public void teardown() throws Exception {
		util.takeScreenshot(driver, "InvalidLogin");
		driver.quit();
		Log.info("Quitting browser instance");
		Log.endTestCase("HomePageSingInTest");
	}

}
