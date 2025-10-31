package mypackage.tuto.prototype;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

public class SelectionNameJPanel extends AbstractSelectionPanel {
	JTextField nameTextField;

	public SelectionNameJPanel(HaoTutotialFrame frame, Chat heros) {
		super(frame, heros);
	}

	@Override
	protected void showLabels(Position p) {

		GridBagConstraints cs = new GridBagConstraints();
		cs.fill = GridBagConstraints.HORIZONTAL;
		int x = 0, y = 0;
		cs.gridx = x;
		cs.gridy = y;
		nameTextField = new JTextField();
		this.add(nameTextField, cs);

		y = y + 1;

		super.showLabels(new Position(x, y));
	}

	@Override
	protected int getLabelsCols() {
		return 2;
	}

	@Override
	public String getLabelsResourcesFolder() {
		return "panel/name";
	}

	@Override
	public SelectionFinalJPanel getNextPanel() {
		return new SelectionFinalJPanel(frame, heros);
	}

	@Override
	protected void updateHeros() {
		String name = nameTextField.getText();
		this.heros.setName(name);

	}

}
