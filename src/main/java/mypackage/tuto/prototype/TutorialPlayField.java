package mypackage.tuto.prototype;

import java.awt.Frame;
import java.util.logging.Logger;

import mypackage.tuto.prototype.frame.PlayFieldFrame;
import mypackage.tuto.prototype.frame.PlayFieldFrame;

public class TutorialPlayField {

	private static Logger logger=Logger.getAnonymousLogger();
	static Frame frame= new PlayFieldFrame();
	public static void main(String[] args) {
		logger.info("Bonjour Olivia");
		frame.setVisible(true);
	}

}
