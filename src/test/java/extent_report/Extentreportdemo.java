package extent_report;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extentreportdemo {
	
	
	  WebDriver driver;
	    ExtentReports extent;
	    ExtentTest test;
	    SoftAssert sf;
	    
	@org.testng.annotations.BeforeClass
	public void reportconfig() {   
	    
	    // Step 1 - Creat Extent Report Object and then use starttest().
	     //we just set the path to dowloaded our extent report file in this method
	    extent = new ExtentReports(System.getProperty("user.dir")+"/Firstreport.html");
	    
	    // this line defines we werw start reporting 
	    test= extent.startTest("ReportTesting"); // In start test , you can provide the name of test
	    
	     
	}
	    
	@BeforeMethod(alwaysRun = true)
	public void setup() {
	    System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver120\\chromedriver.exe");

	    
	     driver = new ChromeDriver();
	     
	    test.log(LogStatus.PASS, "browser opened successfully");
	    
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	    
 sf = new SoftAssert();
	    
	    
	    String Expectedtitle = "Practice Page";
	    
	    String actual =  driver.getTitle();
	    
	    // Hard assertions
	    Assert.assertEquals(Expectedtitle, actual);
	    
	    // Soft assertion
	    
	    sf.assertEquals(Expectedtitle, actual);
	    
	    test.log(LogStatus.PASS, "URL loaded successfully");
	    
	}
	@Test(groups = {"smoke"})
	public void textboxTest() throws InterruptedException {
	    
	WebElement option1 = driver.findElement(By.cssSelector("input[name='checkBoxOption1']"));
	     
	     option1.click();
	     
	     test.log(LogStatus.PASS, "clicked on the checkbox 1");
	    
	    WebElement textbox1 = driver.findElement(By.id("autocomplete"));
	    
	    
	    Thread.sleep(2000);
	    // interact with textbox - enter text using sendkeys
	    
	    textbox1.sendKeys("Hello Selenium");
	    
	    test.log(LogStatus.PASS, "Text entered successfully");
	    
	    //Assert.assertTrue(textbox1.isDisplayed());
	    Thread.sleep(2000);


	}

	@Test(groups = {"smoke"})
	public void SendkeysTest() throws InterruptedException {
	    
	    String text = "vijendra is tester of the day";
	    
	    WebElement textbox = driver.findElement(By.id("autocomplete"));

	    textbox.sendKeys("vijendra is tester of the day");
	    
	    
	    Thread.sleep(2000);
	    
	    if(textbox.getText().contains(text))         
	        test.log(LogStatus.PASS, "text entered successfully");

	    else
	        test.log(LogStatus.FAIL, "text not entered");

	        
	    
	    System.out.println(text);
	    
	    //Assert.assertEquals(actual, text);

	}


	@Test(groups = {"smoke"})
	public void dropdownTest() throws InterruptedException {
	    
	    WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
	    
	    //The objects of Select type can be initialized by passing the
	    //dropdown webElement as parameter to its constructor.
	    
	    
	    //Create a object of select class
	    
	    Select sel = new Select(dropdown);
	    
	    
	      for(int i=0;i<=3;i++) {
	      
	        sel.selectByIndex(i);
	        Thread.sleep(1000);
	        
	        boolean dropdownstatus = dropdown.isSelected();
	        
	        if(dropdownstatus)
	            test.log(LogStatus.PASS, " successfully");
	        else
	            test.log(LogStatus.FAIL, "Dropdown selection unsuccessful");
	        

	          
	      }

	      
	        test.log(LogStatus.PASS, " successfully");

	}
	@Test(groups = {"Regression"})
	public void checkboxTest() {
	    
	     List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
	     
	     
	     for (WebElement check : checkboxes) {
	         
	         check.click();
	        
	    }

	    test.log(LogStatus.PASS, " All the checks done successfully");

	}



	@AfterMethod(alwaysRun = true)
	public void teardown() {
	    
	    driver.close();

	    
	}



	@AfterClass
	public void endtest() {
	    
	    // We are instructing the report to stop the reporting at this line of code.
	    
	    extent.endTest(test);
	    extent.flush();
	    
	    
	}


	}




