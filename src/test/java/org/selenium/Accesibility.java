package org.selenium;

import java.time.Duration;
import org.helper.BaseCls1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Accesibility extends BaseCls1 {
	public static void main(String[] args) {
		openEdge();
		pageUrl("https://upstatemed.com/");
		maxWin();
		impWaits(10);
		
		WebElement accesBtn = driver.get().findElement(By.xpath("//img[@role='presentation']"));
		accesBtn.click();
		WebElement frame1 = driver.get().findElement(By.xpath("//iframe[@class='uwif userway_p1']"));
		driver.get().switchTo().frame(frame1);
		WebElement widgetBtn = driver.get().findElement(By.xpath("//label[@class='uwaw-switcher__input-label']"));
		WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(widgetBtn)).click();
		
		WebElement contrastBtn = driver.get().findElement(By.id("btn-s3"));
		int min = 1; int max =4;
		while (min<=max) {
			contrastBtn.click();
			min++;
			}
		WebElement highlightBtn = driver.get().findElement(By.id("btn-s6"));
		highlightBtn.click(); 	
		WebElement textSizeBtn = driver.get().findElement(By.id("btn-s3"));
		int mini = 1; int maxi =4;
		while (mini<=maxi) {
			textSizeBtn.click();
			mini++;
			}
		WebElement textSpace = driver.get().findElement(By.id("btn-s14"));
		int ini = 1; int fin =3;
		while (ini<=fin) {
			textSpace.click();
			ini++;
			}
		WebElement pauseAnimation = driver.get().findElement(By.id("btn-s13"));
		pauseAnimation.click(); 
		WebElement hideImg = driver.get().findElement(By.id("btn-s25"));
		hideImg.click(); 
		WebElement fontStyle = driver.get().findElement(By.id("btn-s7"));
		fontStyle.click(); 
		WebElement cursorStyle = driver.get().findElement(By.id("btn-s2"));
		cursorStyle.click(); 
		WebElement toolTips = driver.get().findElement(By.id("btn-s12"));
		toolTips.click(); 
		WebElement lineHeight = driver.get().findElement(By.id("btn-s17"));
		lineHeight.click(); 
		WebElement textAllign = driver.get().findElement(By.id("btn-s19"));
		textAllign.click();
		WebElement saturation = driver.get().findElement(By.id("btn-s23"));
		saturation.click();
		WebElement moveAndHideWidget = driver.get().findElement(By.id("btn-s8"));
		moveAndHideWidget.click(); 
		WebElement resetAll = driver.get().findElement(By.id("btn-s8"));
		resetAll.click(); 
		
		WebElement accesCloseBtn = driver.get().findElement(By.className("uwaw-header__close"));
		accesCloseBtn.click();
		

		
	}
	

}
