package testng_features;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window_Handle {
WebDriver driver;
    
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }
    @Test
    public void rahultest() throws InterruptedException {
        driver.findElement(By.linkText("Open Tab")).click();
        String parent = driver.getWindowHandle();
        Set<String> Alltabs = driver.getWindowHandles();
        String childTitle="QAClick Academy - A Testing Academy to Learn, Earn and Shine";
        
        for (String singleID : Alltabs) {
            driver.switchTo().window(singleID);
            if (driver.getTitle().equals(childTitle)) {
                break;
    
            }
        
        }
        //End of for loop
        driver.findElement(By.linkText("Courses")).click();
        Thread.sleep(1000);
//        driver.findElement(By.linkText("Blog")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.linkText("About us")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.linkText("Contact")).click();
    
    }
    
}

