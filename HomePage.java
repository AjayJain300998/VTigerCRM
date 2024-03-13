package Page_Object_Model_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtils.WebDriverUtil;

public class HomePage extends WebDriverUtil{
	
	//identify Organization
	@FindBy(xpath = "(//a[text()='Organizations'])[1]") private WebElement organization;
	
	//identify Contacts
	@FindBy(xpath = "//a[text()='Contacts']") private WebElement contacts;
	
	//identify mouse hover on image
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']") private WebElement img;
	
	//identify sign out
	@FindBy(xpath = "//a[text()='Sign Out']") private WebElement logoutbtn;

	public WebElement getOrganization() {
		return organization;
	}

	public WebElement getContacts() {
		return contacts;
	}

	public WebElement getImg() {
		return img;
	}

	public WebElement getLogoutbtn() {
		return logoutbtn;
	}
	
	//create  a constructor
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	public void home() {
		organization.click();
		
		
	}
	
	public void home(WebDriver driver) {
		//mouse hover on image
				mouseHover(driver, img);
				logoutbtn.click();
	}
	
	
}
