package org.helper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pojo.BillingPage;
import org.pojo.ContactUsPage;
import org.pojo.HomePage;
import org.pojo.ProviderPage;
import org.pojo.ServicePage;

public class BaseCls1 {
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static Robot r;
	public static HomePage h;
	public static ProviderPage p;
	public static BillingPage b;
	public static ServicePage s;
	public static ContactUsPage c;
	public static WebDriverWait wait;
	
	
	public static void openEdge() {
		 driver.set(new EdgeDriver());
	}
	
	public static void openChrome() {
		 driver.set(new ChromeDriver());
	}
	
	public static void openFox() {
		driver.set(new FirefoxDriver());
	}
	
	public static void maxWin() {
		driver.get().manage().window().maximize();
	}
	
	public static void impWaits(int sec) {
		  driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	public static void pageUrl(String url) {
		driver.get().get(url);
	}
		
	public static void enterValue(WebElement ref, String value) {
		ref.sendKeys(value);
	}
	public static void clickBtn(WebElement ref) {
		ref.click();
	}
	
	public static void moveMouseTo(WebElement ref) {
		Actions a = new Actions(driver.get());
		a.moveToElement(ref).perform();
	}
	
	public static String getthecurrenturl() {
		return driver.get().getCurrentUrl();

	}
	
	public static void mouseClick() {
		Actions a = new Actions(driver.get());
		a.click().perform();
	}
	
	public static void screenShot(String name) throws IOException {
		TakesScreenshot ss = (TakesScreenshot)driver;
		File s1 = ss.getScreenshotAs(OutputType.FILE);
		File s2 = new File("C:\\Users\\gopin\\eclipse-workspace\\MavenInstallation\\Screenshot\\ss"+name+".png");
		FileUtils.copyFile(s1, s2);
	}
	
	public static void scroll(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", ele);
	}
	
	public static void jsClick(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", ele);
		
	}
	
	public static void jsSendKeys(WebElement ele, String value) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+value+"')", ele);
		
	}
	
	public static void enter() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static void copy() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}
	
	public static void paste() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}
	public static String getTheTitle() {
		return driver.get().getTitle();
	}
	public static String getDataFromExcel(String excelName, String sheetName, int rowNo, int cellNo) throws IOException {
		File f = new File("C:\\Users\\gopin\\eclipse-workspace\\\\GopiCucumber\\Excel\\"+excelName+".xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(fin);
		Sheet sh = book.getSheet(sheetName);
		Row r = sh.getRow(rowNo);
		Cell c = r.getCell(cellNo);
		String s1;
		if (c.getCellType()==1) {
			s1= c.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(c)) {
			Date d = c.getDateCellValue();
			SimpleDateFormat sim = new  SimpleDateFormat("dd-MMM-yy");
			s1 = sim.format(d);
		} else {
			double d = c.getNumericCellValue();
			long l = (long)d;
			s1 = String.valueOf(l);
		}
		return s1;

	}
	
	public static void WriteDataInNewFile(String excelName, String sheetName, int rowNo, int cellNo, String value) throws IOException {
		File f = new File("C:\\Users\\gopin\\eclipse-workspace\\\\GopiCucumber\\Excel\\"+excelName+".xlsx");
		Workbook book = new XSSFWorkbook();
		Sheet sh = book.createSheet(sheetName);
		Row r = sh.createRow(rowNo);
		Cell c = r.createCell(cellNo);
		c.setCellValue(value);
		FileOutputStream fo = new FileOutputStream(f);
		book.write(fo);
		
	}
	
	public static void WritingDataInExistingFile(String excelName, String sheetName, int rowNo, int cellNo, String value) throws IOException {
		File f = new File("C:\\Users\\gopin\\eclipse-workspace\\\\GopiCucumber\\Excel\\"+excelName+".xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(fin);
		Sheet sh = book.getSheet(sheetName);
		Row r = sh.getRow(rowNo);
		 if (r == null) {
		        r = sh.createRow(rowNo);
		    }
		Cell c = r.getCell(cellNo);
		if (c == null) {
	        c = r.createCell(cellNo);
	    }
		c.setCellValue(value);
		FileOutputStream fo = new FileOutputStream(f);
		book.write(fo);
		
	}
	
	public static void ModifyDataInExistingFile(String excelName, String sheetName, int rowNo, int cellNo, String value, String value1, String value2) throws IOException {
		File f = new File("C:\\Users\\gopin\\eclipse-workspace\\\\GopiCucumber\\Excel\\"+excelName+".xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(fin);
		Sheet sh = book.getSheet(sheetName);
		Row r = sh.getRow(rowNo);
		Cell c = r.getCell(cellNo);
		String s = String.valueOf(c);
		if (s.equals(value)) {
			c.setCellValue(value1);
		} else {
			c.setCellValue(value2);
		}
		FileOutputStream fo = new FileOutputStream(f);
		book.write(fo);
		
	}
	
	public static void WriteDataInNewFile(String excelName, String sheetName, String[][] data) throws IOException {

	    File f = new File("C:\\Users\\gopin\\eclipse-workspace\\\\GopiCucumber\\Excel\\" + excelName + ".xlsx");
	    Workbook book = new XSSFWorkbook();
	    Sheet sh = book.createSheet(sheetName);
	    for (int i = 0; i < data.length; i++) {
	        Row r = sh.createRow(i);
	        for (int j = 0; j < data[i].length; j++) {
	            Cell c = r.createCell(j);
	            c.setCellValue(data[i][j]);
	        }
	    }
	    FileOutputStream fo = new FileOutputStream(f);
	    book.write(fo);	    
	}
	
	public static void selectDropDwn(WebElement ref, String value) {
		Select s = new Select(ref);
		s.selectByVisibleText(value);

	}
	
	public static String getAttribute(WebElement ref) {
		
		String s = ref.getAttribute("value");
		return s;

	}
	
	public static void closeTheBrowser() {
		driver.get().close();
	}
	


}
