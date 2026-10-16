package org.pojo;

import java.util.List;

import org.helper.BaseCls1;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServicePage extends BaseCls1 {
	public ServicePage() {
    	PageFactory.initElements(driver.get(), this);
    }
	
	@FindBy(xpath = "(//a[text()='Services'])[1]")
	 private WebElement services;
	
	@FindBy(xpath = "(//li[@id='menu-item-1414'])[1]")
	 private WebElement genHealth;
	
	@FindBy(xpath = "//h5[@class='et_pb_toggle_title']")
	 private List<WebElement> FAQs;
	
	@FindBy(xpath = "//div[@class='et_pb_toggle_content clearfix']")
	 private List<WebElement> answers;

	public WebElement getServices() {
		return services;
	}

	public WebElement getGenHealth() {
		return genHealth;
	}

	public List<WebElement> getFAQs() {
		return FAQs;
	}

	public List<WebElement> getAnswers() {
		return answers;
	}
}
