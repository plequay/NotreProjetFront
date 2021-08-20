package model;

import javax.persistence.Entity;

@Entity
public abstract class Production extends Batiment {
	
	protected transient Bois b = new Bois(0);
	protected transient Pierre p = new Pierre(0);
	protected transient Minerais m = new Minerais(0);
	protected transient Charbon c = new Charbon(0);
	protected transient Gold g = new Gold(0);
	protected transient Fer f = new Fer(0);
	protected transient Cuivre cu = new Cuivre(0);
	
	
	public Production() {
		//cost.add(b);cost.add(p);cost.add(m);cost.add(c);cost.add(g);cost.add(f);cost.add(cu);
	}

	public Production(String nom, int level, double def){
		
		super(nom, level, def);
		
	}
	
	public Production(int id, String nom, int level, double def){
		
		super(id, nom, level, def);
		
	}
	
	protected Batiment upgrade(Batiment bati) 
	{		
		return bati;
	}
	
	@Override
	public String toStringName() {
		return "prod";
	}


}
