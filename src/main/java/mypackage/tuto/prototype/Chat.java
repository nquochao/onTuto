package mypackage.tuto.prototype;

import java.util.logging.Logger;

public class Chat {
	String clan;
	public String getClan() {
		return clan;
	}

	public void setClan(String clan) {
		this.clan = clan;
	}

	String type, name;
	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	private static Logger logger = Logger.getAnonymousLogger();


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
		if(clan!=null) result+="clan: "+ clan;
		return result;
	}
String genre;
	public void setGenre(String genre) {
		this.genre=genre;
		
	}

	public String getGender() {
		// TODO Auto-generated method stub
		return genre;
	}
}
