package CommonUtils;

import java.util.Random;

public class JavaUtil {

	public int getRandomNumber() {
		Random random = new Random();
		int number = random.nextInt(500);
		return number;
	}

}
