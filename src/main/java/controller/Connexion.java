package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import util.Context;

@WebServlet("/pageco")
public class Connexion extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		Compte c = Context.getInstance().getDaoC().seConnecter(login, password);
		
	
		if(c instanceof Joueur) 
		{
		this.getServletContext().getRequestDispatcher("/choixPartie.html").forward(request, response);
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
		

		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		Compte c = Context.getInstance().getDaoC().seConnecter(login, password);
		
		if(c instanceof Joueur) 
		{
			this.getServletContext().getRequestDispatcher("/choixPartie.htm").forward(request, response);
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
