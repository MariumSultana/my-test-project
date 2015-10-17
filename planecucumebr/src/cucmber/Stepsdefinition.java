package cucmber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepsdefinition {
	WebDriver dr;
	
	@Given("^The URL$")
	public void The_URL() throws Throwable {
		dr = new FirefoxDriver();
		dr.get("http://www.mortgagecalculator.org/");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	   System.out.println("The URL");
	}

	@When("^Click on link$")
	public void Click_on_link() throws Throwable {
		String Text = dr.findElement(By.xpath("//div[@class = 'rw-box button']/strong")).getText();
		 System.out.println("The text "+Text);
	}

	@Then("^Get Text$")
	public void Get_Text() throws Throwable {
		dr.quit();
		 System.out.println("browser closed");
	}



}
