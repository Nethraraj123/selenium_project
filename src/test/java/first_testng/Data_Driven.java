package first_testng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Data_Driven {

	WebDriver driver;
	@BeforeTest
	
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();//chromedriver is calling browser
		driver.get("https://the-internet.herokuapp.com/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@Test
	public void loginData() throws EncryptedDocumentException, IOException {
		
		WebElement username=driver.findElement(By.id("username"));
		
		WebElement password=driver.findElement(By.id("password"));
		
		//creating an object for inputstrea class
		
		FileInputStream file=new FileInputStream("C:\\QCCA22\\Arrays\\PART 3\\selenium_project\\src\\main\\resources\\Test_Data.xlsx");
		
		//createnew instace of workbook
		Workbook book=WorkbookFactory.create(file);
		
		//read the data from excel
		String usernamevalue=book.getSheet("Sheet1").getRow(4).getCell(0).getStringCellValue();
		
		String passwordvalue=book.getSheet("Sheet1").getRow(4).getCell(1).getStringCellValue();
		
		username.sendKeys(usernamevalue);
		password.sendKeys(passwordvalue);
		
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		book.close();//it will close the workbook instance
		
		//whenever leave the blank in our excel sheet
		
		
		
		
		
	}
	
	@AfterTest
	
	public void excite() {
		
		driver.close();
	}
	
	
	
}
