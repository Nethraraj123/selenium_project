package data_driven_testing;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HerokuTesting_Dynamic_data {
	WebDriver driver;
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); // Initialize the ChromeDriver object
		driver.get("https://the-internet.herokuapp.com/login");
	    driver.manage().window().maximize();
	}
	
	@Test(dataProvider = "fetch")
	public void login_test(String userid,String passwordvalue) {
		
		WebElement user_name=driver.findElement(By.id("username"));
		WebElement password=driver.findElement(By.id("password"));
		user_name.clear();
		password.clear();
		
		user_name.sendKeys(userid);
		password.sendKeys(passwordvalue);
		
	}
	
	@DataProvider(name="fetch")
    public Object[][] fetch() throws EncryptedDocumentException, IOException {
		Extract_data data=new Extract_data();
		Object[][] result = data.readfile();
		return result;
		
	}
}