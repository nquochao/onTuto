package mypackage.tuto.prototype;

import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class SelectionFinalJPanel extends AbstractSelectionPanel {
	JTextField nameTextField;
	public SelectionFinalJPanel(HaoTutotialFrame frame, Chat heros) {
		super(frame,heros);
	}
	@Override
	protected void showLabels(Position p) {
		List<String> l=new ArrayList<>();
		Position offset=new Position(1,1);
		l.add("Nom du clan");
		l.add(heros.getClan().getNom());
		addLine(p, offset, l);
		l.clear();

		l.add("Type");
		l.add(heros.getType());
		addLine(p, offset, l);


		l.clear();
		l.add("Nom");
		l.add(heros.getName());
		addLine(p, offset, l);

		super.showLabels(p);
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
		private void addLabel(Position p, ClansExistants clan) {
			addLabel(p, "Clan");	
			p= p.offsetX(1);
			addLabel(p, clan.getNom());		
			p= p.offsetY(1);

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
		public StartPanel getNextPanel() {
			return new StartPanel(frame, heros);
		}
		@Override
		protected void updateHeros() {
			
		}

}
