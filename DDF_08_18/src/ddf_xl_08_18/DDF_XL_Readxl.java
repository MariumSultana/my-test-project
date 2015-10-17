package ddf_xl_08_18;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DDF_XL_Readxl {

	WebDriver dr;
	String baseurl = "http://www.mortgagecalculator.com/";
	


	
	@BeforeClass
	public static void beforeClassstart(){
		System.out.println("the class execution will start");
	}
	@Before
	public void Start(){
		dr = new FirefoxDriver();
		dr.get(baseurl);
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Test
	public void testDDFXL() throws Throwable{
		String  vIntRate = "2.3";
		String vLoanAmt = "200,000";
		String vExpectedMPymt = "$1139.47";
		
	/*	System.out.println("interest rate"+ vIntRate );
		System.out.println(MCFActualMPymt(vExpectedMPymt ));
		System.out.println(" expected monthly payment " +vExpectedMPymt );
		MCFValues( vIntRate,  vLoanAmt);*/
		String xPath;
		xPath = "/Users/Maisha/Documents/Bithi/ReadXL.xls";
		System.out.println("read start");
	String[] [] xlFile = readxl(xPath, "TestData");
	System.out.println("read ended");
		
		
		
	}
	public void MCFValues(String fIntRate, String fLoanAmt){
		dr.findElement(By.xpath("//select[@id='sh_type']/option[2]")).click();
		dr.findElement(By.xpath("//input[@id='mpc_interest_rate']")).clear();
		dr.findElement(By.xpath("//input[@id='mpc_interest_rate']")).sendKeys(fIntRate);
		dr.findElement(By.xpath("//input[@id='mpc_loan_amount']")).clear();
		dr.findElement(By.xpath("//input[@id='mpc_loan_amount']")).sendKeys(fLoanAmt);
		dr.findElement(By.xpath("//div[@id='mortgagePaymentCalc_go_div']/div/input")).click();
	}
	
	public String MCFActualMPymt(String fExpectedMPymt ){
		String vActualMPymt;
		vActualMPymt =  dr.findElement(By.xpath("//span[@id='mortgagePaymentCalc_amount']")).getText();
		System.out.println("actual  monthly payment "+ vActualMPymt);
		if(vActualMPymt.equals(fExpectedMPymt )){
			return "pass";
			
		}else{
			return "fail";
			
		}
	}
	public String[][] readxl(String fPath, String fsheet) throws Throwable{
		String[][] myData;
		int xRow;
		int xCol;
		File myxl = new File(fPath);
		FileInputStream myStream = new FileInputStream(myxl);
		HSSFWorkbook myWB = new HSSFWorkbook(myStream);
		HSSFSheet myWS = myWB.getSheet(fsheet);
		 xRow= myWS.getLastRowNum()+1;
		 xCol= myWS.getRow(0).getLastCellNum();
		 System.out.println("rows"+xRow);
		 System.out.println("column"+xCol);
		 myData = new String[xRow][xCol];
		 for(int i=0; i<xRow; i++){
			 HSSFRow row = myWS.getRow(i);
			 for(int j = 0; j<xCol; j++){
				 HSSFCell cell = row.getCell(j);
				 String value = "-";
				 if(cell!=null){
					 value = cellToString(cell);
				 }
				 myData[i][j] = value;
				 System.out.print("the value is "+ value);
				 System.out.print("----");
			 }
			 System.out.println("");
		 }
		 return myData;
		
	}
	public static String cellToString(HSSFCell cell){
		int type;
		Object result;
		type = cell.getCellType();
		switch(type){
		case 0 : //numeric values in Excel
			result = cell.getNumericCellValue();
			break;
		case 1: //string value in Excel
			result = cell.getStringCellValue();
			break;
			default :
				throw new RuntimeException("there are no support of this cell to string convesito mehtod");
				}
		return result.toString();
	}
	@After
	public void End(){
		dr.quit();
		System.out.println("browser quit");
	}
	@AfterClass
	public static void afterClassend(){
		System.out.println("the class execution is ended");
	}
}

