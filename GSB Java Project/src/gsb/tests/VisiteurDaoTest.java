package gsb.tests;
import gsb.modele.dao.VisiteurDao;
import gsb.modele.Visiteur;

import java.util.ArrayList;

import gsb.modele.Localite;

public class VisiteurDaoTest {

	public static void main(String[] args) {
		
		// préparation des propriétés
		Visiteur unVisiteur = null;
		Localite uneLocalite = null;

		
		// Exécution de la requête rechercherVisiteur
		unVisiteur = VisiteurDao.rechercher("z65");
		uneLocalite = unVisiteur.getUneLocalite();
		
		// Affichage des resultats
		System.out.println(unVisiteur.getMatricule());
		System.out.println(unVisiteur.getNom());
		System.out.println(unVisiteur.getPrenom());
		System.out.println(unVisiteur.getLogin());
		System.out.println(unVisiteur.getMdp());
		System.out.println(unVisiteur.getAdresse());
		System.out.println(unVisiteur.getTelephone());
		System.out.println(unVisiteur.getDateEntree());
		System.out.println(unVisiteur.getPrime());
		System.out.println(unVisiteur.getCodeUnite());
		System.out.println(unVisiteur.getNomUnite());
		System.out.println(uneLocalite.getCodePostal());
		
		
	}

}
