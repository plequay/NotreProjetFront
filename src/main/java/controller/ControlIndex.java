package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Joueur;
import util.Context;

@WebServlet("/connexion")
public class ControlIndex extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String surnom=request.getParameter("pseudo");
		String login=request.getParameter("login");
		String password=request.getParameter("mdp");
		
		Joueur j = new Joueur(login, password, prenom, nom, surnom);
		Context.getInstance().getDaoC().insert(j);
		
		this.getServletContext().getRequestDispatcher("/choixPartie.jsp").forward(request, response);
		
//		DAOCompte daoC = new DAOCompte();
//		DAOVilleJDBC daoV = new DAOVilleJDBC();
//		String login = request.getParameter("login");
//		String password = request.getParameter("password");
//		Compte c = daoC.seConnecter(login, password);
//		
//		List<Ville> villes = daoV.findAll();
//	
//		if(c instanceof Client) 
//		{
//			request.setAttribute("villesJSP", villes);
//			this.getServletContext().getRequestDispatcher("/client.jsp").forward(request, response);
//		}
//		else if(c instanceof Admin) 
//		{
//			this.getServletContext().getRequestDispatcher("/admin.html").forward(request, response);
//		}
//		else 
//		{
//			this.getServletContext().getRequestDispatcher("/connect.html").forward(request, response);
//		}
		
	}
	
	
	
}
