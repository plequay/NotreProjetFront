package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Client;

import model.Admin;
import model.Compte;
import util.Context;

@WebServlet("/connexion")
public class ControlIndex extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String surnom=request.getParameter("pseudo");
		String login=request.getParameter("login");
		String password=request.getParameter("mdp");
		
		Context.getInstance().getDaoC().seConnecter(login, password);
		
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
