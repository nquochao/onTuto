package mypackage.tuto.prototype;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlayFieldJPanel extends AbstractSelectionPanel {

	public PlayFieldJPanel(HaoTutotialFrame haoTutotialFrame, Chat heros) {
		super(haoTutotialFrame, heros);
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


		@Override
		protected void updateHeros() {
			// TODO Auto-generated method stub
			
		}

}
