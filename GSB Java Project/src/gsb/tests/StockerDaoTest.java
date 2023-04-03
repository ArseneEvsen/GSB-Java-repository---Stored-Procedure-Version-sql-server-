package gsb.tests;

import java.util.ArrayList;

import gsb.modele.Stocker;
import gsb.modele.dao.StockerDao;

public class StockerDaoTest {


		public static void main(String[] args) {
			// Préparation de l'array qui va contenir la liste des visiteurs de la BDD
			ArrayList<Stocker> lesStocks = new ArrayList<Stocker>();
			
			// Appel de la méthode de VisiteurDao, qui permet de retourner TOUT les visiteurs de la BDD
			lesStocks = StockerDao.retournerCollectionStockVisiteur("a131");
			
			// Affichage de tout les visiteurs de la collection
			for (Stocker listeStocks : lesStocks) {
				System.out.println(listeStocks.getQteStock());
			}
		}
	
}
