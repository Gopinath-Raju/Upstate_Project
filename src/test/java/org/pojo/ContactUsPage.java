package org.pojo;

import org.helper.BaseCls1;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends BaseCls1{


    public ContactUsPage() {
    	PageFactory.initElements(driver.get(), this);
    }
    
    @FindBy(xpath="(//a[text()='Contact Us'])[1]")
    private WebElement contactUs;
    
    @FindBy(xpath="//iframe[contains(@src,'google.com/maps/embed')]")
    private WebElement mapFrame;
    
    @FindBy(tagName = "body")
    private WebElement mapContent;
    
    @FindBy(xpath="//input[@name='wpforms[fields][0]']")
    private WebElement name;

    @FindBy(xpath="//input[@name='wpforms[fields][3]']")
    private WebElement phone;
   
    @FindBy(xpath="//input[@name='wpforms[fields][1]']")
    private WebElement email;
  
    @FindBy(xpath="//textarea[@name='wpforms[fields][2]']")
    private WebElement message;
    
    @FindBy(id="wpforms-219-field_4_1")
    private WebElement consentCheckbox;
    
    @FindBy(id="wpforms-submit-219")
    private WebElement sendButton;
    
  

    public WebElement getContactUs() {
		return contactUs;
	}

	public WebElement getMapFrame() {
		return mapFrame;
	}

	public WebElement getMapContent() {
		return mapContent;
	}

	public WebElement getName() {
		return name;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getMessage() {
		return message;
	}

	public WebElement getConsentCheckbox() {
		return consentCheckbox;
	}

	public WebElement getSendButton() {
		return sendButton;
	}

	public boolean areFieldsDisplayed() {
        return name.isDisplayed()
            && phone.isDisplayed()
            && email.isDisplayed()
            && message.isDisplayed();
    }
    
    public void enterName(String value) {
        name.sendKeys(value);
    }

    public void enterPhone(String value) {
        phone.sendKeys(value);
    }

    public void enterEmail(String value) {
        email.sendKeys(value);
    }

    public void enterMessage(String value) {
        message.sendKeys(value);
    }


    public String getNameValue() {
        return name.getAttribute("value");
     }

    public String getPhoneValue() {
        return phone.getAttribute("value");
    }

    public String getEmailValue() {
        return email.getAttribute("value");
    }

    public String getMessageValue() {
        return message.getAttribute("value");
    }



    public void selectConsentCheckbox() {
        if (!consentCheckbox.isSelected()) {
            consentCheckbox.click();
        }
    }

    public boolean isConsentSelected() {
        return consentCheckbox.isSelected();
    }

    public boolean isSendButtonDisplayed() {
        return sendButton.isDisplayed();
    }

}



