package gsb.tests;
import gsb.modele.dao.VisiteurDao;
import gsb.modele.Visiteur;
import gsb.modele.Localite;

public class VisiteurDaoTestCreeVisiteur {

	public static void main(String[] args) {
		
		// Préparation des propriétés
		Localite uneLocalite = new Localite("44000", null);	
		Visiteur unVisiteur = new Visiteur("d88","LaPaix","Lycee","lapaix56","123456789","adresse","2005-12-21 00:00:00", "BO","SWISS","0102030405",10,uneLocalite);
		int resultat = 0;
		
		// Création d'un visiteur
		resultat = VisiteurDao.creerVisiteur(unVisiteur);
		System.out.println(resultat);
	}

}
