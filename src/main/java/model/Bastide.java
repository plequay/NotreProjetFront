package model;

import javax.persistence.Entity;

@Entity
public class Bastide extends Defense {
	
	public Bastide(){
		setNom("bastide");
		setLevel(1);
		setDef(50);
	}
	
	public Bastide(String nom, int level, double def)
	{
		super(nom, level, def);
	}
	
	public Bastide(int id, String nom, int level, double def)
	{
		super(id, nom, level, def);
	}
	
	@Override
	public String toStringName() {
		return "Bastide";
	}
}
