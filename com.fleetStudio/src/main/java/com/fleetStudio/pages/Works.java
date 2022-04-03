package com.fleetStudio.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.fleetStudio.base.BrowserFactory;

public class Works extends BrowserFactory {
	@FindBy(xpath = "//a[@href=\"/\"]")
	private WebElement logo;

	@FindBy(xpath = "//div[text()='A Product Development Technology Company']")
	private WebElement header;

	@FindBy(xpath = "//a[@href='/about']")
	private WebElement aboutUslnk;
	
	@FindBy(xpath="//a[@href='/offerings']")
	private WebElement offeringslnk;
	
	@FindBy(xpath="//a[@href='/works']")
	private WebElement workslnk;
	
	@FindBy(xpath="//a[@href='/careers']")
	private WebElement careerslnk;
	
	@FindBy(xpath="//a[@href='/contact']")
	private WebElement contactslnk;
	
	

}
