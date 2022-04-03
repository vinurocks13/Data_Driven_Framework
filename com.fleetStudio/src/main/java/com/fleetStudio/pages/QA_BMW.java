package com.fleetStudio.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QA_BMW {
	@FindBy (xpath="//button/parent::li")
	protected List<WebElement> button; 
}
