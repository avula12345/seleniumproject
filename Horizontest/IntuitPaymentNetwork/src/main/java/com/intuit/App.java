package com.intuit;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class App {
	
	protected WebDriver driver;
	
	
	
	public abstract List<WebElement> pageElementsToWait();
        
 }