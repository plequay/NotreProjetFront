package model;

import javax.persistence.Entity;

@Entity
public abstract class Attaque extends Batiment{

	protected boolean used = false;
	
	protected transient Bois b = new Bois(0);
	protected transient Pierre p = new Pierre(0);
	protected transient Minerais m = new Minerais(0);
	protected transient Charbon c = new Charbon(0);
	protected transient Gold g = new Gold(0);
	protected transient Fer f = new Fer(0);
	protected transient Cuivre cu = new Cuivre(0);
	
	public Attaque(){
	}
	
	public Attaque(String nom, int level, double def){
		super(nom, level, def);
	}
	
	public Attaque(int id, String nom, int level, double def, double att)
	{
		super(id, nom, level, def,att);
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}
	protected Batiment upgrade(Batiment bati) 
	{		
		return bati;
	}
	@Override
	public String toStringName() {
		return "Attaque";
	}
	
}
