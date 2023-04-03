package gsb.service;
import java.util.ArrayList;
import java.util.HashMap;

import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteurDao;

public class VisiteurService {

	public static Visiteur rechercherVisiteur(String unMatricule){
		Visiteur unVisiteur = null;
		try{
		if (unMatricule==null) {
            throw new Exception("Donnee obligatoire : matricule du visiteur");
        }
		unVisiteur = VisiteurDao.rechercher(unMatricule);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return unVisiteur;
	}
	
	public static int creerUnVisiteur (Visiteur unVisiteur) {
		int resultat = 0;
		try {
		if (unVisiteur ==null) {
			throw new Exception("Donnee obligatoire : matricule du visiteur");
		}
		resultat = VisiteurDao.creerVisiteur(unVisiteur);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return resultat;
	}
	
	public static ArrayList<Visiteur> retournerCollectionVisiteur(){
		ArrayList<Visiteur> lesVisiteurs = null;
		try{
		
		lesVisiteurs = VisiteurDao.retournerCollectionVisiteur();
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return lesVisiteurs;
	}
	
	public static HashMap<String,Visiteur> retournerDictionnaireDesVisiteurs() {
		HashMap<String, Visiteur> diccoDesVisiteurs = null;
		diccoDesVisiteurs = VisiteurDao.retournerDictionnaireDesVisiteurs();
		return diccoDesVisiteurs;
		
	}
	
	public static ArrayList<String> listeCodeVisiteurs(){
		ArrayList<String> listeCodeVisiteurs = new ArrayList<String>();
		ArrayList<Visiteur> lesVisiteurs = new ArrayList<Visiteur>();
		
		// On récupére la collection des visiteurs
		lesVisiteurs = VisiteurDao.retournerCollectionVisiteur();
		
		// On ajoute le code de tout les visiteurs de la collection à la listeCodeVisiteurs
		for(Visiteur unVisiteur : lesVisiteurs) {
			listeCodeVisiteurs.add(unVisiteur.getMatricule());
		}
		
		return listeCodeVisiteurs;
		
	}
	
	public static void createVisitorWithStoredProcedure(Visiteur unVisiteur) {
		VisiteurDao.createVisitorWithStoredProcedure(unVisiteur);
	}
	
	public static void assignerUnResponsable(String matriculeResponsable, String matriculeVisiteur) {
		VisiteurDao.assignerUnResponsable(matriculeResponsable, matriculeVisiteur);
	}
	// ---------------------- VERIFICATION --------------------------------------
	
	// Cette méthode vérifie si l'utilisateur existe déjà dans la base de donnée, renvoie TRUE s'il existe, FALSE dans le cas contraire
	public static boolean checkIfVisiteurExist(String matricule) {
		boolean result = false;
		result = VisiteurDao.checkIfVisiteurExist(matricule);
		return result;
	}
	
	
	

}


