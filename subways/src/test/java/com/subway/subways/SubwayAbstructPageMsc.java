package com.subway.subways;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SubwayAbstructPageMsc {
WebDriver dr;
@Test
public void subwayTest() throws InterruptedException{
	dr = new FirefoxDriver();
	dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//dr.get("http://www.subway.com/");
	dr.get("http://dhtmlx.com/docs/products/dhtmlxTree/");
	WebElement fromElement = dr.findElement(By.xpath("//span[@class='standartTreeRow'][contains(., 'Nancy Atherton')]"));
	WebElement toElement = dr.findElement(By.xpath("//div[@id='treebox2']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span[contains(., 'Bestsellers')]"));
	try{
	Actions action = new Actions(dr);
	Action dragDrop = action.dragAndDrop(fromElement, toElement).build();
	dragDrop.perform();
	}catch(NoSuchElementException e){
		e.printStackTrace();
	}
	
	Thread.sleep(5000);
	//click on menu and nutrition
	//click on feature product
	//click on subway card
	//click on manage your card
	//validate opens another window and validate Username (email address): is present 
	dr.quit();
}

public void dragAndDropby(){
	WebElement fromElement = dr.findElement(By.xpath(""));
Actions slider =  new Actions(dr)
.dragAndDropBy(fromElement, 20, 30);
slider.build().perform();

WebElement sourceElement = dr.findElement(By.xpath(""));
WebElement targetElement = dr.findElement(By.xpath(""));
Actions action =  new Actions(dr);
Action dragAndDrop = action.dragAndDrop(sourceElement, targetElement).build();
dragAndDrop.perform();

Actions actions = new Actions(dr);
Action dragdrops = actions.clickAndHold(sourceElement).moveToElement(targetElement).release(targetElement).build();
dragdrops.perform();
Select dropDown =  new Select(sourceElement);
dropDown.selectByVisibleText("");

	}
public void dragAndDrop(){
	WebElement sources=dr.findElement(By.xpath(""));
	Actions action = new Actions(dr);
	Action dragDrop = action.clickAndHold(sources).moveToElement(sources).release(sources).build();
	dragDrop.perform();
	Actions sliders = new Actions(dr)
	.dragAndDropBy(dr.findElement(By.xpath("")), 10, 6);
	sliders.build().perform();
	
}
}
