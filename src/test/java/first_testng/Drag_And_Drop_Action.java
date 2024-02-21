package first_testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drag_And_Drop_Action {
	
	WebDriver driver;
	
	@BeforeMethod                            
	
	public void setUp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
		driver.get("https://v1.training-support.net/selenium/drag-drop");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
	}
	
	@Test
	
	public void testDragAndDrop1() throws InterruptedException {
		 Actions action=new Actions(driver);
			
			//source and target element / drag and drop elements
			WebElement football=driver.findElement(By.id("draggable"));
			WebElement area=driver.findElement(By.id("droppable"));
			
			action.dragAndDrop(football, area).build().perform();
			
			Thread.sleep(2000);
			
		}
@Test
	
	public void testDragAndDrop2() throws InterruptedException {
        Actions action=new Actions(driver);
		
		//source and target element / drag and drop elements
		WebElement football=driver.findElement(By.id("draggable"));
		
		WebElement area=driver.findElement(By.id("dropzone2"));
		
		action.dragAndDrop(football, area).build().perform();
		
		Thread.sleep(2000);
		
		
	}
	
	@AfterMethod
	
public void exite() {
		
		driver.quit();
	}
	}


