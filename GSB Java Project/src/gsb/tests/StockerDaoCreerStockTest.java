package gsb.tests;

import gsb.modele.dao.StockerDao;
import gsb.modele.Localite;
import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteurDao;

public class StockerDaoCreerStockTest {

	public static void main(String[] args) {
		Localite uneLocalite = new Localite("44000", null);	
		Visiteur unVisiteur = new Visiteur("a131","LaPaix","Lycee","lapaix56","123456789","adresse","2005-12-21 00:00:00", "BO","SWISS","0102030405",10,uneLocalite);
		Medicament unMedicament = new Medicament("3MYC7",null, null, null,null,0,null,null);
		Stocker unStock = new Stocker (3, unVisiteur, unMedicament);
		int resultat = 0;
		
		// Création d'un visiteur
		resultat = StockerDao.creerStock(unStock);
		System.out.println(resultat);

	}

}
