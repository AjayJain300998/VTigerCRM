package CommonUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtil {

	public String getDataFromPropertyFile(String keyname) throws IOException {
		FileInputStream file = new FileInputStream("src\\test\\resources\\loginCredential.properties");
		Properties p = new Properties();
		p.load(file);
		String value = p.getProperty(keyname);
		
		return value;
	}
}
