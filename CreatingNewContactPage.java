package Page_Object_Model_POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatingNewContactPage {
	
	@FindBy(name = "firstname") private WebElement firstName;
	
	public WebElement getFirstName() {
		return firstName;
	}
	
	@FindBy(name="lastname") private WebElement lastName;
	public WebElement getLastName() {
		return lastName;
	}
	
	@FindBy(xpath = "(//img[@alt='Select'])[1]") private WebElement orgName;
	public WebElement getOrgName() {
		return orgName;
	}
	
	@FindBy(xpath = "//input[@value='T']") private WebElement grpbtn;
	public WebElement getGrpbtn() {
		return grpbtn;
	}
	
	@FindBy(name="assigned_group_id") private WebElement drpdn;
	public WebElement getDrpdn() {
		return drpdn;
	}
	
	@FindBy(xpath = "(//input[@name='button'])[1]") private WebElement savebtn;
	public WebElement getSavebtn() {
		return savebtn;
	}

	

	
	
}
