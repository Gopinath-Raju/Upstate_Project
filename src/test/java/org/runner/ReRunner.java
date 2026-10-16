package org.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (features = "C:\\Users\\gopin\\eclipse-workspace\\UpstateProject1\\src\\test\\resources\\Features\\HomePage.feature", glue = "C:\\Users\\gopin\\eclipse-workspace\\UpstateProject1\\src\\test\\java\\org\\stepdefinition",
dryRun = true, plugin = {"pretty",
						"html:C:\\Users\\gopin\\eclipse-workspace\\UpstateProject1\\Report\\Html\\Upstate.html",
						 "junit:C:\\Users\\gopin\\eclipse-workspace\\UpstateProject1\\Report\\Junit\\Upstate.xml",
						 "json:C:\\Users\\gopin\\eclipse-workspace\\UpstateProject1\\Report\\json\\Upstate.json",
						 "rerun:C:\\Users\\gopin\\eclipse-workspace\\UpstateProject1\\Report\\ReRun\\rerun.txt"
						 
})
public class ReRunner extends AbstractTestNGCucumberTests {

}
