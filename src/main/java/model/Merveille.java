package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Merveille  extends Batiment{
	
	protected transient Bois b = new Bois(2);
	protected transient Pierre p = new Pierre(2);
	protected transient Minerais m = new Minerais(2);
	protected transient Charbon c = new Charbon(0);
	protected transient Gold g = new Gold(2);
	protected transient Fer f = new Fer(2);
	protected transient Cuivre cu = new Cuivre(2);
	
	public Merveille() 
	
	{
		super();
		setNom("merveille");
		cost.add(b);cost.add(p);cost.add(m);cost.add(c);cost.add(g);cost.add(f);cost.add(cu);
		setDef(100);
	}

	public Merveille(String nom, int level, double def){
		super(nom, level, def);
	}
	
	public Merveille(int id, String nom, int level, double def)
	{
		super(id, nom, level, def);
		cost.add(b);cost.add(p);cost.add(m);cost.add(c);cost.add(g);cost.add(f);cost.add(cu);
	}
	
	public void upgrade() 
	{	
		List<Ressource> tmpCost= new ArrayList<Ressource>();
		tmpCost = this.cost;
		for (Ressource r: tmpCost)
		{
			if (r.getStock()!=0) 
			{
				r.setStock(r.getStock()+3);
			}
		}
		this.setAtt(this.getAtt()+0);
		this.setDef(this.getDef()+100);
		this.setLevel(this.getLevel()+1);
		this.setCost(tmpCost);
		
		return;
	}
	
	@Override
	public String toStringName() {
		return "Merveille";
	}
}
