package vtigerCRM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonUtils.ExcelUtil;
import CommonUtils.JavaUtil;
import CommonUtils.ListenerImplementation;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;

@Listeners(ListenerImplementation.class)
public class ContactsTest {

	PropertyFileUtil pf = new PropertyFileUtil();
	WebDriverUtil wd = new WebDriverUtil();
	ExcelUtil eu = new ExcelUtil();
	JavaUtil ju = new JavaUtil();
	
	@Test
	public void contactsTest() throws IOException, InterruptedException {
		
		//To launch empty browser
		WebDriver driver = new ChromeDriver();
		
		//To maximize the window
		wd.maximize(driver);
				
		//To apply wait for findelement()
		wd.implicitwait(driver);
				
		//TO read data from PropertyFileUtil
		String URL = pf.getDataFromPropertyFile("Url");
		String USERNAME = pf.getDataFromPropertyFile("Username");
		String PASSWORD = pf.getDataFromPropertyFile("Password");
		
		
		//to read dara from excel file
		String firstName = eu.getDataFromExcel("Contacts", 0, 1);
		String lastName = eu.getDataFromExcel("Contacts", 1, 1);
		String group = eu.getDataFromExcel("Contacts", 2, 1);
		String orgname = eu.getDataFromExcel("Contacts", 3, 1)	;
		//To launch the application
		driver.get(URL);
		
		//To login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//click on contacts
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//click on create contact----> "+" Sign
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
		
		//enter the name & last name
		driver.findElement(By.name("firstname")).sendKeys(firstName);
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		//To fail the testscript
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing";
		Assert.assertEquals(actualUrl, expectedUrl);
		
		
		//click on organization name----> "+" Sign
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		
		//to transfer control main window to popup window
		wd.switchWindow(driver, "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
		
		//search the organization name
		driver.findElement(By.id("search_txt")).sendKeys(orgname);
		driver.findElement(By.cssSelector("input[class='crmbutton small create']")).click();
		
		//choose and click on organization name
		driver.findElement(By.xpath("//a[text()='Qspiders']")).click();
		
		//to transfer back to control popup window to main window
		wd.switchWindow(driver, "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
		
		//click on group radio button
		driver.findElement(By.cssSelector("input[value='T']")).click();
		
		//select team selling in dropdown
		WebElement dropDown = driver.findElement(By.name("assigned_group_id"));
		wd.selectByDropdown(dropDown, group);
		
		//to take screenshot of contact
		Thread.sleep(2000);
		wd.screenshot(driver, "Contacts");
//		//scroll down 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//		
//		//click on choose file
//		driver.findElement(By.name("id")).click();
		
		driver.findElement(By.xpath("(//input[@name='button'])[3]")).click();
		
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
		
		Thread.sleep(3000);
		WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wd.mouseHover(driver, img);
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
	}

}
