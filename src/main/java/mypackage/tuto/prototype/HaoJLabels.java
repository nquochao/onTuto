package mypackage.tuto.prototype;

import java.util.ArrayList;

public class HaoJLabels extends ArrayList<HaoJLabel>{

	public void setVisible(Boolean b){
		for (HaoJLabel button: this) {
			button.setVisible(b);
		}
	}
}
