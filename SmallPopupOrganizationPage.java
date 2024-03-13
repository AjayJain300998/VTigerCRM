package Page_Object_Model_POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SmallPopupOrganizationPage {

	@FindBy(id = "search_txt") private WebElement seartf;
	
	@FindBy(xpath = "(//input[@name='search'])[1]") private WebElement searchbtn;

	@FindBy(xpath = "//a[text()='Qspiders']") private WebElement cname;

	public WebElement getSeartf() {
		return seartf;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getCname() {
		return cname;
	}

	
	
}
