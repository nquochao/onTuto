package mypackage.tuto.prototype;

import java.awt.image.BufferedImage;

public enum ClansExistants {
	tonnerre("Clan du Tonnerre", "clandutonnerre.png"), riviere("Clan de la Rivière","clandelariviere.png"), vent("Clan du Vent","clanduvent.png"), ombre("Clan de l'Ombre","clandelombre.png");

	ClansExistants(String nameOfClan, String image2) {
		nom = nameOfClan;
		image=image2;
	}

	String nom;
	String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
