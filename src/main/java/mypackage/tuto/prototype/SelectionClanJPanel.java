package mypackage.tuto.prototype;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelectionClanJPanel extends JPanel {
	private static Logger logger = Logger.getAnonymousLogger();
	HaoTutotialFrame frame;
	Chat heros;
	private static final String INSTRUCTION = "Choisis ton Clan";
	JLabel labelInstruct = new JLabel(INSTRUCTION);
	Boolean started = false;
	HaoJLabels buttons = new HaoJLabels();

	HaoJLabel bJouer;
public SelectionClanJPanel(HaoTutotialFrame fram, Chat chat) {
	this.setLayout(new GridBagLayout());
	GridBagConstraints cs = new GridBagConstraints();
	cs.fill = GridBagConstraints.HORIZONTAL;
	cs.gridx = 0;
	cs.gridy = 0;
	logger.info("x, y: " + cs.gridx + " , " + cs.gridy + " " + "Jouer");
	bJouer = new HaoJLabel("Jouer", "demo1.png", null);

	bJouer.setPreferredSize(new Dimension(800, 400));
	this.add(bJouer, cs);

	this.frame=fram;
	setLayout(new GridBagLayout());
	this.heros=chat;

	cs = new GridBagConstraints();
	cs.fill = GridBagConstraints.HORIZONTAL;
	cs.gridx = 0;
	cs.gridy = 0;
	logger.info("x, y: " + cs.gridx + " , " + cs.gridy + " " + "Jouer");
	initClansButtons();
	addEvent(buttons);
	addEventJouer();
	buttons.setVisible(started);
	setVisible(true);

}

private void addEvent(HaoJLabels labels) {
	for (HaoJLabel label: labels) {

	label.addMouseListener(new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			heros.setType(label.getImage());
			SelectionChatJPanel panel = new SelectionChatJPanel(frame, heros);
			frame.setContentPane(panel);
			frame.setVisible(true);


		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	});	
}
}
private void showLabels(HaoJLabels labels) {
	int i=0;
	for (HaoJLabel label: labels) {

		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = (int) i % 2;
		c.gridy = 1 + (int) Math.floor(i / 2);
		logger.info("x, y: " + c.gridx + " , " + c.gridy + " " + label.getName());

		this.add(label, c);
		i++;

	}

	}

	



private void initClansButtons() {
	GridBagConstraints cs = new GridBagConstraints();
	cs.fill = GridBagConstraints.HORIZONTAL;
	cs.gridx = 0;
	cs.gridy = 0;
	logger.info("x, y: " + cs.gridx + " , " + cs.gridy + " " + "Instructions");
	this.add(labelInstruct, cs);
	labelInstruct.setVisible(started);

	for (ClansExistants e : ClansExistants.values()) {
		HaoJLabel b = new HaoJLabel(e.getNom(), e.getImage(), e);

		buttons.add(b);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = (int) e.ordinal() % 2;
		c.gridy = 1 + (int) Math.floor(e.ordinal() / 2);
		logger.info("x, y: " + c.gridx + " , " + c.gridy + " " + e.getNom());

		add(b, c);
		b.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				heros.setClan(b.getClan());
				SelectionChatJPanel panel = new SelectionChatJPanel(frame, heros);
				frame.setContentPane(panel);
				frame.setVisible(true);


			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

	}

}
public void addEventJouer(){
bJouer.addMouseListener(new MouseListener() {

	private void bJouerPressed() {
		started = !started;
		buttons.setVisible(true);

		event();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		bJouerPressed();

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
});
}



public void event() {
	buttons.setVisible(started);
	labelInstruct.setVisible(started);

	bJouer.setVisible(!started);

}
}
