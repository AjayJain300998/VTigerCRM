package Page_Object_Model_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	//identufy create organizatio...(+)
	@FindBy(xpath="//img[@alt='Create Organization...']") 
	private WebElement createOrganization;

	public WebElement getCreateOrganization() {
		return createOrganization;
	}
	
	public OrganizationsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	//create a method
	public void organizations() {
		//click on Create Organization .. (+)
		createOrganization.click();
	}
	
	
}
