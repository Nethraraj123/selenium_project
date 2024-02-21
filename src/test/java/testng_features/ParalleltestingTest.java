package testng_features;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ParalleltestingTest {
    
    WebDriver driver;
    
    WebDriver driver1;
    
    WebDriver driver3;
    
    
    
	
	@Test
    public void testChrome() throws InterruptedException {
        
    System.out.println("The thread ID for Chrome is "+ Thread.currentThread().getId());
    
    WebDriverManager.chromedriver().setup();
    
    driver = new ChromeDriver();
    
    driver.get("https://www.bstackdemo.com/");
    
    driver.manage().window().maximize();
    
    Thread.sleep(2000);
    
    driver.close();

    }
    
    
	
	@Test
    public void testFirefox() throws InterruptedException {
        
    System.out.println("The thread ID for Firefox is "+ Thread.currentThread().getId());
    
    WebDriverManager.chromedriver().setup();
    
    driver1 = new FirefoxDriver();
    
    driver1.get("https://www.bstackdemo.com/");
    
    driver1.manage().window().maximize();
    
    Thread.sleep(2000);
    driver1.findElement(By.linkText("Orders")).click();
    driver1.close();
  

    }
	@Test
    public void edge_browser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver3=new EdgeDriver();
        driver3.get("https://www.bstackdemo.com/");
        driver3.manage().window().maximize();
        Thread.sleep(2000);
        driver3.findElement(By.linkText("Orders")).click();
        
        driver3.close();
        
    }
    
    
   
    
    

}