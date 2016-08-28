package com.intuit.pageobjects;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.intuit.App;

public class overviewpage extends App {
	
	/*
	public overviewpage(WebDriver driver) {
		super(driver);
	}
	*/
	
	@Override
	public List<WebElement> pageElementsToWait() {
		List<WebElement> myElementList = new ArrayList<WebElement>();

		myElementList.add(requestPayment);
		myElementList.add(sendPayment);
		myElementList.add(signout);
		return myElementList;

	}
	
	@FindBy(xpath = "//*[@id='sidebar']/div/a[1]")
	private WebElement requestPayment;
	
	@FindBy(xpath = ".//*[@id='sidebar']/div/a[2]")
	private WebElement sendPayment;
	
	@FindBy(xpath = ".//*[@id='signOutForm']/div/ul/li[6]/a")
	private WebElement signout;
	
	public WebElement getSignoutLink(){
		return signout;
	}
	
	public WebElement getRequestPaymentButton(){
		return requestPayment;
	}
	
	public void clickSignoutLink(){
		
		getSignoutLink().click();
	}
	
	public boolean isRequestPaymentButtonvisible(){
		
		boolean isDisplay = getRequestPaymentButton().isDisplayed();
		return isDisplay;
		
	}
	

}
