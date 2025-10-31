package mypackage.tuto.prototype.frame;

import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;

import mypackage.tuto.prototype.beans.Chat;
import mypackage.tuto.prototype.panel.SelectionClanJPanel;

public class ImageFrame extends JFrame {
	private static Logger logger = Logger.getAnonymousLogger();
	public final static int DEFAULT_BUTTON_NUMBER = 4;
	Chat heros = new Chat();
	JPanel panel = new SelectionClanJPanel(this, heros);
	ImageFrame frame=this;

	public ImageFrame() {
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		// BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		// panel.setLayout(layout);
		frame.setContentPane(panel);
		setVisible(true);
	}

	@Override
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		super.setVisible(b);
		//frame.getContentPane().setVisible(b);

	}



}
