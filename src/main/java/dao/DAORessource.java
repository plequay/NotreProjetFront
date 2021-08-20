package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAORessource;
import model.Compte;
import model.Ressource;
import util.Context;

public class DAORessource implements IDAORessource {

	@Override
	public Ressource findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Ressource r = em.find(Ressource.class,id);
		em.close();
		return r;
	}

	@Override
	public List<Ressource> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		List<Ressource> ressources = em.createQuery("from Ressource",Ressource.class).getResultList();
		em.close();
		return ressources;
	}

	@Override
	public Ressource insert(Ressource r) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		em.close();
		return r;
	}

	@Override
	public Ressource update(Ressource o) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		o=em.merge(o);
		em.getTransaction().commit();
		em.close();
		return o;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Ressource r = em.find(Ressource.class,id);
		em.getTransaction().begin();
		em.remove(r);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Ressource> findAllByIdCompteIdPartie(Integer idCompte, Integer idPartie) {
		
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		
		
		Query myQuery= em.createNativeQuery("SELECT * FROM ressource WHERE id_compte= :idC AND id_partie= :idP", Ressource.class);
		myQuery.setParameter("idC", idCompte);
		myQuery.setParameter("idP", idPartie);
		List<Ressource> ressources  = myQuery.getResultList();
		em.close();
		return ressources;
	}
	
	
	
	
}

	