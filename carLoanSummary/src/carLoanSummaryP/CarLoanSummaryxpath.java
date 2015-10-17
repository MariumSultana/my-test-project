package carLoanSummaryP;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CarLoanSummaryxpath {
	WebDriver dr;
	String baseurl, vPurprice, vDpymt, vTinvalue;
	//String xpPurprice, xpDpymt, xpTinvalue, xpCalcu;
	
	
	@Before
	public void start(){
		baseurl="http://www.onlineloancalculator.org/";
	
		
		
		dr = new FirefoxDriver();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dr.manage().window().maximize();
	
	}
		@Test
		public void carlTest(){
			//xpPurprice="//input[@name='param[principal]']";
			vPurprice = "30000";
			//xpDpymt="//input[@name='param[down_payment]']";
			vDpymt="2500";
			//xpTinvalue="//input[@name='param[trade_in_value]']";
			vTinvalue="15000";
			//xpCalcu="//td[@id='calculate_btn']/input";
			dr.get(baseurl);
			dr.findElement(By.xpath("//input[@name='param[principal]']")).clear();
			dr.findElement(By.xpath("//input[@name='param[principal]']")).sendKeys(vPurprice);
			/*dr.findElement(By.xpath("//input[@name='param[down_payment]']")).clear();
			dr.findElement(By.xpath("//input[@name='param[down_payment]']")).sendKeys(vDpymt);
			dr.findElement(By.xpath("//input[@name='param[trade_in_value]']")).clear();
			dr.findElement(By.xpath("//input[@name='param[trade_in_value]']")).sendKeys(vTinvalue);
			dr.findElement(By.xpath("//td[@id='calculate_btn']/input")).click();
			String amonthpymt = dr.findElement(By.xpath("(//h3)[1]")).getText();
			String ATof72pmt = dr.findElement(By.xpath("(//h3)[2]")).getText();
			System.out.println(" actual monthly payment "+ amonthpymt);
			System.out.println(" actual total of 72 payments "+ ATof72pmt);
		*/
	}
	@After
	public void end(){
		dr.quit();
	}

}