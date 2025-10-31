package mypackage.tuto.prototype;

import java.net.URL;

public class SelectionChatJPanel extends AbstractSelectionPanel {
	static final String CHAT_TYPES_RESOURCE = "chats/types";
	

	public SelectionChatJPanel(HaoTutotialFrame frame2, Chat heros2) {
			super(frame2, heros2);
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
		return 1;
	}


	@Override
	protected AbstractSelectionPanel getNextPanel() {
		// TODO Auto-generated method stub
		return new SelectionNameJPanel(frame, heros);
	}




	@Override
	protected void updateHeros() {
		heros.setType(selectedLabel.getImage());
	}

}
