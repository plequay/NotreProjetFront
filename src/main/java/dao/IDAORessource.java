package dao;

import java.util.List;

import model.Ressource;

public interface IDAORessource extends IDAO <Ressource,Integer> {

	public List<Ressource> findAllByIdCompteIdPartie(Integer idCompte, Integer idPartie);
	
	
}
