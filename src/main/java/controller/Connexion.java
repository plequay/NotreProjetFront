package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOCompte;
import model.*;

@WebServlet("/pageco")
public class Connexion extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOCompte daoC = new DAOCompte();
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		Compte c = daoC.seConnecter(login, password);
		
	
		if(c instanceof Joueur) 
		{
		//	request.setAttribute("villesJSP", villes);
		//	this.getServletContext().getRequestDispatcher("/client.jsp").forward(request, response);
		}
		else if(c instanceof Admin) 
		{
			this.getServletContext().getRequestDispatcher("/admin.html").forward(request, response);
		}
		else 
		{
			this.getServletContext().getRequestDispatcher("/connect.html").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
DAOCompteJDBC daoC = new DAOCompteJDBC();
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		Compte c = daoC.seConnecter(login, password);
		
		if(c instanceof Client) 
		{
			this.getServletContext().getRequestDispatcher("/client.jsp").forward(request, response);
		}
		else if(c instanceof Admin) 
		{
			this.getServletContext().getRequestDispatcher("/admin.html").forward(request, response);
		}
		else 
		{
			this.getServletContext().getRequestDispatcher("/connect.html").forward(request, response);
		}
	}
}
