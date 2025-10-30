package mypackage.tuto.prototype;

import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HaoTutotialFrame extends JFrame {
	private static Logger logger = Logger.getAnonymousLogger();
	public final static int DEFAULT_BUTTON_NUMBER = 4;
	Chat heros = new Chat();
	JPanel panel = new SelectionClanJPanel(this, heros);
	HaoTutotialFrame frame=this;

	public HaoTutotialFrame() {
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		// BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		// panel.setLayout(layout);
		this.setContentPane(panel);
	}

	@Override
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		super.setVisible(b);
		frame.getContentPane().setVisible(b);

	}



}
