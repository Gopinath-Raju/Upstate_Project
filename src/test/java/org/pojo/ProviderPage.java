package org.pojo;

import org.helper.BaseCls1;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProviderPage extends BaseCls1 {
	
	 public ProviderPage() {
	    	PageFactory.initElements(driver.get(), this);
	    }
	 
	 @FindBy(xpath = "(//a[text()='Providers'])[1]")
	 private WebElement providers;

	 public WebElement getProviders() {
		 return providers;
	 }
	 
	 

}
