package mypackage.tuto.prototype.panel;

import javax.swing.JFrame;

import mypackage.tuto.prototype.beans.Chat;

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
