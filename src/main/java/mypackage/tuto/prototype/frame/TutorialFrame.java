package mypackage.tuto.prototype.frame;

import java.awt.Dimension;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import mypackage.tuto.prototype.beans.Chat;
import mypackage.tuto.prototype.panel.StartPanel;

public class TutorialFrame extends JFrame {
	private static Logger logger = Logger.getAnonymousLogger();
	public final static int DEFAULT_BUTTON_NUMBER = 4;
	Chat heros = new Chat();
	StartPanel panel = new StartPanel(this, heros);
	TutorialFrame frame=this;

	public TutorialFrame() {
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		panel.show();
		setVisible(true);
	}

	@Override
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		super.setVisible(b);
		frame.getContentPane().setVisible(b);

	}



}
