package mypackage.tuto.prototype;

import java.util.logging.Logger;

public class Chat {
	ClansExistants clan;
	String type;
	private static Logger logger = Logger.getAnonymousLogger();

	public ClansExistants getClan() {
		return clan;
	}

	public void setClan(ClansExistants clan) {
		this.clan = clan;
		logger.info("Le heros est dorénavant membre du clan "+ clan.getNom());
	}

	public void setType(String type) {
		this.type=type;
		
	}
}
