package GenericUtility;

import java.time.LocalDateTime;
/**
 * 
 * @author Randeep
 *
 */

public class JavaUtility {
	/**
	 * This method will capture system date and time and return
	 * @return System date and Time
	 */
	public String getSystemDateTime() {
		return LocalDateTime.now().toString().replace(":", "-");
	}

}
