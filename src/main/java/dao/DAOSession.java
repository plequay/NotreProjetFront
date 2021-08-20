package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Session;
import util.Context;

public class DAOSession implements IDAOSession{

	@Override
	public Session findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Session> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Session insert(Session s) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
		return s;
	}
	public Session update(Session s) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		s = em.merge(s);
		em.getTransaction().commit();
		em.close();
		return s;
	}
	
	public void delete(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Session s = em.find(Session.class,id);
		em.getTransaction().begin();
		em.remove(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public void delete(Session s) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		s=em.merge(s);
		em.remove(s);
		em.getTransaction().commit();
		em.close();
	}

}
