package extent_report;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertion {
	public class extentreportdemo {
	    
	    WebDriver driver;
	    ExtentReports extent;
	    ExtentTest test;
	    SoftAssert sf;
	    
	@BeforeMethod(alwaysRun = true)
	public void setup() {
	   WebDriverManager.chromedriver().setup();

	    
	     driver = new ChromeDriver();
	     
	    test.log(LogStatus.PASS, "browser opened successfully");
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/");

	    
	     sf = new SoftAssert();
	    
	    
	    String Expectedtitle = "Practice";
	    
	    String actual =  driver.getTitle();
	    
	    // Hard assertions
	    Assert.assertEquals(Expectedtitle, actual);
	    
	    // Soft assertion
	    
	    sf.assertEquals(Expectedtitle, actual);
	    
	    
	    test.log(LogStatus.PASS, "URL loaded successfully");
	    
	}
	@Test(groups = {"Regression"})
	public void checkboxTest() throws InterruptedException {
	    
	     List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
	     
	     
	     
	     for (WebElement check : checkboxes) {
	         
	         
	         boolean enablestatus = check.isEnabled();
	         
	          sf.assertTrue(enablestatus); // This assert will check whether the checkbox is enabled or not
	         check.click();
	         sf.assertTrue(check.isSelected()); // This assert will check if the checkbox is clicked or not
	          if(check.isSelected()) {
	              test.log(LogStatus.PASS, " individual checks done successfully");

	              
	          }
	          else
	              test.log(LogStatus.FAIL, "check box  not  clicked");

	         Thread.sleep(1000);
	        
	    }
	     

	    test.log(LogStatus.PASS, " All the checks done successfully");

	}
	@AfterMethod(alwaysRun = true)
	public void teardown() {
	    sf.assertAll();
	    driver.close();

	    
	}
	}
}



