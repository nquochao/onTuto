package mypackage.tuto.prototype;

import java.util.logging.Logger;

import mypackage.tuto.prototype.frame.TutorialFrame;

public class Tutorial1 {

	private static Logger logger = Logger.getAnonymousLogger();
	static TutorialFrame frame = new TutorialFrame();

	public static void main(String[] args) {
		logger.info("Bonjour Moli");
		frame.setVisible(true);
	}

}
