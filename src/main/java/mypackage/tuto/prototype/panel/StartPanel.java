package mypackage.tuto.prototype.panel;

import javax.swing.JFrame;

import mypackage.tuto.prototype.Chat;

public class StartPanel extends AbstractSelectionPanel {

	public StartPanel(JFrame haoTutotialFrame, Chat heros) {
		super(haoTutotialFrame, heros);
		nextPanel=new SelectionClanJPanel(frame,heros);
	}


		@Override
		protected int getLabelsCols() {
			// TODO Auto-generated method stub
			return 2;
		}

		@Override
		public String getLabelsResourcesFolder() {
			// TODO Auto-generated method stub
			return "panel/start";
		}


		@Override
		protected AbstractSelectionPanel getNextPanel() {
			// TODO Auto-generated method stub
			return nextPanel;
		}


		@Override
		protected boolean updateHeros() {
			return true;
		}

}
