package notreProjetFront.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import notreProjetBack.model.Partie;
import notreProjetBack.model.Session;
import notreProjetBack.repositories.CompteRepository;
import notreProjetBack.repositories.SessionRepository;

@Controller
public class ControlPageJeu {
		
	@Autowired
	SessionRepository sr;
	
	
	@GetMapping("/tour")
	public String tourDeJeu(HttpSession session, Partie partie) {
		session.setAttribute("players",sr.findByPartie(partie));
		
		for(Session player : sr.findByPartie(partie)) {
			if(player.isTourEnCours()== true) {
				session.setAttribute("player",player);
			} else {
				session.setAttribute("watchers", player);
			}
		}
		return "/PageJeu";
		
		
	}

}
