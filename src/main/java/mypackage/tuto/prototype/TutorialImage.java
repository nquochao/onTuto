package mypackage.tuto.prototype;

import java.awt.Frame;
import java.util.logging.Logger;

import mypackage.tuto.prototype.frame.HaoImageFrame;

public class TutorialImage {

	private static Logger logger=Logger.getAnonymousLogger();
	static Frame frame= new HaoImageFrame();
	public static void main(String[] args) {
		logger.info("Bonjour Olivia");
		frame.setVisible(true);
	}

}
