package mypackage.tuto.prototype;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HaoTutotialFrame extends JFrame {
	private static Logger logger = Logger.getAnonymousLogger();
	private static final String INSTRUCTION="Choisis ton Clan";
	HaoJButton bJouer = new HaoJButton("Jouer");
	public final static int DEFAULT_BUTTON_NUMBER = 4;
	HaoJButtons buttons = new HaoJButtons();

	Boolean started = false;
	JPanel panel = new JPanel();
	JLabel labelInstruct= new JLabel(INSTRUCTION);

	public HaoTutotialFrame() {
		//BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		//panel.setLayout(layout);
		this.setContentPane(panel);
		panel.setLayout(new GridBagLayout());

		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		GridBagConstraints cs = new GridBagConstraints();
		cs.fill = GridBagConstraints.HORIZONTAL;
		cs.gridx = 0;
		cs.gridy = 0;
		logger.info("x, y: " + cs.gridx + " , " + cs.gridy + " " + "Jouer");
		bJouer.setPreferredSize(new Dimension(800, 400));
		panel.add(bJouer, cs);



		initClansButtons();
		this.setVisible(true);


		bJouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bJouerPressed();
			}

			private void bJouerPressed() {
				started = !started;

				event();

			}
		});
	}

	private void initClansButtons() {
		GridBagConstraints cs = new GridBagConstraints();
		cs.fill = GridBagConstraints.HORIZONTAL;
		cs.gridx = 0;
		cs.gridy = 0;
		logger.info("x, y: " + cs.gridx + " , " + cs.gridy + " " + "Instructions");
		panel.add(labelInstruct, cs);
		labelInstruct.setVisible(started);

		
		for (ClansExistants e : ClansExistants.values()) {
			HaoJButton b = new HaoJButton(e.getNom());
			try {
				URL url=getClass().getResource("/chat.png");
			    Image img = ImageIO.read(url);
			    b.setIcon(new ImageIcon(img));
			  } catch (Exception ex) {
				  logger.info(ex.getMessage());
			  }
			
			buttons.add(b);
			b.setPreferredSize(new Dimension(400, 300));
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = (int) e.ordinal() % 2;
			c.gridy = 1+(int) Math.floor(e.ordinal() / 2);
			logger.info("x, y: " + c.gridx + " , " + c.gridy + " " + e.getNom());

			panel.add(b, c);

		}

	}

	@Override
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		super.setVisible(b);
		bJouer.setVisible(b);


	}

	public void event() {
		buttons.setVisible(started);
		labelInstruct.setVisible(started);



		bJouer.setVisible(!started);

	}

}
