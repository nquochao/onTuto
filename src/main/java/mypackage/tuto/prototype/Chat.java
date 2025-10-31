package mypackage.tuto.prototype;

import java.util.logging.Logger;

public class Chat {
	ClansExistants clan;
	String type, name;
	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

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

	public void setName(String name) {
		this.name=name;
		
	}
	@Override
	public String toString() {
		String sep= "  ";
		
		String result= "type: "+type+sep;
				result+="name: "+name+ sep;
		if(clan!=null) result+="clan: "+ clan.getNom();
		return result;
	}
}
