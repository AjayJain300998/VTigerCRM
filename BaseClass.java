package CommonUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	public WebDriver driver = new ChromeDriver();
	
	
	WebDriverUtil wd = new WebDriverUtil();
	PropertyFileUtil pf = new PropertyFileUtil();
	
	@BeforeSuite
	public void bs() {
		System.out.println("Connect to Data Base");
	}
	
	@BeforeClass
	public void bc() throws IOException {
		
		//@BeforeClass is used to launch the application
		
		//TO launch the empty browser
//		WebDriver driver = new ChromeDriver();
		
		//To maximize the window
		wd.maximize(driver);
		
		//To apply wait for findelement()
		wd.implicitwait(driver);
		
		//TO read data from PropertyFileUtil
		String URL = pf.getDataFromPropertyFile("Url");
		
		//To launch the application
		driver.get(URL);
	}
	
	@BeforeMethod
	public void bm() throws IOException {
		//@BeforeMethod is used to login to  the application
		
		//TO read data from PropertyFileUtil
		String USERNAME = pf.getDataFromPropertyFile("Username");
		String PASSWORD = pf.getDataFromPropertyFile("Password");
		
		
		//To login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
	}
	
	@AfterSuite
	public void as() {
		System.out.println("Disconnect for Data Base");
	}
	
	@AfterClass
	public void ac() {
		//@AfterClass is to close the broser
		
		driver.quit();
	}
	
	@AfterMethod
	public void am() throws InterruptedException {
		//@AfterMethod is used to logout from the application
		
		
		Thread.sleep(3000);
		//mouse hover to signout
		WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		
		wd.mouseHover(driver, img);
		
		//click on sign out
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}
