package mypackage.tuto.prototype;

public enum ClansExistants {
	tonnerre("Clan du Tonnerre"), riviere("Clan de la Riviere"), vent("Clan du Vent"), ombre("Clan de l'Ombre");

	ClansExistants(String nameOfClan) {
		nom = nameOfClan;
	}

	String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
