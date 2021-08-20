package util;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DAOBatiment;
import dao.DAOCompte;
import dao.DAOPartie;
import dao.DAORessource;
import dao.DAOSession;

public class Context {

	private static Context _instance=null;
	private static DAOBatiment daoB = new DAOBatiment();
	private static DAOCompte daoC = new DAOCompte();
	private static DAOPartie daoP = new DAOPartie();
	private static DAORessource daoR = new DAORessource();
	private static DAOSession daoS = new DAOSession();
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("NotreProjetBack");
		
	private Context() {}	
	
	public static Context getInstance() {
		if(_instance==null) {_instance=new Context();}
		return _instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public DAOBatiment getDaoB() {
		return daoB;
	}
	
	public DAOCompte getDaoC() {
		return daoC;
	}
	
	public DAOPartie getDaoP() {
		return daoP;
	}
	
	public DAORessource getDaoR() {
		return daoR;
	}
	
	public DAOSession getDaoS() {
		return daoS;
	}
	
	public void closeEmf() {
		emf.close();
	}
	
	public static int saisieInt(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();
	}
	
	public static String saisieString(String msg)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();
	}

		
}
