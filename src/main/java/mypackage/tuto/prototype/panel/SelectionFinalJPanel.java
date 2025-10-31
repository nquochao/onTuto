package mypackage.tuto.prototype.panel;

import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import mypackage.tuto.prototype.beans.Chat;
import mypackage.tuto.prototype.beans.Position;
import mypackage.tuto.prototype.labels.HaoJLabel;

public class SelectionFinalJPanel extends AbstractSelectionPanel {
	JTextField nameTextField;
	public SelectionFinalJPanel(JFrame frame, Chat heros) {
		super(frame,heros);
	}
	@Override
	protected void showLabels(Position p) {
		List<String> l=new ArrayList<>();
		Position offset=new Position(1,1);
		l.add("Clan");
		l.add(heros.getClan());
		addImageLine(p, offset, l);
		l.clear();

		l.add("Type");
		l.add(heros.getType());
		addImageLine(p, offset, l);
		l.clear();

		l.add("Nom");
		l.add(heros.getName());
		addLine(p, offset, l);
		l.clear();
		l.add("Genre");
		l.add(heros.getGender());
		addLine(p, offset, l);
		super.showLabels(p);
	}

	private void addImageLine(Position p, Position offset, List<String> l) {
		int initial=p.getX();
		int i=0;
		for(String s: l) {
		if(i%2==1) {
			addLabelImage(p,s);	
		}
		else addLabel(p, s);
		p= p.offsetX(offset.getX());
		i++;
		}
		p= p.offsetY(offset.getY());
		p.setX(initial);
}
		private void addLine(Position p, Position offset, List<String> l) {
			int initial=p.getX();
			for(String s: l) {
			addLabel(p, s);
			p= p.offsetX(offset.getX());
			}
			p= p.offsetY(offset.getY());
			p.setX(initial);
	}
		private void addLabel(Position p, String value) {
			GridBagConstraints cs = new GridBagConstraints();
			cs.fill = GridBagConstraints.HORIZONTAL;
			int x = p.getX(), y = p.getY();
			cs.gridx = x;
			cs.gridy = y;
			JLabel label= new JLabel();
			label.setText(value);
			this.add(label, cs);
			label.setVisible(true);
			p=new Position(x, y);
				
	}
		private void addLabelImage(Position p, String value) {
			GridBagConstraints cs = new GridBagConstraints();
			cs.fill = GridBagConstraints.HORIZONTAL;
			int x = p.getX(), y = p.getY();
			cs.gridx = x;
			cs.gridy = y;
			
			if(value!=null) {
				HaoJLabel label= new HaoJLabel("", value);
				this.add(label, cs);
				label.setVisible(true);
			}
			p=new Position(x, y);
				
	}

		@Override
		protected int getLabelsCols() {
			// TODO Auto-generated method stub
			return 2;
		}

		@Override
		public String getLabelsResourcesFolder() {
			return "panel/fin";
		}
		@Override
		public PlayFieldJPanel getNextPanel() {
			return new PlayFieldJPanel(frame, heros);
		}
		@Override
		protected boolean updateHeros() {
			return true;
		}

}
