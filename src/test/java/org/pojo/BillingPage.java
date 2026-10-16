package org.pojo;

import org.helper.BaseCls1;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillingPage extends BaseCls1 {
	public BillingPage() {
    	PageFactory.initElements(driver.get(), this);
    }
	
	@FindBy(xpath = "//ul[@id='top-menu']//child::li[@id='menu-item-1263']")
	 private WebElement billing;
	
	@FindBy(xpath = "//td[normalize-space()='$25.00 – Prescription Fee']/following-sibling::td[1]")
	 private WebElement fee;

	public WebElement getBilling() {
		return billing;
	}

	public WebElement getFee() {
		return fee;
	}
	
	
}
