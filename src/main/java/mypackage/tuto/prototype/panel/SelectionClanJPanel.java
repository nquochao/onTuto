package mypackage.tuto.prototype.panel;

import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JLabel;

import mypackage.tuto.prototype.Chat;
import mypackage.tuto.prototype.Position;

public class SelectionClanJPanel extends AbstractSelectionPanel {
	private static final String INSTRUCTION = "Choisis ton Clan";

	public SelectionClanJPanel(JFrame frame, Chat heros2) {
		super(frame, heros2);
		nextPanel=new SelectionChatJPanel(frame, heros);

	}

	@Override
	protected void showLabels(Position p) {

		GridBagConstraints cs = new GridBagConstraints();
		cs.fill = GridBagConstraints.HORIZONTAL;
		int x = 0, y = 0;
		cs.gridx = x;
		cs.gridy = y;
		logger.info("x, y: " + cs.gridx + " , " + cs.gridy + " " + "Jouer");
		JLabel labelInstruct = new JLabel(INSTRUCTION);
		this.add(labelInstruct, cs);
		labelInstruct.setVisible(true);

		y = y + 1;

		super.showLabels(new Position(x, y));
	}

//	@Override
//	protected void initLabels() {
//
//		for (ClansExistants e : ClansExistants.values()) {
//			HaoJLabel b = new HaoJLabel(e.getNom(), e.getImage(), e);
//
//			labels.add(b);
//
//
//		}
//
//	}


	@Override
	protected AbstractSelectionPanel getNextPanel() {
		return nextPanel;
	}


	@Override
	protected int getLabelsCols() {
		return 2;
	}


	@Override
	protected boolean updateHeros() {
		//TODO
		String e=selectedLabel.getImage();
		heros.setClan(e);
		return !e.isEmpty();
		
	}
	@Override
	public String getLabelsResourcesFolder() {
		return  "clans";
	}
}
