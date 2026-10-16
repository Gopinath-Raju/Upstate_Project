package org.stepdefinition;



import java.time.Duration;

import org.helper.BaseCls1;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pojo.BillingPage;
import org.pojo.ContactUsPage;
import org.pojo.HomePage;
import org.pojo.ProviderPage;
import org.pojo.ServicePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseCls1 {
	
	@Before(order = 0)
    public void browserSetup() {
        openEdge();
        pageUrl("https://upstatemed.com/");
        maxWin();
        impWaits(10);
    }
	
	@Before(order = 1)
	public void setupPages() {
	    h = new HomePage();
	    p = new ProviderPage();
	    b = new BillingPage();
	    s = new ServicePage();
	    c = new ContactUsPage();

	    wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
	}
	
	@After
	public void close(Scenario s) {
		
		if (s.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot)driver.get();
			byte[] sc = ts.getScreenshotAs(OutputType.BYTES);
			 System.out.println("Screenshot captured: " + sc.length + " bytes");
			s.attach(sc, "image/png", s.getName());
			 System.out.println("Screenshot attached");
		}
		
		closeTheBrowser();
		}

}
