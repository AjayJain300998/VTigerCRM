package vtigerCRM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import CommonUtils.ExcelUtil;
import CommonUtils.JavaUtil;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;

public class OrganizationTestNG extends BaseClass {
	

	
	PropertyFileUtil pf = new PropertyFileUtil();
	WebDriverUtil wd = new WebDriverUtil();
	ExcelUtil eu = new ExcelUtil();
	JavaUtil ju = new JavaUtil();
	
	
	
	@Test
	public void OrganizationsTest() throws IOException, InterruptedException {
//		WebDriver driver = new ChromeDriver();
//		
//		//To maximize the window
//		wd.maximize(driver);
//		
//		//To apply wait for findelement()
//		wd.implicitwait(driver);
		
		//TO read data from PropertyFileUtil
//		String URL = pf.getDataFromPropertyFile("Url");
//		String USERNAME = pf.getDataFromPropertyFile("Username");
//		String PASSWORD = pf.getDataFromPropertyFile("Password");
		
		//to read dara from excel file
		String ORGNAME = eu.getDataFromExcel("ORGANIZATIONS", 0, 1);
		String GROUP = eu.getDataFromExcel("ORGANIZATIONS", 1, 1);
		
		//To launch the application
//		driver.get(URL);
		
//		//To login to application
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		//click on organization
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		//click on + sign
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		
		//click on Organization Name tf & enter the company name
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME+ju.getRandomNumber());
		
		//in assignto click on group
		driver.findElement(By.cssSelector("input[value='T']")).click();
		
		//in dropdown select Support Group
		WebElement supportGroup = driver.findElement(By.xpath("(//select[@class='small'])[6]"));
//		Select s= new Select(supportGroup);
//		s.selectByVisibleText(GROUP);
//		========OR==========
		wd.selectByDropdown(supportGroup, GROUP);
		
		
		//click on save button
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		
		
		
//		Thread.sleep(3000);
//		//mouse hover to signout
//		WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
////		Actions a = new Actions(driver);
////		a.moveToElement(img);
////		a.perform();
////		==============OR===============
//		wd.mouseHover(driver, img);
//		
//		//click on sign out
//		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
}
}
