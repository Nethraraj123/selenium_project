package testng_features;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Groups_testng {

	WebDriver driver;
	@BeforeMethod(alwaysRun = true)
	
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();//chromedriver is calling browser
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@Test(groups = "smoke")
	
	public void radio_button() {
		driver.findElement(By.xpath("//input[@value='radio1']")).click();
	}
	
	@Test(groups = "sanity")
	
	public void select_option() {
		
		WebElement option=driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		
		Select select = new Select(option);
		select.selectByVisibleText("Option1");
		
		
	}
	
	@Test(groups = "smoke")
	
	public void checkBox() {
		driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
	}
	
	@AfterMethod(alwaysRun = true)
	
	public void setdown() {
		driver.close();
	}
}
