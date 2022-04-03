package com.fleetStudio.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fleetStudio.base.BrowserFactory;

public class ProductDev_GreenlightEnvironmentalMonitoringSystem extends BrowserFactory {
	public String productDevTxt;
	public String actualProductDevTxt;
	public String gemsTxt;
	public String acutalGEMSTxt;
	
	@FindBy(xpath = "//button/parent::li")
	protected List<WebElement> button;

	@FindBy(xpath = "(//span[text()='Product Dev']/parent::p)[1]")
	protected WebElement txt_productDev;

	@FindBy (xpath="(//p[text()='Greenlight™ Environmental Monitoring System'])[1]")
	protected WebElement txt_GEMS;
	
	@FindBy (xpath="(//a[text()='Read More '])[1]")
	protected WebElement btn_readMore;

	public ProductDev_GreenlightEnvironmentalMonitoringSystem() {
		PageFactory.initElements(driver, this);
	}

	public void verifyHeading() {
		productDevTxt = txt_productDev.getText();
		actualProductDevTxt = "Product Dev";
		gemsTxt = txt_GEMS.getText();
		acutalGEMSTxt = "Greenlight™ Environmental Monitoring System";

		
	}

}
