package mypackage.tuto.prototype;

import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Tutorial1 {

	private static Logger logger = Logger.getAnonymousLogger();

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		JButton b1 = new JButton("Bonjour Olivia");
		frame.setSize(500, 500);
		frame.add(b1);
		b1.setSize(400, 400);
		b1.setVisible(true);
		frame.setVisible(true);
	}

}
