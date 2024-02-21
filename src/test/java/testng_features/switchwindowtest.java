package testng_features;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class switchwindowtest {
    
    WebDriver driver;

    @BeforeTest
    public void setup() {
        
       WebDriverManager.chromedriver().setup();
        
         driver = new ChromeDriver();
         
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    
        driver.get("https://demo.automationtesting.in/Windows.html");
        
        driver.manage().window().maximize();

        
    }
    
    
    @Test
    public void switchtest() throws InterruptedException {
        
        driver.findElement(By.xpath("( //button[@class='btn btn-info'])[1]")).click();
        
        // Switch window from parent to child.
        
        
        String parent = driver.getWindowHandle();
        
        System.out.println(parent);
        
        Set<String> allhandles = driver.getWindowHandles();
        
        System.out.println(allhandles);
        
        String childWindowtitle="Selenium";
        
        // In for each loop , no need to initialize no need to increment
        for (String singleid : allhandles) {
                                                                // First iteration
                                                                    
                                                                //singleid - parentid
            driver.switchTo().window(singleid);
                                                        
            if(driver.getTitle().equals(childWindowtitle)) { // not equal , hence will 
                                                                //skip the if condition
                                                            // Second iteration - it will iterate 
                                                    // child id and switch happens to child id and then
                                                //title is equal to child , hence it enters if condn and breaks from 
                                                    //loop
                
                break;
                
            }
            
            
            
        }
        Thread.sleep(2000);
        
        
        // if switch is successful then it will click on Downloads.
        driver.findElement(By.linkText("Downloads")).click();
        
    }

}