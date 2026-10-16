package org.stepdefinition;

import java.time.Duration;

import org.helper.BaseCls1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pojo.ContactUsPage;
import org.pojo.HomePage;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepDefinition extends BaseCls1 {
	WebDriverWait wait;
    Actions actions;
    HomePage h;
    ContactUsPage c;
    
//	@Given("I open the Upstate Medical website")
//	public void i_open_the_upstate_medical_website() {
//		 wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
//	       actions = new Actions(driver.get());
//	       h = new HomePage();
//	       c = new ContactUsPage();
//	   
//	}
//	
//	@Given("I close the survey if it is displayed")
//	public void i_close_the_survey_if_it_is_displayed() {
//		WebElement surveyFrame = driver.get().findElement(By.id("survey-frame"));
//		driver.get().switchTo().frame(surveyFrame);
//		WebElement closeSurvey = driver.get().findElement(By.id("bl_survey_closebutton"));
//		closeSurvey.click();
//		driver.get().switchTo().defaultContent();
//	    
//	}
//	@Then("the home page title should be correct")
//	public void the_home_page_title_should_be_correct() {
//		System.out.println("Page Title : "+ getTheTitle());
//		String expectedTitle = ("Healthcare Provider in Seneca, SC | Upstate Medical Associates P.A.");
//		Assert.assertEquals(getTheTitle(), expectedTitle);
//	    
//	}
//	@Then("the main navigation links should be displayed")
//	public void the_main_navigation_links_should_be_displayed() {
//		Assert.assertTrue(h.getHomeBtn().isDisplayed(), "Home link is not displayed");
//		Assert.assertTrue(h.getProviderBtn().isDisplayed(), "Providers link is not displayed");
//		Assert.assertTrue(h.getServicesBtn().isDisplayed(), "Services link is not displayed");
//		
//	}
//	@When("I click the Providers link")
//	public void i_click_the_providers_link() {
//		Assert.assertTrue(h.getProviderBtn().isDisplayed(), "Providers link is not displayed");
//		h.getProviderBtn().click();
//	}
//	@Then("the Providers page should open")
//	public void the_providers_page_should_open() {
//		wait.until( ExpectedConditions.urlContains("meet-our-providers"));
//		Assert.assertTrue(driver.get().getCurrentUrl().contains("meet-our-providers"), "Providers page did not open");
//	}
//	@When("I hover over Services and click General Healthcare")
//	public void i_hover_over_services_and_click_general_healthcare() {
//		Assert.assertTrue(h.getServicesBtn().isDisplayed(), "Services link is not displayed");
//		Actions a = new Actions(driver.get());
//		a.moveToElement(h.getServicesBtn()).perform();
//		a.moveToElement(h.getGenHealth()).click().build().perform();
//	}
//	@Then("the General Healthcare page should open")
//	public void the_general_healthcare_page_should_open() {
//		wait.until(ExpectedConditions.urlContains("general-healthcare"));
//		Assert.assertTrue(driver.get().getCurrentUrl().contains("general-healthcare"),"General Healthcare page did not open");
//	}
//	@When("I click the third FAQ")
//	public void i_click_the_third_faq() {
//		h.clickFAQ(2);
//	}
//	@Then("the FAQ answer should be displayed")
//	public void the_faq_answer_should_be_displayed() {
//		Assert.assertTrue(h.getFaqAnswers().get(2).isDisplayed(),"FAQ answer is not displayed");
//	}
//	@When("I click the Billing link")
//	public void i_click_the_billing_link() {
//	   h.getBillBtn().click();
//	  
//	}
//	@Then("the Billing page should open")
//	public void the_billing_page_should_open() {
//		 wait.until(ExpectedConditions.urlContains("billing"));
//		 Assert.assertTrue(driver.get().getCurrentUrl().contains("billing"),"Billing page did not open");
//	    
//	}
//	@When("I click the Contact Us link")
//	public void i_click_the_contact_us_link() {
//		h.getContactBtn().click();
//	    
//	}
//	@Then("the Contact Us page should open")
//	public void the_contact_us_page_should_open() {
//		wait.until(ExpectedConditions.urlContains("contact-us"));
//		Assert.assertTrue(driver.get().getCurrentUrl().contains("contact-us"),"Contact Us page did not open");
//	}
//	@Then("all contact form fields should be displayed")
//	public void all_contact_form_fields_should_be_displayed() {
//		c.areFieldsDisplayed();
//	}
//	@When("I enter test data into the contact form")
//	public void i_enter_test_data_into_the_contact_form() {
//		c.enterName("Gopi");
//	   c.enterEmail("Gopi@gmail.com");
//	   	c.enterPhone("8529637418");
//	   	c.enterMessage("Hi, Selenium");
//	}
//	@Then("the entered form values should be correct")
//	public void the_entered_form_values_should_be_correct() {
//	    c.getNameValue();
//	    c.getEmailValue();
//	    c.getPhoneValue();
//	    c.getMessageValue();
//	}
//	@When("I select the consent checkbox")
//	public void i_select_the_consent_checkbox() {
//		c.selectConsentCheckbox();
//	    
//	}
//	@Then("the consent checkbox should be selected")
//	public void the_consent_checkbox_should_be_selected() {
//		c.isConsentSelected();
//	   
//	}

}
