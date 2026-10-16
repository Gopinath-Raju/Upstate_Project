package org.stepdefinition;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JvmReport {
	public static void generateJvmReport(String json) {
		File f = new File("C:\\Users\\gopin\\eclipse-workspace\\UpstateProject1\\Report\\Jvm");
		Configuration c = new Configuration(f, "Adactin");
		c.addClassifications("Employee Name", "Gopi");
		c.addClassifications("Employee Id", "12345");
		c.addClassifications("OS", "windows");
		List<String> l = new ArrayList<String>();
		l.add(json);

		ReportBuilder r = new ReportBuilder(l, c);
		r.generateReports();
		
	}
	
	public static void main(String[] args) {
		generateJvmReport("C:\\Users\\gopin\\eclipse-workspace\\UpstateProject1\\Report\\json\\Upstate.json");
	}

}
