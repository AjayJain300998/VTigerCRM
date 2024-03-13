package Page_Object_Model_POM;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage {

	
	//identufy create contacats...(+)
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement contact;

	public WebElement getContact() {
		return contact;
	}

	
	
	

	
	
	
}
