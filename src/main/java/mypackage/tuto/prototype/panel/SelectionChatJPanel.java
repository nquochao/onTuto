package mypackage.tuto.prototype.panel;

import java.net.URL;

import javax.swing.JFrame;

import mypackage.tuto.prototype.Chat;

public class SelectionChatJPanel extends AbstractSelectionPanel {
	static final String CHAT_TYPES_RESOURCE = "chats/types";
	
	





	public SelectionChatJPanel(JFrame frame, Chat heros) {
		super(frame, heros);
	}

	public URL getLabelsResources() {
		return this.getClass().getResource("/" + getLabelsResourcesFolder());
	}

	public String getLabelsResourcesFolder() {
		return  CHAT_TYPES_RESOURCE;
	}

	@Override
	protected int getLabelsCols() {
		// TODO Auto-generated method stub
		return 2;
	}


	@Override
	protected AbstractSelectionPanel getNextPanel() {
		// TODO Auto-generated method stub
		return new SelectionNameJPanel(frame, heros);
	}




	@Override
	protected boolean updateHeros() {
		heros.setType(selectedLabel.getImage());
		return selectedLabel.getImage()!=null;
	}

}
