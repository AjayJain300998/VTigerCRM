package vtigerCRM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import CommonUtils.ExcelUtil;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;

public class Leads {
	PropertyFileUtil pfutil = new PropertyFileUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	ExcelUtil eutil = new ExcelUtil();

		@Test
		public void leads() throws IOException, InterruptedException {
			WebDriver driver = new ChromeDriver();
			wutil.maximize(driver);
			wutil.implicitwait(driver);
			
			//read data from propertyfile
			String URL = pfutil.getDataFromPropertyFile("Url");
			String USERNAME = pfutil.getDataFromPropertyFile("Username");
			String PASSWORD = pfutil.getDataFromPropertyFile("Password");
			
			//read data from Excel file
			String firstName = eutil.getDataFromExcel("Leads", 0, 1);
			String lastName = eutil.getDataFromExcel("Leads", 1, 1);
			String comapanyName = eutil.getDataFromExcel("Leads", 3, 1);
			
			//launch the application
			driver.get(URL);
			
			//enter user name and password
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			
			//click on login button
			driver.findElement(By.id("submitButton")).click();
			
			//click on LEADS
			driver.findElement(By.xpath("//a[text()='Leads']")).click();
			
			//click on create leads-----> "+" sign
			driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
			
			//Enter first name, last name & company name
			driver.findElement(By.name("firstname")).sendKeys(firstName);
			driver.findElement(By.name("lastname")).sendKeys(lastName);
			driver.findElement(By.name("company")).sendKeys(comapanyName);
			
			//click on GROUP radio button & select Marketing Group in dropdown
			driver.findElement(By.cssSelector("input[value='T']")).click();
			WebElement dropdown = driver.findElement(By.xpath("(//select[@class='small'])[8]"));
			wutil.selectByDropdown(dropdown, "Marketing Group");
			
			//click on save button
			driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
			
			Thread.sleep(3000);
			//move to cursor administrator and click on sign out
			WebElement icon = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
			wutil.mouseHover(driver, icon);
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();			
		}
}
