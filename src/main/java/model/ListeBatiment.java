package model;

public enum ListeBatiment {
	
	Scierie(true),Bucheron(false),Muraille(true),Mine(true),Mineur(false),Carriere(true),Carrier(false),Merveille(true),Four(false),Forteresse(true),Fonderie(false),Catapulte(true),Scorpion(true),Baliste(true);
	
	private boolean ameliorable;

	
	private ListeBatiment(boolean ameliorable) {
		this.ameliorable = ameliorable;
	}

	public boolean isAmeliorable() {
		return ameliorable;
	}

	public void setAmeliorable(boolean ameliorable) {
		this.ameliorable = ameliorable;
	}
	
	
}
