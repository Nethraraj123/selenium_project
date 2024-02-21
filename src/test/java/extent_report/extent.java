package extent_report;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class extent {
    
	 WebDriver driver;
	    ExtentReports extent;
	    ExtentTest test;
	    SoftAssert sf;
	    
	    
	@org.testng.annotations.BeforeClass//excution stat from before class so that's why we adding these code inside beforeclass
	public void reportconfig() {   
	    
	    // Step 1 - Creat Extent Report Object and then use starttest().
	     //we just set the path to dowloaded our extent report file in this method
	    extent = new ExtentReports(System.getProperty("user.dir")+"/Firstreport.html");
	    
	    // this line defines we werw start reporting 
	    test= extent.startTest("ReportTesting"); // In start test , you can provide the name of test
	}
	    
    @BeforeMethod(alwaysRun = true)  //We have to add this line if its not added then driver window and went to execute test and throws null pointer exception
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Initialize the ChromeDriver object
        test.log(LogStatus.PASS, "URL loaded successfully");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        
	     sf = new SoftAssert();
	    
	    
	    String Expectedtitle = "Practice Page";
	    
	    String actual =  driver.getTitle();
	    System.out.println(Expectedtitle+" And "+actual);
	    
	    // Hard assertions
	    Assert.assertEquals(Expectedtitle, actual);
	    
	    // Soft assertion
	    
	    sf.assertEquals(Expectedtitle, actual);
        test.log(LogStatus.PASS, "URL loaded successfully");
        driver.manage().window().maximize();
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
    
    //Performing Test on Radio Button
    @Test(groups = {"smoke"})
    public void radio_button_test() {
        driver.findElement(By.name("radioButton")).click();
        
        test.log(LogStatus.PASS, "\"driver locate the radioButton");
    }
    
    @Test(groups= {"smoke"})
    public void textbox_test() {
        driver.findElement(By.id("autocomplete")).sendKeys("India");
        
        test.log(LogStatus.PASS, "driver locate the autocomplete");
    }
    
    @Test(groups = {"sanity"})
    public void checkbox_test() {
        driver.findElement(By.id("checkBoxOption1")).click();
        
        test.log(LogStatus.PASS, "driver locate the checkbox and  ckick on it");
    }
    
    @Test(groups = "sanity")
    public void checkbox_test2() {
        driver.findElement(By.id("checkBoxOption2")).click();
        
        test.log(LogStatus.PASS, "driver locate the checkbox and  ckick on it");
    }
    
    @AfterMethod(alwaysRun=true)
    public void teardown() {
        driver.close();
    }
    
    @AfterClass(alwaysRun = true)
    public void setdown() {
    	  // We are instructing the report to stop the reporting at this line of code.
        
        extent.endTest(test);
        extent.flush();
    }
    
    

}