package Page_Object_Model_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtils.WebDriverUtil;

public class CreatingNewOrganizationPage extends WebDriverUtil{

	WebDriverUtil wutil = new WebDriverUtil();
	//Identify Organizations name
	@FindBy(name="accountname")
	private WebElement Organizationsname;

	public WebElement getOrganizationsname() {
		return Organizationsname;
	}
	
	//Identify radio button
	@FindBy(xpath = "(//input[@name=\"assigntype\"])[2]")
	private WebElement grpbtn;

	public WebElement getGrpbtn() {
		return grpbtn;
	}
	
	//identify group drop down
	@FindBy(name = "assigned_group_id")
	private WebElement dropdown;

	public WebElement getDropdown() {
		return dropdown;
	}
	
	//identify save button
	@FindBy(xpath="(//input[@name=\"button\"])[1]")
	private WebElement savebtn;

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public CreatingNewOrganizationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	//create a method
	public void organaizationInformation(String orgnameData, String grpData) {
		//To enter Organization name
		Organizationsname.sendKeys(orgnameData);
		
		//click on group radio button
		grpbtn.click();
		
		//select support group in the drop-down
		wutil.selectByDropdown(dropdown, grpData);
		
		savebtn.click();
		
		
	}
	
	
	
	
	
	
	
}
