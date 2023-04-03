package gsb.tests;

import java.util.ArrayList;
import gsb.modele.dao.VisiteurDao;
import gsb.modele.Visiteur;

public class VisiteurDaoTestRetournerCollection {

	public static void main(String[] args) {
		// Préparation de l'array qui va contenir la liste des visiteurs de la BDD
		ArrayList<Visiteur> lesVisiteurs = new ArrayList<Visiteur>();
		
		// Appel de la méthode de VisiteurDao, qui permet de retourner TOUT les visiteurs de la BDD
		lesVisiteurs = VisiteurDao.retournerCollectionVisiteur();
		
		// Affichage de tout les visiteurs de la collection
		for (Visiteur listeVisiteurs : lesVisiteurs) {
			System.out.println(listeVisiteurs.getMatricule());
		}
	}

}
