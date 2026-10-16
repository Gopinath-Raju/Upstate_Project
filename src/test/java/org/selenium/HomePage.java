package org.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
	public static void main(String[] args) throws AWTException {
		WebDriver web = new EdgeDriver();
		web.get("https://upstatemed.com/");
		web.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(web, Duration.ofSeconds(10));
		
		
		//HomePage
		WebElement surveyFrame = web.findElement(By.id("survey-frame"));
		web.switchTo().frame(surveyFrame);
		WebElement closeSurvey = web.findElement(By.id("bl_survey_closebutton"));
		closeSurvey.click();
		web.switchTo().defaultContent();
		
		String title = web.getTitle();
		System.out.println("Page Title : "+ title);
		String expectedTitle = ("Healthcare Provider in Seneca, SC | Upstate Medical Associates P.A.");
		Assert.assertEquals(title, expectedTitle);
		
		WebElement HomeBtn = web.findElement(By.xpath("(//a[text()='Home'])[1]"));
		Assert.assertTrue(HomeBtn.isDisplayed(), "Home link is not displayed");
		
		//Click on contact no and handle the alert
				WebElement contactNo = web.findElement(By.xpath("//div[@class='secondary-links']"));
				contactNo.click();
				Alert a = web.switchTo().alert();
				a.dismiss();
				
				//Leave a review
				WebElement reviewBtn = web.findElement(By.xpath("//a[text()='Leave A Review']"));
				reviewBtn.click();
				
				//Switch to next page
				String parWin = web.getWindowHandle();
				Set<String> allWind = web.getWindowHandles();
				
				for (String wind : allWind) {
					if (!wind.equals(parWin)) {
						web.switchTo().window(wind);
					}
				}
				
				//Click contact us and enter values
				WebElement contactDirectly = web.findElement(By.id("contactBtn"));
				wait.until(ExpectedConditions.elementToBeClickable(contactDirectly)).click();
				
				WebElement textBox = web.findElement(By.id("review__comments__pos"));
				textBox.sendKeys("Hi, Selenium");
				
				WebElement assisted = web.findElement(By.id("review__employee_list_select"));
				assisted.click();
				
				WebElement options = web.findElement(By.xpath("//li[text()='Connor Evans']"));
				options.click();
				
				WebElement name = web.findElement(By.id("reviewer__nickName"));
				name.sendKeys("Gopi");
				
				WebElement email = web.findElement(By.id("reviewer__emailId"));
				email.sendKeys("Gopi@gmail.com");
				
				WebElement checkBox = web.findElement(By.id("review__canBeContacted"));
				checkBox.click();
				
				WebElement submitBtn = web.findElement(By.xpath("//button[text()='Submit']"));
				System.out.println(submitBtn.isDisplayed());
				
				
		//Provider Page
		WebElement providers = web.findElement(By.xpath("(//a[text()='Providers'])[1]"));
		Assert.assertTrue(providers.isDisplayed(), "Providers link is not displayed");
		providers.click();
		
		wait.until( ExpectedConditions.urlContains("meet-our-providers"));
		Assert.assertTrue(web.getCurrentUrl().contains("meet-our-providers"), "Providers page did not open");
		
			//Checking provider names
			String[] expectedNames = {"Jared Richardson, MD",
			                           "Nancy Smith, FNP-C",
			                           "Jessica Jones, PA-C",
			                            "Ali Lawing, FNP-C"};	
			for (String name2 : expectedNames) {

			    WebElement provider = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[self::h2 or self::h3 or self::h4][normalize-space()='" + name2 + "']")));
			    Assert.assertTrue(provider.isDisplayed(),name2 + " is not displayed");
			    System.out.println("Provider displayed: " + provider.getText());
			}
			System.out.println("All provider names validated successfully");
		
		
		//Billing page
		
		WebElement billing = web.findElement(By.xpath("//ul[@id='top-menu']//child::li[@id='menu-item-1263']"));
		billing.click();
		
		    //getting value from webtable
		     WebElement fee = web.findElement(By.xpath("//td[normalize-space()='$25.00 – Prescription Fee']/following-sibling::td[1]"));
		     String text = fee.getText();
		     System.out.println(text);
		
		
	
		
		//Services Page
		WebElement services = web.findElement(By.xpath("(//a[text()='Services'])[1]"));
		Assert.assertTrue(services.isDisplayed(), "Services link is not displayed");
		Actions a1 = new Actions(web);
		a1.moveToElement(services).perform();
		WebElement genHealth = web.findElement(By.xpath("(//li[@id='menu-item-1414'])[1]"));
		a1.moveToElement(genHealth).click().build().perform();
		wait.until(ExpectedConditions.urlContains("general-healthcare"));
		Assert.assertTrue(web.getCurrentUrl().contains("general-healthcare"),"General Healthcare page did not open");
		
		List<WebElement> FAQs = web.findElements(By.xpath("//h5[@class='et_pb_toggle_title']"));
		List<WebElement> answers = web.findElements(By.xpath("//div[@class='et_pb_toggle_content clearfix']"));
		FAQs.get(2).click();
		Assert.assertTrue(answers.get(2).isDisplayed(),"FAQ answer is not displayed");
		
			
		//Contact us Page
		WebElement contactUs = web.findElement(By.xpath("(//a[text()='Contact Us'])[1]"));
		contactUs.click();
		wait.until(ExpectedConditions.urlContains("contact-us"));
		Assert.assertTrue(web.getCurrentUrl().contains("contact-us"),"Contact Us page did not open");
		
		// Find Google Map iframe
		WebElement mapFrame = web.findElement(By.xpath("//iframe[contains(@src,'google.com/maps/embed')]"));

		// Switch into iframe
		web.switchTo().frame(mapFrame);

		// Map content area click
		WebElement mapContent = web.findElement(By.tagName("body"));
		mapContent.click();

		// Switch back to main page
		web.switchTo().defaultContent();

		System.out.println("Map iframe click completed");
		
		//Contact us form and fill all fields
		
		WebElement name1 = web.findElement(By.xpath("//input[@name='wpforms[fields][0]']"));
		WebElement phone = web.findElement(By.xpath("//input[@name='wpforms[fields][3]']"));
		WebElement email1 = web.findElement(By.xpath("//input[@name='wpforms[fields][1]']"));
		WebElement commentBox = web.findElement(By.xpath("//textarea[@name='wpforms[fields][2]']"));
		WebElement checkBox1 = web.findElement(By.xpath("//input[@id='wpforms-219-field_4_1']"));
		
		Assert.assertTrue(name1.isDisplayed(), "Name field is not displayed");
		Assert.assertTrue(phone.isDisplayed(), "Phone field is not displayed");
		Assert.assertTrue(email1.isDisplayed(), "Email field is not displayed");
		Assert.assertTrue(commentBox.isDisplayed(), "Message field is not displayed");
		
		
		name1.sendKeys("Gopi");
		phone.sendKeys("1234567890");
		email1.sendKeys("gopi@gmail.com");
		commentBox.sendKeys("Hi, Selenium");
		
		Assert.assertEquals(name.getAttribute("value"),"Gopi");
		Assert.assertEquals(phone.getAttribute("value"),"(123) 456-7890");
		Assert.assertEquals(email.getAttribute("value"),"gopi@gmail.com");
		Assert.assertEquals(commentBox.getAttribute("value"),"Hi, Selenium");

		Assert.assertTrue(checkBox1.isDisplayed(), "Checkbox field is not displayed");
		Assert.assertFalse(checkBox1.isSelected(),"Checkbox is already selected");
		checkBox1.click();
		Assert.assertTrue(checkBox1.isSelected(),"Checkbox was not selected");
		
//		email.clear();
//		Assert.assertEquals(email.getAttribute("value"),"");
		
		
//		WebElement previousBtn = web.findElement(By.xpath("//span[text()='Previous']"));
		
		
//		Robot r = new Robot();
//		r.keyPress(KeyEvent.VK_END);
//		r.keyRelease(KeyEvent.VK_END);
//		

//
//
//		WebElement scroll = web.findElement(By.xpath("//div[@class='et_pb_row et_pb_row_2']"));
//		JavascriptExecutor js = (JavascriptExecutor)web;
//		js.executeScript("arguments[0].scrollIntoView();", scroll);

//		a.moveToElement(scroll).perform();
//		js.executeScript("arguments[0].click();", previousBtn);
//		

//		
//		r.keyPress(KeyEvent.VK_HOME);
//		r.keyRelease(KeyEvent.VK_HOME);
//		
//		providers.click();
//		
//		WebDriverWait wait = new WebDriverWait(web, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.urlContains("meet-our-providers"));
//		
//		WebElement servicesTop = web.findElement(By.xpath("(//li[@id='menu-item-1264'])[1]"));

//		


//		
//		List<WebElement> servicesFaqs = web.findElements(By.xpath("//h5[@class='et_pb_toggle_title']"));
//		servicesFaqs.get(10).click();
//		

//		
//		WebElement patPort = web.findElement(By.xpath("//a[text()='Patient Portal']"));
//		patPort.click();
//		
//		Set<String> allWin = web.getWindowHandles();
//		List<String> l = new ArrayList<String>();
//		l.addAll(allWin);
//		web.switchTo().window(l.get(0));
//		

//		


//		WebElement sendBtn = web.findElement(By.xpath("//button[@id='wpforms-submit-219']"));
//		
		
	}

}
