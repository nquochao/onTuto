package mypackage.tuto.prototype;

import java.util.logging.Logger;

public class Tutorial1 {

	private static Logger logger=Logger.getAnonymousLogger();
	static HaoTutotialFrame frame= new HaoTutotialFrame();
	public static void main(String[] args) {
		logger.info("Bonjour Olivia");
		frame.setVisible(true);
	}

}
