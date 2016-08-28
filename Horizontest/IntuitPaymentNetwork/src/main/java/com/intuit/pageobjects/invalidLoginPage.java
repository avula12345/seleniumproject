package com.intuit.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.intuit.App;

public class invalidLoginPage extends App {
	
	/*
	public invalidLoginPage(WebDriver driver) {
		super(driver);
	}
	*/
	
	@Override
	public List<WebElement> pageElementsToWait() {
		List<WebElement> myElementList = new ArrayList<WebElement>();

		myElementList.add(signInButton);
		myElementList.add(cancelButton);
		return myElementList;

	}
	
	@FindBy(xpath = ".//*[@id='formLogin']/div[3]/input")
	private WebElement signInButton;
	
	@FindBy(xpath = ".//*[@id='formLogin']/div[3]/a/img")
	private WebElement cancelButton;
	
	@FindBy(xpath = ".//*[@id='regcontents']/div[1]/div/div[1]/div[2]/div")
	private WebElement errorMessage;
	
	public WebElement getSignInButton(){
		return signInButton;
	}
	
	public WebElement getCancelButton(){
		return cancelButton;
	}
	
	public WebElement getErrorMessage(){
		return errorMessage;
	}
	
	public void clickCancelButton(){
		
		getCancelButton().click();
	}

	public String getMessage(){
		
		String errorMessage = getErrorMessage().getText();
		return errorMessage;
	}
	

}
