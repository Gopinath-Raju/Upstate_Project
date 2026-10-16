package org.pojo;

import java.util.List;

import org.helper.BaseCls1;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseCls1 {
	public HomePage() {
		PageFactory.initElements(driver.get(), this);
	}
	
//	@FindBy(className = "lazyautosizes lazyloaded")
//	private WebElement upstateLogo;	
//	
//	@FindBy(xpath  = "lazyautosizes lazyloaded")
//	private WebElement contactNo;	
	@FindBy(id = "survey-frame")
	private WebElement surveyFrame;
	
	
	@FindBy(id = "bl_survey_closebutton")
	private WebElement closeSurvey;
	
	@FindBy(xpath = "//div[@class='secondary-links']")
	private WebElement contactNo;
	
	@FindBy(xpath = "//a[text()='Leave A Review']")
	private WebElement reviewBtn;
	
	@FindBy(id = "contactBtn")
	private WebElement contactDirectly;
	
	@FindBy(id = "review__comments__pos")
	private WebElement textBox;
	
	@FindBy(id = "review__employee_list_select")
	private WebElement assisted;
	
	public WebElement getAssisted() {
		return assisted;
	}

	@FindBy(xpath = "//li[text()='Connor Evans']")
	private WebElement options;
	
	@FindBy(id = "reviewer__nickName")
	private WebElement name;
	
	@FindBy(id = "reviewer__emailId")
	private WebElement email;
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitBtn;
	
	public WebElement getReviewBtn() {
		return reviewBtn;
	}

	public WebElement getContactDirectly() {
		return contactDirectly;
	}

	public WebElement getTextBox() {
		return textBox;
	}

	public WebElement getOptions() {
		return options;
	}

	public WebElement getName() {
		return name;
	}

	public WebElement getCheckBox() {
		return checkBox;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getEmail() {
		return email;
	}

	@FindBy(id = "review__canBeContacted")
	private WebElement checkBox;

	@FindBy(xpath = "//a[text()=' Patient Portal']")
	private WebElement patientPortal;	
	
	@FindBy(id = "userwayAccessibilityIcon")
	private WebElement accessibilityMenuBtn;
	
	@FindBy(xpath = "(//a[text()='Home'])[1]")
	private WebElement homeBtn;	
	
	@FindBy(xpath = "(//a[text()='Providers'])[1]")
	private WebElement providerBtn;
	
	@FindBy(xpath = "(//a[text()='Services'])[1]")
	private WebElement servicesBtn;	
	
	@FindBy(xpath = "(//a[text()='GENERAL HEALTHCARE'])[1]")
	private WebElement genHealth;	
	
	@FindBy(xpath = "(//a[text()='OCCUPATIONAL HEALTH'])[1]")
	private WebElement occpHealth;
	
	@FindBy(xpath = "(//a[text()='LABORATORY SERVICES'])[1]")
	private WebElement labSrvc;
	
	@FindBy(xpath = "(//a[text()='Billing'])[1]")
	private WebElement billBtn;
	
	@FindBy(xpath = "(//a[text()='Contact Us'])[1]")
	private WebElement contactBtn;
	
	public WebElement getBillBtn() {
		return billBtn;
	}

	public WebElement getContactBtn() {
		return contactBtn;
	}

	// All FAQ questions
    @FindBy(xpath = "//h5[@class='et_pb_toggle_title']")
    private List<WebElement> faqQuestions;

    // All FAQ answers
    @FindBy(xpath = "//div[contains(@class,'et_pb_toggle_content')]")
    private List<WebElement> faqAnswers;

	
	public List<WebElement> getFaqQuestions() {
		return faqQuestions;
	}

	public List<WebElement> getFaqAnswers() {
		return faqAnswers;
	}

//	public WebElement getUpstateLogo() {
//		return upstateLogo;
//	}
//
//	public WebElement getContactNo() {
//		return contactNo;
//	}

	public WebElement getPatientPortal() {
		return patientPortal;
	}

	public WebElement getAccessibilityMenuBtn() {
		return accessibilityMenuBtn;
	}

	public WebElement getHomeBtn() {
		return homeBtn;
	}

	public WebElement getProviderBtn() {
		return providerBtn;
	}

	public WebElement getServicesBtn() {
		return servicesBtn;
	}

	public WebElement getGenHealth() {
		return genHealth;
	}

	public WebElement getOccpHealth() {
		return occpHealth;
	}

	public WebElement getLabSrvc() {
		return labSrvc;
	}

	public WebElement getAesthetics() {
		return aesthetics;
	}
	
	public WebElement getSurveyFrame() {
		return surveyFrame;
	}

	public WebElement getCloseSurvey() {
		return closeSurvey;
	}
	
	public WebElement getContactNo() {
		return contactNo;
	}

	@FindBy(xpath = "(//a[text()='AESTHETICS'])[1]")
	private WebElement aesthetics;
	
	

	public void clickFAQ(int index) {
    faqQuestions.get(index).click();
}

	

}
