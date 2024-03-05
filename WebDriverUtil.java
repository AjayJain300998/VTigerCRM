package CommonUtils;



import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtil {

//	public WebDriver driver;
	
	public void maximize( WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void implicitwait( WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void selectByDropdown(WebElement element, String tergetedElement) {
		Select s = new Select(element);
		s.selectByVisibleText(tergetedElement);
	}
	
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element);
		a.perform();
	}
	
	public void switchWindow(WebDriver driver, String childUrl) {
		Set<String> ids = driver.getWindowHandles();
		
		for(String e : ids) {
			String actualUrl = driver.switchTo().window(e).getCurrentUrl();
			
			if(actualUrl.contains(childUrl)) {
				break;
			}
		}
	}
	
	public File screenshot(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File tempFile = ts.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("./Screenshot/"+screenshotName+".png");
		FileUtils.copyFile(tempFile, destinationFile);
		return destinationFile;
	}
	
	
	
	

}
