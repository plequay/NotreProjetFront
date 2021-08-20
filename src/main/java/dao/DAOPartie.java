package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Partie;
import util.Context;

public class DAOPartie implements IDAOPartie {

	public Partie insert(Partie p) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
		return p;
	}
	public Partie update(Partie p) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		p = em.merge(p);
		em.getTransaction().commit();
		em.close();
		return p;
	}
	
	public void delete(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Partie p = em.find(Partie.class,id);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public void delete(Partie p) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		p=em.merge(p);
		em.remove(p);
		em.getTransaction().commit();
		em.close();
	}
	
	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Partie findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}	
}
