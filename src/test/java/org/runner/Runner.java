package org.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (features = "C:\\Users\\gopin\\eclipse-workspace\\UpstateProject1\\src\\test\\resources\\Features", glue = "org.stepdefinition",
dryRun = false, plugin = {"pretty",
						"html:C:\\Users\\gopin\\eclipse-workspace\\UpstateProject1\\Report\\Html\\Upstate.html",
						 "junit:C:\\Users\\gopin\\eclipse-workspace\\UpstateProject1\\Report\\Junit\\Upstate.xml",
						 "json:C:\\Users\\gopin\\eclipse-workspace\\UpstateProject1\\Report\\json\\Upstate.json",
						 
})
public class Runner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		// TODO Auto-generated method stub
		return super.scenarios();
	}

}
