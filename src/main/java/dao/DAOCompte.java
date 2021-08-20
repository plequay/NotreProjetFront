package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOCompte;
import model.Admin;
import model.Compte;
import model.Joueur;
import model.Session;
import util.Context;

public class DAOCompte implements IDAOCompte{

	@Override
	public Compte findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Compte c = em.find(Compte.class,id);
		em.close();
		
		if (c instanceof Admin) {
			c= (Admin)c;
		}
		else if (c instanceof Joueur) {
			c= (Joueur)c;
		}
		return c;
	}
	
	public Compte findBySurnom(String surnom) {
		Compte c = null;
		
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query query = em.createQuery("from compte where surnom = :sur");
		query.setParameter("sur", surnom);
		c = (Compte) query.getSingleResult();
		em.close();
		
		return c;
	}

	@Override
	public List<Compte> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		List<Compte> comptes = em.createQuery("from Compte",Compte.class).getResultList();
		em.close();
		return comptes;
	}

	@Override
	public Compte insert(Compte c) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
		return c;

	}

	@Override
	public Compte update(Compte c) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		c=em.merge(c);
		em.getTransaction().commit();
		em.close();
		return c;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Compte c = em.find(Compte.class,id);
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		em.close();
	}

	public static Compte seConnecter(String login,String password) 
	{
		Compte c = null;
		try{
			EntityManager em = Context.getInstance().getEmf().createEntityManager();
			Query query= em.createQuery("from Compte c where c.login = :login and c.password=:password",Compte.class);
			query.setParameter("login", login);
			query.setParameter("password", password);
			c = (Compte) query.getSingleResult();
			em.close();
		}
		catch(Exception e) {}
		return c;
	}
	
//	public void ajoutSession(int idPartie, int idCompte) {
//		EntityManager em = Context.getInstance().getEmf().createEntityManager();
//		Query query = em.createNativeQuery("INSERT INTO joueur (id_partie,id_compte) VALUES (:idp,:idc)",Session.class);
//		query.setParameter("idp", idPartie);
//		query.setParameter("idc", idCompte);
//		em.close();
//	}
	
}
