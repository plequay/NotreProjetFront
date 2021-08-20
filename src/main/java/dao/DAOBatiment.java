package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.*;
import util.Context;

public class DAOBatiment implements IDAOBatiment{
	
	public List<Batiment> findAllByIdCompteIdPartie(Integer idCompte, Integer idPartie)
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("from batiment where id_compte = :idc and id_partie = :idp");
		query.setParameter("idc",idCompte);
		query.setParameter("idp",idPartie);
		List<Batiment> batiments = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return batiments;
	}
	
	public List<Batiment> findAllByBatiment(Integer idCompte, Integer idPartie, String nom)
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("from batiment where id_compte = :idc and id_partie = :idp and Batiment = :bat");
		query.setParameter("idc", idCompte);
		query.setParameter("idp", idPartie);
		query.setParameter("bat", nom);
		List<Batiment> batiments = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return batiments;
	}
	
	public Batiment insert(Batiment b) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();
		return b;
	}
	
	public Batiment ajoutBatiment(Batiment b) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();
		return b;
	}
	
	public Batiment update(Batiment b) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		b = em.merge(b);
		em.getTransaction().commit();
		em.close();
		return b;
	}
	
	public void delete(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Batiment b = em.find(Batiment.class,id);
		em.getTransaction().begin();
		em.remove(b);
		em.getTransaction().commit();
		em.close();
	}
	
	public void delete(Batiment b) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		b=em.merge(b);
		em.remove(b);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Batiment findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Batiment> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
