package org.stepdefinition;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.helper.BaseCls1;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pojo.BillingPage;
import org.pojo.ContactUsPage;
import org.pojo.HomePage;
import org.pojo.ProviderPage;
import org.pojo.ServicePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions extends BaseCls1{
	WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
	
	public StepDefinitions() {
	    h = new HomePage();
	    p = new ProviderPage();
	    b = new BillingPage();
	    s = new ServicePage();
	    c = new ContactUsPage();
	}
	
	@Given("user opens the Upstate Medical Associates website")
	public void user_opens_the_upstate_medical_associates_website() {
		 if (h.getSurveyFrame().isDisplayed()) {
		        driver.get().switchTo().frame(h.getSurveyFrame());
		        h.getCloseSurvey().click();
		        driver.get().switchTo().defaultContent();
		    }
	}
	@When("user need to verify page title")
	public void user_need_to_verify_page_title() {
		String title = driver.get().getTitle();
		System.out.println("Page Title : "+ title);
		String expectedTitle = ("Healthcare Provider in Seneca, SC | Upstate Medical Associates P.A.");
		Assert.assertEquals(title, expectedTitle);
		Assert.assertTrue(h.getHomeBtn().isDisplayed(), "Home link is not displayed");
	}
	@When("user clicks the contact number section")
	public void user_clicks_the_contact_number_section()  {
	    h.getContactNo().click();
	    
    
	}
	@Then("user should be able to dismiss the alert")
	public void user_should_be_able_to_dismiss_the_alert() throws InterruptedException, AWTException {
		Thread.sleep(3000);
	    Robot robot = new Robot();
	    robot.delay(1000);

	    // Press Tab 2 times to reach Cancel
	    for (int i = 0; i < 2; i++) {
	        robot.keyPress(KeyEvent.VK_TAB);
	        robot.keyRelease(KeyEvent.VK_TAB);
	        robot.delay(300);
	    }

	    // Press Enter to select Cancel
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	@When("user clicks the Leave A Review link")
	public void user_clicks_the_leave_a_review_link() {
	   h.getReviewBtn().click();
	}
	@When("user switches to the review window")
	public void user_switches_to_the_review_window() {
		String parWin = driver.get().getWindowHandle();
		Set<String> allWind = driver.get().getWindowHandles();
		
		for (String wind : allWind) {
			if (!wind.equals(parWin)) {
				driver.get().switchTo().window(wind);
			}
		}
	}
	@When("user clicks the Contact Directly button")
	public void user_clicks_the_contact_directly_button() {
	    h.getContactDirectly().click();
	}
	@When("user filled all the fields")
	public void user_filled_all_the_fields() {
	    h.getTextBox().sendKeys("Hi, Selenium");
	    h.getAssisted().click();
	    h.getOptions().click();
	    h.getName().sendKeys("Gopi");
	    h.getEmail().sendKeys("Gopi@gmail.com");
	    h.getCheckBox().click();
	    System.out.println(h.getSubmitBtn().isDisplayed());
	}
	@Then("the review form fields should contain the entered values")
	public void the_review_form_fields_should_contain_the_entered_values() {
	    Assert.assertEquals(getAttribute(h.getTextBox()), "Hi, Selenium");
	    Assert.assertEquals(getAttribute( h.getName()), "Gopi");
	    Assert.assertEquals(getAttribute( h.getEmail()), "Gopi@gmail.com");
	    
	}
	
	@When("user clicks the Providers link")
	public void user_clicks_the_providers_link() {
		Assert.assertTrue(p.getProviders().isDisplayed(), "Providers link is not displayed");
		p.getProviders().click();
	}
	@Then("the Providers page URL should contain {string}")
	public void the_providers_page_url_should_contain(String string) {
		wait.until( ExpectedConditions.urlContains("meet-our-providers"));
		Assert.assertTrue(driver.get().getCurrentUrl().contains("meet-our-providers"), "Providers page did not open");
	}
	
	@When("user navigates to the Providers page")
	public void user_navigates_to_the_providers_page() {
		Assert.assertTrue(p.getProviders().isDisplayed(), "Providers link is not displayed");
		p.getProviders().click();
	}
	@Then("the provider name {string} should be displayed")
	public void the_provider_name_should_be_displayed(String name) {

    WebElement provider = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[self::h2 or self::h3 or self::h4][normalize-space()='" + name + "']")));
    Assert.assertTrue(provider.isDisplayed(),name + " is not displayed");
    System.out.println("Provider displayed: " + provider.getText());
   }
	
	@When("user clicks the Billing link")
	public void user_clicks_the_billing_link() {
	   b.getBilling().click();
	}
	@Then("the Billing Information page should open")
	public void the_billing_information_page_should_open() {
		Assert.assertTrue(driver.get().getCurrentUrl().contains("billing-information"), "Billing page did not open");
	}
	
	@When("user navigates to the Billing Information page")
	public void user_navigates_to_the_billing_information_page() {
		 b.getBilling().click();
		Assert.assertTrue(driver.get().getCurrentUrl().contains("billing-information"), "Billing page did not open");
	}
	@Then("the description for {string} should be displayed")
	public void the_description_for_should_be_displayed(String string) {
		Assert.assertTrue( b.getFee().isDisplayed(),string + " is not displayed");
	   System.out.println( b.getFee().getText());
	}
	@Then("the description should be {string}")
	public void the_description_should_be(String string) {
		Assert.assertTrue( b.getFee().isDisplayed(),string + " is not displayed");
	}
	
	@When("user clicks the Services menu")
	public void user_clicks_the_services_menu() {
		Assert.assertTrue(s.getServices().isDisplayed(), "Services link is not displayed");
		Actions a1 = new Actions(driver.get());
		a1.moveToElement(s.getServices()).perform();
		
	}
	@When("user clicks General Healthcare")
	public void user_clicks_general_healthcare() {
		Actions a1 = new Actions(driver.get());
		a1.moveToElement(s.getGenHealth()).click().build().perform();
	}
	@Then("General Healthcare page should open")
	public void general_healthcare_page_should_open() {
		wait.until(ExpectedConditions.urlContains("general-healthcare"));
		Assert.assertTrue(driver.get().getCurrentUrl().contains("general-healthcare"),"General Healthcare page did not open");
	}
	
	@Given("user navigate to FAQs section")
	public void user_navigate_to_fa_qs_section() {
		 Actions a1 = new Actions(driver.get());
		   WebElement third = s.getFAQs().get(2);
		   a1.moveToElement(third).perform();
		
	}
	@When("user clicks the third FAQ")
	public void user_clicks_the_third_faq() {
		 s.getFAQs().get(2).click();
	}
	@Then("the third FAQ answer should be displayed")
	public void the_third_faq_answer_should_be_displayed() {
		Assert.assertTrue(s.getAnswers().get(2).isDisplayed(),"FAQ answer is not displayed");
	}
	
	@When("user clicks Contact Us")
	public void user_clicks_contact_us() {
	   c.getContactUs().click();
	}
	@When("Contact Us page should open")
	public void contact_us_page_should_open() {
		wait.until(ExpectedConditions.urlContains("contact-us"));
		Assert.assertTrue(driver.get().getCurrentUrl().contains("contact-us"),"Contact Us page did not open");
	}
	@Then("Google Map should be displayed")
	public void google_map_should_be_displayed() {
		
		driver.get().switchTo().frame(c.getMapFrame());
		c.getMapContent().click();
		SoftAssert s= new SoftAssert();
		s.assertTrue(c.getMapContent().isDisplayed(),"Map not displayed");
		driver.get().switchTo().defaultContent();
	   
	}
	
	@Given("user is on the Contact Us page")
	public void user_is_on_the_contact_us_page() {
		c.getContactUs().click();
		Assert.assertTrue(driver.get().getCurrentUrl().contains("contact-us"),"Contact Us page did not open");
	}
	
	@When("user navigate through Contact us fields")
	public void user_navigate_through_contact_us_fields() {
		wait.until(ExpectedConditions.elementToBeClickable(c.getName()));
		JavascriptExecutor js = (JavascriptExecutor)driver.get();
		js.executeScript("arguments[0].scrollIntoView();", c.getName());
	    
	}
	@Then("Name field should be displayed")
	public void name_field_should_be_displayed() {
		Assert.assertTrue(c.getName().isDisplayed(), "Name field is not displayed");
	}
	@Then("Phone field should be displayed")
	public void phone_field_should_be_displayed() {
		Assert.assertTrue(c.getPhone().isDisplayed(), "Phone field is not displayed");
	}
	@Then("Email field should be displayed")
	public void email_field_should_be_displayed() {
		Assert.assertTrue(c.getEmail().isDisplayed(), "Email field is not displayed");
	}
	@Then("Message field should be displayed")
	public void message_field_should_be_displayed() {
		Assert.assertTrue(c.getMessage().isDisplayed(), "Message field is not displayed");
	}
	@Then("Privacy checkbox should be displayed")
	public void privacy_checkbox_should_be_displayed() {
		Assert.assertTrue(c.getConsentCheckbox().isDisplayed(), "Checkbox field is not displayed");
	}
	@When("user enters name, phone, email, mesaage fields")
	public void user_enters_name_phone_email_mesaage_fields() {
		c.getContactUs().click();
	    c.getName().sendKeys("Gopi");
	    c.getPhone().sendKeys("1234567890");
		c.getEmail().sendKeys("gopi@gmail.com");
		c.getMessage().sendKeys("Hi, Selenium");
	}
	@When("user selects the privacy checkbox")
	public void user_selects_the_privacy_checkbox() {
	    c.getConsentCheckbox().click();
	}
	@Then("entered form details should be correct")
	public void entered_form_details_should_be_correct() {
		Assert.assertEquals(c.getName().getAttribute("value"),"Gopi");
		Assert.assertEquals(c.getPhone().getAttribute("value"),"(123) 456-7890");
		Assert.assertEquals(c.getEmail().getAttribute("value"),"gopi@gmail.com");
		Assert.assertEquals(c.getMessage().getAttribute("value"),"Hi, Selenium");
	
	}

}


