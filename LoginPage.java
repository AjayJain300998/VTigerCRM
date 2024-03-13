package Page_Object_Model_POM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//identify username text feild
	@FindBy(name="user_name") private WebElement username;
	
	//identify password text feild
	@FindBy(name="user_password") private WebElement password; 
	
	//identify Login button
	@FindBy(id="submitButton")private WebElement loginBtn;

	public WebElement getUsername() {
		return username;
	}

	
	public WebElement getPassword() {
		return password;
	}

	
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Create a constructor - initialize webelement
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	//create a method
	public void login(String usernameData, String passwordData) {
		username.sendKeys(usernameData);
		password.sendKeys(passwordData);
		loginBtn.click();
		
	}
	

	
}

