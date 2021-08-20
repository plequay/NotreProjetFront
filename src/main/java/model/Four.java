package model;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Four  extends Transformation {
	
	protected transient Bois b = new Bois(3);
	protected transient Pierre p = new Pierre(3);
	protected transient Minerais m = new Minerais(3);
	protected transient Charbon c = new Charbon(0);
	protected transient Gold g = new Gold(0);
	protected transient Fer f = new Fer(0);
	protected transient Cuivre cu = new Cuivre(0);
	
	public Four() 
	
	{
		setNom("four");
		cost.add(b);cost.add(p);cost.add(m);cost.add(c);cost.add(g);cost.add(f);cost.add(cu);
		setDef(20);
	}

	public Four(String nom, int level, double def){
		super(nom, level, def);
	}

	public Four(int id, String nom, int level, double def)
	{
		super(id, nom, level, def);
		cost.add(b);cost.add(p);cost.add(m);cost.add(c);cost.add(g);cost.add(f);cost.add(cu);
	}
	
	@Override
	public void transformation (String r1, int nb, List <Ressource> re)  // r1 -> la ressource que l'on veut obtenir
	{																		// nb -> la quantit� de charbon que l'on veut obtenir
		if (r1.equalsIgnoreCase("charbon"))											// re -> liste de ressource du joueur qui op�re la transformation
		{
			for (Ressource r : re)
			{
				if (r instanceof Bois && r.getStock()>= nb)
				{
					r.setStock(r.getStock()-nb);
					for (Ressource r2 : re)
					{
						if (r2 instanceof Charbon)
						{
							r2.setStock(nb+r2.getStock());
						}
					}
				}
				else if (r instanceof Bois && r.getStock()< nb)
				{
					System.out.println("Vous n'avez pas assez de bois");
				}
			}
		}
		else {System.out.println("\nCe batiment ne permet pas d'obtenir d'autres ressources que le charbon");}

	}

	@Override
	public String toStringName() {
		return "Four";
	}
}

