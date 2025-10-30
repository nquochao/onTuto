package mypackage.tuto.prototype;

import java.util.ArrayList;

public class HaoJButtons extends ArrayList<HaoJButton>{

	public void setVisible(Boolean b){
		for (HaoJButton button: this) {
			button.setVisible(b);
		}
	}
}
