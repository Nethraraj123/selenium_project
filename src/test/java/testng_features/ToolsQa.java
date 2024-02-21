package testng_features;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolsQa {
	

	WebDriver driver;
	
	WebDriverWait wait;
	@BeforeMethod(alwaysRun = true)
	
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();//chromedriver is calling browser
		driver.get("https://demoqa.com/elements");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.manage().window().maximize();
		
	}
	
	
	@Test
	
	public void text_Box() {
		driver.findElement(By.xpath("//span[text()='Text Box']")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Nethra R");
		
		
		
	}
	
	@Test
	
	public void button() {
		driver.findElement(By.xpath("//span[text()='Buttons']")).click();		
		
		WebElement double_click=driver.findElement(By.id("doubleClickBtn"));
		
		Actions action=new Actions(driver);
		
		action.doubleClick(double_click).build().perform();
		
		
	}


}
