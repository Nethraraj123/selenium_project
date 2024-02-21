package first_testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Orange_Test {
	
	WebDriver driver;
	
	
	@BeforeTest
	
	public void setUp() {
		WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();//chromedriver is calling browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
	}
	
	@Test
	
	public void login() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
	
	
	@Test
	
	public void leaveOptionForDate() {
		driver.findElement(By.xpath("//span[text()='Leave']//ancestor::a[@class='oxd-main-menu-item']")).click();
		
		WebElement fromDate=driver.findElement(By.xpath("(//input[@placeholder='yyyy-dd-mm'])[1]"));
		fromDate.sendKeys("2024-02-12");
		
		WebElement toDate=driver.findElement(By.xpath("(//input[@placeholder='yyyy-dd-mm'])[2]"));
		toDate.sendKeys("2024-12-12");
		
		
	}
	
	@Test
	
	public void leaveStatus() {
		WebElement leaveStatus=driver.findElement(By.xpath("//div[text()='Select']"));
		
		Select select=new Select(leaveStatus);
		
		select.selectByVisibleText("Rejected");
		
	}
	@Test

	public void leaveType() {
		WebElement leaveType=driver.findElement(By.xpath("(//div[text()='-- Select --'])[1]"));
		
		Select select=new Select(leaveType);
		
		select.selectByVisibleText("CAN - Bereavement");

	}
	
	
	@Test
	
	public void employeeName() {
		WebElement emp_name=driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
		
		emp_name.sendKeys("Nethra");
	}
	
	
	
	
	
	
@Test

public void subUnit() {
	WebElement subUnit=driver.findElement(By.xpath("(//div[text()='-- Select --'])[2]"));
	
	Select select=new Select(subUnit);
	
	select.selectByVisibleText("Sales");
	
}

@Test

public void chechBox() {
	WebElement checkBox=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
	
	checkBox.click();
}
	
	
	

}
