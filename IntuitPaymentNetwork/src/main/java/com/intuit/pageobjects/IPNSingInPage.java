package com.intuit.pageobjects;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.intuit.App;

public class IPNSingInPage extends App {
	
	@Override
	public List<WebElement> pageElementsToWait() {
		List<WebElement> myElementList = new ArrayList<WebElement>();

		myElementList.add(ipnUsername);
		myElementList.add(ipnPassword);
		myElementList.add(ipnsignin);
		return myElementList;

	}
	

	@FindBy(id = "ius-userid")
	private WebElement ipnUsername;
	
	@FindBy(id = "ius-password")
	private WebElement ipnPassword;
	
	@FindBy(id = "ius-sign-in-submit-btn")
	private WebElement ipnsignin;
	
	@FindBy(id = "ius-mfa-option-email")
	private WebElement getCodeRadioButton;
	
	@FindBy(id = "ius-mfa-options-submit-btn")
	private WebElement continueButton;
	
	@FindBy(id = "ius-mfa-confirm-code")
	private WebElement codeTextField;
	
	
	public WebElement getUserName(){
		return ipnUsername;
	}
	
	public WebElement getPassword(){
		return ipnPassword;
	}
	
	public WebElement getSignInButton(){
		return ipnsignin;
	}
	
	public WebElement getCodeRadioButton(){
		return getCodeRadioButton;
	}
	
	public WebElement getContinueButton(){
		return continueButton;
	}
	
	public WebElement getCodeTextField(){
		return codeTextField;
	}
	
	public void setUsename(String userName){
		
		getUserName().clear();
		getUserName().sendKeys(userName);
		//WebElement s = ipnUsername;
		//s.sendKeys(userName);
	}
	
	public void setPassword(String passwd){
		
		getPassword().clear();
		getPassword().sendKeys(passwd);
	}
	
	public void setConfirmCode(String code){
		
		getCodeTextField().clear();
		getCodeTextField().sendKeys(code);
	}
	
	
	public void clickSignInButton(){
		
		getSignInButton().click();
	}
	
	public void clickContinueButton(){
		
		getContinueButton().click();
	}

}
