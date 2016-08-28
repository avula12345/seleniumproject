package com.intuit.pageobjects;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.intuit.App;

public class IPNHomePage extends App {
	
	/*
	public IPNHomePage(WebDriver driver) {
		super(driver);
	}
	*/
	
	@Override
	public List<WebElement> pageElementsToWait() {
		List<WebElement> myElementList = new ArrayList<WebElement>();

		//myElementList.add(ipnUsername);
		//myElementList.add(ipnPassword);
		myElementList.add(ipnsignin);
		return myElementList;

	}
	
	/*
	@FindBy(id = "mockUsername")
	private WebElement ipnUsername;
	
	@FindBy(id = "mockPassword")
	private WebElement ipnPassword;
	
	*/
	
	@FindBy(id = "signin")
	private WebElement ipnsignin;
	
	/*
	
	public WebElement getUserName(){
		return ipnUsername;
	}
	
	public WebElement getPassword(){
		return ipnPassword;
	}
	
	*/
	
	public WebElement getSignInButton(){
		return ipnsignin;
	}
	
	/*
	
	public void setUsename(String userName){
		
		getUserName().sendKeys(userName);
		//WebElement s = ipnUsername;
		//s.sendKeys(userName);
	}
	
	public void setPassword(String passwd){
		
		getPassword().sendKeys(passwd);
	}
	
	*/
	
	public void clickSignInButton(){
		
		getSignInButton().click();
	}
	

}
