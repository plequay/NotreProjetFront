package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import model.*;
import util.Context;


@Entity
public class Session {


	@EmbeddedId 
	private SessionId id;
	
	@Column(name = "a_joue_le_tours")
	private boolean aJoueLeTours;
	@Column(name = "tour_en_tours")
	private boolean tourEnCours;
	@Column(name = "a_commence")
	protected boolean aCommence;
	private int def;
	private int att;
	
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @MapsId("idPartie")
    private Partie partie;
	
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @MapsId("idCompte")
    private Compte compte;
				
	
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinTable(name="liste_ressources",inverseJoinColumns=@JoinColumn(name="ressources"))
	protected List<Ressource> ressources = new ArrayList <Ressource>();
	
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinTable(name="liste_batiments",inverseJoinColumns=@JoinColumn(name="batiments"))
	protected List<Batiment> constructions = new ArrayList <Batiment>();
			
	public Session() {}
		
	public Session(boolean aJoueLeTours, Partie partie, Compte compte) {	
		this.id = new SessionId(compte.getId(),partie.getId());
		this.aJoueLeTours = aJoueLeTours;
		this.partie = partie;
		this.compte = compte;
	}
	
	
	
	
	public boolean isTourEnCours() {
		return tourEnCours;
	}

	public void setTourEnCours(boolean tourEnCours) {
		this.tourEnCours = tourEnCours;
	}

	public SessionId getId() {
		return id;
	}

	public void setId(SessionId id) {
		this.id = id;
	}

	public boolean isaJoueLeTours() {
		return aJoueLeTours;
	}

	public void setaJoueLeTours(boolean aJoueLeTours) {
		this.aJoueLeTours = aJoueLeTours;
	}
		
	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public List<Ressource> getRessources() {
		return ressources;
	}

	public void setRessources(List<Ressource> ressources) {
		this.ressources = ressources;
	}

	public List<Batiment> getConstructions() {
		return constructions;
	}

	public void setConstructions(List<Batiment> constructions) {
		this.constructions = constructions;
	}

	@Override
	public String toString() {
		return "Session [id=" + id + ", aJoueLeTours=" + aJoueLeTours + "]";
	}
	
	public void construitBastide(){ // OK
		Bastide bastide = new Bastide();
		this.getConstructions().add(bastide);
		Context.getInstance().getDaoS().update(this);
	}
		
	public ArrayList<Batiment> actuDef() //Permet d'actualiser les points de defense du joueur ainsi que la liste des batiments du joueur (ATTENTION RENVOI UNE LISTE !!)
	{
		ArrayList <Batiment> batiments = new ArrayList <Batiment>();
		this.def=0;
		
		for (Batiment batiment : this.constructions)
		{
			if (batiment.getDef()>0) {
				batiments.add(batiment);
				this.def += batiment.getDef();
			}
		}			
		return batiments;
	}
	
	public ArrayList <Batiment> actuAtt()  //Permet d'actualiser les point d'attaque du joueur ainsi que la liste des batiments du joueur (ATTENTION RENVOI UNE LISTE !!)
	{
		ArrayList <Batiment> batiments = new ArrayList <Batiment>();
		this.att=0;
		
		for (Batiment batiment : this.constructions)
		{
			if (batiment.getDef()>0) {
				batiments.add(batiment);
				this.att += batiment.getAtt();
			}
		}			
		return batiments;
	}
	
	public boolean verification(Batiment batiment) // Verification du nombre de ressources du joueur pour acheter un batiment (renvoie un bool)
	{
		for (Ressource ressourceSession : this.ressources)
		{
			for (Ressource ressourceBatiment: batiment.getCost())
			{
				if (ressourceBatiment.getClass().getName().equals(ressourceSession.getClass().getName()) && ressourceBatiment.getStock()>ressourceSession.getStock())
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public void attaque(Session ennemi) // Attaque de tous les batiments d'un autre joueur
	{
		double ptsAtt = this.att/ennemi.getConstructions().size();
		for (Batiment batiment : ennemi.getConstructions())
		{
			batiment.setDef(batiment.getDef()-ptsAtt);
			Context.getInstance().getDaoB().update(batiment); 
		}
		ennemi.setConstructions(ennemi.actuDef());
	}
	
	public void attaque(Session ennemi, Batiment batiment, double ptsAttaque) // Attaque d'un batiment d'un autre joueur
	{
		batiment.setDef(batiment.getDef()-ptsAttaque);
		System.out.println("Il reste " + batiment.getDef() + " de defence a " + batiment.toStringName());
		ennemi.setConstructions(ennemi.actuDef());	
				
		Context.getInstance().getDaoB().update(batiment); 	
	}
	
	public void attaque (Session ennemi, Attaque batimentDAttaque, Batiment batimentDEfense) //Attaque d'un batiment d'un autre joueur par un batiment d'attaque
	{
		if (batimentDAttaque.isUsed()==false)
		{
		for (Batiment b : ennemi.getConstructions())
		{
			if (b.getClass()==batimentDEfense.getClass()) {b.setDef(b.getDef()-batimentDAttaque.getAtt());}
			batimentDAttaque.setUsed(true);
		}
		}else {System.out.println("Ce batiment d'attaque est indisponible");}
				
	}
	
	public void transformation(String batiment,int nbRessource,String nomRessource)
	{

		if (batiment.equalsIgnoreCase("Four"))
		{
			for (Batiment b: this.constructions)
			{
				if (b instanceof Four)
				{
					((Four) b).transformation(nomRessource, nbRessource, this.ressources);
				}
			}
		}
		else if(batiment.equalsIgnoreCase("Fonderie"))
		{
			for (Batiment b: this.constructions)
			{
				if (b instanceof Fonderie)
				{
					((Fonderie) b).transformation(nomRessource, nbRessource, this.ressources);
				}
			}
		}
			
	}
	
	public void constructBat(Batiment batiment)  // Construction d'un batiment (ajout a la liste/actuAtt/ActuDef/ActuRessources)
	{
		this.getConstructions().add(batiment);
		Context.getInstance().getDaoS().update(this);
		
		this.setConstructions(this.actuDef());
		this.setConstructions(this.actuAtt());

		for (Ressource r : this.getRessources())	//modification du stock de ressources du joueur en fonction du cout (cf. methode actuAchat de la classe ressources)
		{
			r.actuAchat(batiment.getCost());
		}
	}
	
	
	public void joueTour(){
	     
		// TODO: choix de jeu menuJoueur (1- construire 2-attaquer 3-fin de tour)
		this.menuJoueur();
		
	}
		
	public void piocherRessources()
	{
		int bois = 0;
		int pierre = 0;
		int minerais = 0;
		
		for(int i=0; i<10; i++)
		{
			int d = (int)Math.round(Math.random()*2);
			switch(d)
			{
				case 0 : bois++; break;
				case 1 : pierre++;  break;
				case 2 : minerais++;  break;
			}
		}
		
		System.out.println("\nVous avez obtenu " + bois + " bois, " + pierre + " pierre(s), " + minerais + " minerais !");	
		
		for (Batiment b : this.constructions)
		{
			if(b instanceof Carriere)
			{
				pierre+=3;
				System.out.println("\nVotre carriere vous a rapporte 3 pierres supplementaires ("+pierre+" pierre(s) au total !)\n");	
			}
			else if (b instanceof Mine)
			{
				minerais+=3;
				System.out.println("\nVotre mine vous a rapporte 3 minerais supplementaires ("+minerais+" minerais au total !)\n");	
			}
			else if (b instanceof Scierie)
			{
				bois+=3;
				System.out.println("\nVotre scierie vous a rapporte3 bois supplementaires ("+bois+" bois au total !)\n");	
			}
		}
		
		for (Ressource r : this.ressources)	//modification du stock de ressources du joueur en fonction du cout (cf. methode actuAchat de la classe ressources)
		{
			
			switch(r.getClass().getName()) {
			  case "bois":
				  r.actuGain(bois);
				  break;
			  case "pierre":
				  r.actuGain(bois);
			      break;
			  case "minerais":
				  r.actuGain(bois);    
				  break;
			  default:
			  
			}	
		}

//		b.actuGain(bois);
//		p.actuGain(pierre);
//		m.actuGain(minerais);
	}
	
	
	public void menuJoueur(){
		
		if(this.def>0)
		{
			System.out.printf("%s\n","MENU JOUEUR" + " - " + this.compte.getPrenom() + " " + this.compte.getNom() + " " + this.compte.getSurnom());
			System.out.printf("%s\n","1- Construire");
			System.out.printf("%s\n","2- Ameliorer");
			System.out.printf("%s\n","3- Attaquer");
			System.out.printf("%s\n","4- Tranformer ressources");
			System.out.printf("%s\n","5- Fin de tour");
			
			int choix =10;
			this.afficheListeRessources();
			try {
				choix = Context.getInstance().saisieInt("Choisir un menu");
			}
			catch (Exception e) {
				System.out.println("Rentrez un chiffre !");
			}
			
			switch(choix) 
			{
				case 1 : menuConstruction(); break;
				case 2 : menuAmeliorer(); break; // TODO: a finir en intï¿½grant la mï¿½thode pour upgrader le batiment
				case 3 : menuAttaquer();break; // TODO: Menu attaque
				case 4 : menuTransformation();break; // TODO: Menu Transformatino
				case 5 : menuFinDeTour();break; // TODO: fin de tour
				default : System.out.println("Mauvaise valeur");
			}
		}
		else
		{
			System.out.printf("%s\n","JOUEUR ELIMINE" + " - " + this.compte.getPrenom() + " " + this.compte.getNom() + " " + this.compte.getSurnom());
			menuFinDeTour();
		}
		
	}
	
	public void afficheListeRessources() {
		System.out.println("Ressources disponibles:");
		for (Ressource r: this.ressources) {
			System.out.print(r.toStringName() + ": "+r.getStock() + "  ");
		}
		
		System.out.println("\n-------------------------------- \n");
	}
	
	
	//---------------------------------------------------------------
	
	
	
	
	
	
	
	
	private void menuTransformation() {
		boolean batimentTranformationOK=false;
		String batiment;
		int nbRessource=0;
		String nomRessource ="null";
		
		System.out.println("Votre liste de batiment de transformation:");
		
		for (Batiment b : constructions)
		{
			if(b instanceof Transformation)
			{
				System.out.println(b.toStringName());
				batimentTranformationOK=true;
			}
		}
		
		if(batimentTranformationOK==false)
		{
			System.out.println("Vous n'avez pas de batiment de construction");
			menuJoueur();
		}
		
		batiment = Context.saisieString("Quel batiment souhaitez-vous utiliser?");
		if (batiment.equalsIgnoreCase("Four")) 
		{
			int i = ressources.get(0).getStock();
			if (i<=0) 
			{

				System.out.println("Le four ne peut pas etre utiliser! Vous n'avez pas de bois!");

			}
			else 
			{
				nomRessource = "charbon";
				nbRessource = Context.saisieInt("Vous avez " + i + "bois, combien voulez-vous en transformer?");
			}	
		}
		else if (batiment.equalsIgnoreCase("Fonderie"))
		{
			afficheListeRessources();
			nbRessource = Context.saisieInt("Combien de ressources voulez-vous transformer ?");
			nomRessource = Context.saisieString("Quels ressources voulez-vous produire (charbon/gold/fer/cuivre)?");
		}
		transformation(batiment,nbRessource,nomRessource);
	}
	
	
	
	public void menuAmeliorer(){
		
		System.out.printf("%s\n","MENU AMELIORATION" + " - " + this.getCompte().prenom + " " + this.getCompte().nom + " " + this.getCompte().surnom);
		
		displayOwnedConstWithUpdatePossibilities();
		displayOwnedConstWithUpdateNoPossibilities();
		
		System.out.printf("%s\n","0- Menu precedent");
		int choix = Context.saisieInt("Choisir un batiment a ameliorer (saisir l'index)");
		if(choix==0){
			menuJoueur();
		} else {
			Batiment batiment = this.constructions.get(choix-1);
			if (batiment instanceof Batiment){
				//construction(batiment); // TODO: call update
				//Batiment newBatiment = batiment.upgrade(batiment);
				//this.construction.set(choix-1, newBatiment);
				
				if(verification(batiment)) {
					for (Ressource r : this.ressources)	//modification du stock de ressources du joueur en fonction du cout (cf. methode actuAchat de la classe ressources)
					{
						r.actuAchat(batiment.getCost());
					}
					
					batiment.upgrade();
					batiment = Context.getInstance().getDaoB().update(batiment);
					//daoBatiment.update(batiment);
					
					setConstructions(this.actuDef());
					setConstructions(this.actuAtt());
					
					
					
					System.out.println("Un batiment " + batiment.toStringName() + " a ete ameliore");
				} else {
					System.out.println("Pas assez de thune pour ameliorer " + batiment.toStringName() + " !!!!");
				}
				
				

			} else {
				System.out.println("Ceci n'est pas un batiment");
			}
		}

	}
	
	
	public boolean listeBatimentContains(String testedValue) {

		boolean output = false;
		for (ListeBatiment b : ListeBatiment.values()) {
			if (b.name().equals(testedValue)) {
				output = true;
			} 
		}
		return output;
	}
	
	
	public void displayOwnedConstWithUpdatePossibilities(){
		
		afficheListeRessources();
		System.out.printf("%s","POSSIBILITE D'AMELIORATION" + "\n");
		
		for (int i = 0; i < this.constructions.size(); i++) {
			int idx = i+1;
			Batiment batiment = this.constructions.get(i);
			
			if(listeBatimentContains(batiment.toStringName())) {
				ListeBatiment b = ListeBatiment.valueOf(batiment.toStringName());
	    		if(verification(batiment) && b.isAmeliorable()){
					System.out.println(idx + "-" + batiment.toStringWithCost());
					System.out.println("--------------------------------");
				}	
			}
		}
		
		System.out.println("-------------------------------- \n");
	}
	
	
	
	
	public void displayOwnedConstWithUpdateNoPossibilities(){
		
		System.out.printf("%s","Liste de vos batiments" + "\n");
		for (Batiment b: this.constructions) {
			System.out.println(b.toStringName() +" Niveau: "+ b.getLevel()+"  Def:" +b.getDef()+ "  Att:"+b.getAtt());
		}
	
		//System.out.printf("%25s %5s %5s %5s\n", "Nom", "level", "def", "att");
			
		for(Batiment batiment : constructions){
			if(verification(batiment)==false){
				System.out.println(batiment.toStringWithCost());
			}
		}
	}
	
	
	
	
	
	
	
	public void menuConstruction(){
		
		
		System.out.printf("%s\n","MENU CONSTRUCTION" + " - " + this.getCompte().prenom + " " + this.getCompte().nom + " " + this.getCompte().surnom);
		System.out.println("---- \n");
		
		displayOwnedConstruction();
		System.out.println("-------------------------------- \n");
		displayConstructionPossibilites();
		displayConstructionNoPossibilites();
		
		System.out.printf("%s\n","0- Menu precedent");
		String choix = Context.saisieString("Choisir un batiment a construire");
		
		if(choix.equals("0")){
			menuJoueur();
			//System.out.println(choix);
		} else {
			//System.out.println(choix);
			Batiment batiment = stringToBatiment(choix);	
			//System.out.println(batiment.toStringName());
			if (batiment instanceof Batiment){
				
				//System.out.println(batiment.toStringName());
				if (verification(batiment)) {
					
					//System.out.println(batiment.toStringName());
					constructBat(batiment);
					System.out.println("Un batiment " + batiment.toStringName() + " a ete construit \n");

				}
				
			} else {
				System.out.println("Ceci n'est pas un batiment");
			}
		}

		
	}
	
	
	public static Batiment stringToBatiment(String batimentName){	
		Batiment batiment=null;
		switch(batimentName)
			{
				case "Bastide" : batiment = new Bastide();break;
				case "Carriere" : batiment = new Carriere();break;
				case "Catapulte" : batiment = new Catapulte();break;
				case "Fonderie" : batiment = new Fonderie();break;
				case "Forteresse" : batiment = new Forteresse();break;
				case "Four" : batiment = new Four();break;
				case "Merveille" : batiment = new Merveille();break;
				case "Mine" : batiment = new Mine();break;
				case "Muraille" : batiment = new Muraille();break;
				case "Scierie" : batiment = new Scierie();break;
				default: System.out.println("Ceci n'est pas un batiment");break;
			}
			
		
		return batiment;
	}
	
	
	
	public boolean getBatimentAttaque()
	{		
		for(Batiment b : constructions)
		{
			if(b instanceof Attaque)
			{
				if (((Attaque)b).isUsed()==false)
					{
					return true;
					}
			}
		}
		return false;
	
	}
	
	
	
	public double choixBatimentAttaque()
	{
		int cptLigne = -1;
		int cptBatAttaque =0;
		List<Integer> listeLigne= new ArrayList<Integer>();
		double valeurAttaque = 0;
		
		//Affiche la liste des batiments d'attaque et leur used
		System.out.println("Vos batiments d'attaque:");
		for (Batiment b : constructions)
		{
			cptLigne++;
			if(b instanceof Attaque)
			{
				cptBatAttaque++;
				listeLigne.add(cptLigne);
				if(((Attaque) b).isUsed())
				{
					System.out.println("Batiment numero " +cptBatAttaque+ ": " + b + " / Batiment d'attaque deja utilise");
				}
				else 
				{
					System.out.println("Batiment numero " +cptBatAttaque+ ": " + b + " / Batiment d'attaque disponible");
				}
			}
		}
		System.out.printf("%s\n","MENU CHOIX DU/DES BATIMENT(S) D'ATTAQUE:");
		System.out.printf("%s\n","1- Attaquer avec tous les batiments disponibles");
		System.out.printf("%s\n","2- Choisir un batiment d'attaque");
		int choix = Context.saisieInt("Choisir un menu");
		switch(choix) 
		{
			case 1 : valeurAttaque = attaqueAvecTousBatiments(); break;
			case 2 : valeurAttaque = attaqueAvecUnBatiment(listeLigne); break; 
			default : System.out.println("Mauvaise valeur");
		}
		
		return valeurAttaque;
	}
	
	
	private double attaqueAvecTousBatiments() {
		double valeurAttaque = 0;
		for (Batiment b : constructions)
		{
			if(b instanceof Attaque)
			{
				if(((Attaque) b).isUsed()==false)

				{
					valeurAttaque += b.getAtt();
					((Attaque) b).setUsed(true);
				}
				else {System.out.println("Condition attaqueAvecTousBatiments");}
			}
		}
		System.out.println("La valeur total de votre attaque est de " + valeurAttaque + "points");
		return valeurAttaque;
	}
	
	
	
	
	private double attaqueAvecUnBatiment(List<Integer> listeLigne) {
		double valeurAttaque = 0;
		int choix = Context.saisieInt("Avec quel batiment voulez-vous attaquer? (numero du batiment)");
		int ligneBatiment = listeLigne.get(choix-1);
		int cpt = 0;
		
		for (Batiment b : constructions)
		{
			if (cpt==ligneBatiment)
			{
				if (((Attaque) b).isUsed()) 
				{
					System.out.println("Ce batiment n'est pas disponible pour attaquer");
					attaqueAvecUnBatiment(listeLigne);
				}
				else 
				{
					valeurAttaque = b.getAtt();
					((Attaque) b).setUsed(true);
					System.out.println("La valeur de votre attaque est de " + valeurAttaque + "points");
				}
				
			}
			cpt++;
		}
		
		return valeurAttaque;
	}
	
	
	
	
	

	public void displayBatimentAttaque()
	{
		System.out.printf("%s","Liste de vos batiments d'attaque" + "\n");
		//System.out.printf("%25s %5s %5s %5s\n", "Nom", "level", "def", "att", "used");
		
		for(Batiment batiment : constructions){
			if(batiment instanceof Attaque)
			{
				System.out.println(batiment);
			}
		}
	}
	
	
	
	
	
	public void displayOwnedConstruction(){
		
		System.out.printf("%s","Liste des batiments de "+ this.getCompte().surnom + "\n"); // TODO: "de vos batiment" mais la fonction est appelï¿½e aussi pour afficher les batiments de l'ennemi dans la fonction menuAttaqueChoixBatiment
		//System.out.printf("%25s %5s %5s %5s\n", "Nom", "level", "def", "att");
		
		for(Batiment batiment : this.constructions){
			System.out.println(batiment);
		}
		
		System.out.println("-------------------------------- \n");
		
	}
	
	
	
	
	public void displayConstructionPossibilites(){
		
		afficheListeRessources();
		System.out.printf("%s","POSSIBILITE DE CONSTRUCTION" + "\n");
		for (ListeBatiment b : ListeBatiment.values()) { 
    		Batiment batiment = stringToBatiment(b.toString());
    		if(verification(batiment)){
    			System.out.println(batiment.toStringName());
				System.out.println(batiment.toStringWithCost());
				System.out.println("--------------------------------");
			}
		}
		
		System.out.println("-------------------------------- \n");
		
	}
	
	
	
	
	
	
	public void displayConstructionNoPossibilites(){
		
		System.out.printf("%s","IMPOSSIBLE DE CONSTRUIRE:" + "\n");
		//System.out.printf("%25s %5s %5s %5s\n", "Nom", "level", "def", "att");
				
		for (ListeBatiment b : ListeBatiment.values()) { 
    		Batiment batiment = stringToBatiment(b.toString());
    		if(verification(batiment)==false){
				System.out.println(batiment.toStringWithCost());
				System.out.println("-------------------------------- \n");
			}
		}
		
		System.out.println("---- \n");
		
	}
	
	
	
	
	public void menuAttaquer()
	{
		//Vï¿½rifie si un batiment d'attaque disponible pour attaquer existe

		if(this.getBatimentAttaque())
		{
			for (Session se: partie.getSessions())
			{
				if (se.getCompte().surnom!=this.getCompte().surnom)
				{
					se.displayOwnedConstruction();
				}
			}
		
			System.out.printf("%s","MENU ATTAQUER" + " - " + this.getCompte().prenom + " /n " + this.getCompte().nom + " /n " + this.getCompte().surnom + "\n");
			System.out.printf("%s","0- Menu precedent \n");
			System.out.printf("%s","1- Attaquer!!!!!" + "\n");
			int choix = Context.saisieInt("Choisir une option");
		
			switch(choix) 
			{
				case 0: menuJoueur() ;break;
				case 1: double valeurAttaque = choixBatimentAttaque();menuAttaqueJoueur(partie,valeurAttaque);break;
				default : System.out.println("Mauvaise valeur");
			}
			
		}
		else
		{
			System.out.println("Vous n'avez pas de batiment d'attaque disponible pour attaquer, quel dommage...'");
			menuJoueur();
		}
	}
	
	
	
	
	
	
	public void menuAttaqueJoueur(Partie p, double valeurAttaque)
	{
		System.out.println("liste des joueurs adverses :");
		for (Session se: p.getSessions())
		{
			if (se.getCompte().getSurnom()!=this.getCompte().surnom)
			{
				System.out.println((p.getSessions().indexOf(se)+1)+ " - "+se.getCompte().getSurnom());
			}
		}
		int victime = Context.saisieInt("Quel joueur souhaites-tu attaquer? (1,2,3,...)");
		Session ennemi = p.getSessions().get(victime-1);
				
		System.out.printf("%s\n","MENU ATTAQUER" + " - " + this.getCompte().prenom + " " + this.getCompte().nom + " " + this.getCompte().surnom);

		System.out.printf("%s\n","1- Attaquer tous les  batiments?");
		System.out.printf("%s\n","2- Attaquer un  seul batiment?");

		int choix = Context.saisieInt("Choisir une option");
		
		switch(choix) 
		{
			
			case 1: attaqueJoueur(ennemi,p,valeurAttaque);break;
			case 2: menuAttaqueChoixBatiment(ennemi,p,valeurAttaque);break;
			default : System.out.println("Mauvaise valeur");
		}
	}
	
	
	
	
	public void menuAttaqueChoixBatiment(Session s, Partie p, double valeurAttaque)
	{

		// Affiche liste des batiments du joueur attaqué
		s.displayOwnedConstruction();


		String nomBat = Context.saisieString("Quel batiment voulez vous attaquer(nom)?");
		int numBat = Context.saisieInt("Le/La combientieme de "+ nomBat +" voulez vous attaquer?");
		int i=0;
		Boolean batExiste;
		Batiment bat;
		
		for (Batiment b : s.getConstructions())
		{
			if (b.toStringName().equalsIgnoreCase(nomBat))
			{
				i++;
				batExiste = true;
				if(i==numBat)
				{
					attaque(s, b, valeurAttaque);
				}
			}
		}
		
		if(batExiste = false)
		{
			System.out.println("Le joueur attaque ne possede pas ce batiment!'");
			menuAttaqueChoixBatiment(s,p,valeurAttaque);
		}
		if (i!=numBat)
		{
			System.out.println("Le numero de batiment n'existe pas!'");
			menuAttaqueChoixBatiment(s,p,valeurAttaque);
		}
		
		menuAttaquer();
		
	}
	
	
	public void attaqueJoueur(Session se, Partie p, double valeurAttaque)
	{
		double nbBatiment = se.getConstructions().size();
		double degatBatiment = (valeurAttaque - valeurAttaque%nbBatiment)/nbBatiment;
		double degatReste= valeurAttaque%nbBatiment;
		double i = 0;
		
		for (Batiment b : se.getConstructions())
		{
			i++;
			if(i<=degatReste) 
			{
				attaque(se, b, degatBatiment+1);
				
			}
			else 
			{
				attaque(se, b, degatBatiment);
				
			}
		}
		System.out.println("Le joueur" + se + " a perdu " + valeurAttaque/nbBatiment + " pt de defense par batiment ("+nbBatiment+")");
		menuAttaquer();
	}
	
	public boolean isaCommence() {
		return aCommence;
	}

	public void setaCommence(boolean aCommence) {
		this.aCommence = aCommence;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getAtt() {
		return att;
	}

	public void setAtt(int att) {
		this.att = att;
	}

	public void menuFinDeTour()
	{
		for(Ressource r : this.ressources)
		{
			r=Context.getInstance().getDaoR().update(r);
			//daoRessource.updateRessource(this.getId(), p.getId(), r);
		}
		
		this.setTourEnCours(false);
		
		System.out.printf("%s","FIN DE TOUR" + " - " + this.compte.getPrenom() + " " + this.compte.getNom() + " " + this.compte.getSurnom() + "\n");
		System.out.printf("%s","Vous avez effectue votre action de jeu, au prochain joueur de jouer !");
		
		for(Batiment batiment : this.constructions){
			if(batiment instanceof Attaque)
			{
				((Attaque) batiment).setUsed(false);
			}
		}
	}


}
