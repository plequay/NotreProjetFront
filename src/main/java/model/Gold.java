package model;


import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Gold")
public class Gold extends Ressource{

	public Gold(int stock) {
		super(stock);
		// TODO Auto-generated constructor stub
	}
	
	public Gold() {
	}

	@Override
	public int getStock() {
		// TODO Auto-generated method stub
		return super.getStock();
	}

	@Override
	public void setStock(int stock) {
		// TODO Auto-generated method stub
		super.setStock(stock);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	public void actuAchat(List<Ressource> cost) {
		// TODO Auto-generated method stub
		super.actuAchat(cost);
	}

	@Override
	public void actuGain (int gain) {
		// TODO Auto-generated method stub
		super.actuGain(gain);
	}

	@Override
	public String toStringName() {
		return "Or";
	}

	

}
