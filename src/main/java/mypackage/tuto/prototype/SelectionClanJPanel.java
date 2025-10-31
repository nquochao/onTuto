package mypackage.tuto.prototype;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;

public class SelectionClanJPanel extends AbstractSelectionPanel {
	private static final String INSTRUCTION = "Choisis ton Clan";

	public SelectionClanJPanel(HaoTutotialFrame frame2, Chat heros2) {
		super(frame2, heros2);

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

	@Override
	protected void initLabels() {

		for (ClansExistants e : ClansExistants.values()) {
			HaoJLabel b = new HaoJLabel(e.getNom(), e.getImage(), e);

			labels.add(b);


		}

	}


	@Override
	protected AbstractSelectionPanel getNextPanel() {
		return new SelectionChatJPanel(frame, heros);
	}


	@Override
	protected int getLabelsCols() {
		return 2;
	}

	@Override
	public String getLabelsResourcesFolder() {
		return null;
	}

	@Override
	protected void updateHeros() {
		ClansExistants e=selectedLabel.getClan();
		heros.setClan(e);
		
	}

}
