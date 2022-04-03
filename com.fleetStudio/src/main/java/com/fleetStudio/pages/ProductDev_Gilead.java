package com.fleetStudio.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDev_Gilead {
	@FindBy (xpath="//button/parent::li")
	protected List<WebElement> button; 
}
