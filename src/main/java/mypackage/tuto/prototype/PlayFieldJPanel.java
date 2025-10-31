package mypackage.tuto.prototype;

import javax.swing.JFrame;

import mypackage.tuto.prototype.panel.AbstractSelectionPanel;
import mypackage.tuto.prototype.panel.SelectionClanJPanel;

public class PlayFieldJPanel extends AbstractSelectionPanel {

	public PlayFieldJPanel(JFrame frame, Chat heros) {
		super(frame, heros);
	}


		@Override
		protected int getLabelsCols() {
			// TODO Auto-generated method stub
			return 2;
		}

		@Override
		public String getLabelsResourcesFolder() {
			// TODO Auto-generated method stub
			return "panel/play/field";
		}


		@Override
		protected AbstractSelectionPanel getNextPanel() {
			// TODO Auto-generated method stub
			return new SelectionClanJPanel(frame,heros);
		}



}
