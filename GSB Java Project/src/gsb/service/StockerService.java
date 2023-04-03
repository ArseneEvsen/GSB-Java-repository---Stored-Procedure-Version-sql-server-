package gsb.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import gsb.modele.Stocker;
import gsb.modele.dao.ConnexionMySql;
import gsb.modele.dao.StockerDao;

public class StockerService {
	
	public static int creerUnStock (Stocker unStock) {
		int resultat = 0;
		try {
		if (unStock ==null) {
			throw new Exception("Donnee obligatoire : objet stock");
		}
		resultat = StockerDao.creerStock(unStock);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return resultat;
	}
	
	public static ArrayList<Stocker> retournerCollectionStockVisiteur(String unMatricule){
		ArrayList<Stocker> lesStocks = new ArrayList<Stocker>();
		try{
		
		lesStocks = StockerDao.retournerCollectionStockVisiteur(unMatricule);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return lesStocks;
	}

	public static boolean checkIfExist(String matricule, String codeMedicament) {
		boolean exist = false;
		
		// Vérification si la paire visiteur/medicament existe grâce à la méthode StockerDao.checkIfExist()
		if(StockerDao.checkIfStockExist(matricule, codeMedicament)) {
			exist = true;
		}
		
		// Si la paire existe déjà, la méthode retourne TRUE sinon FALSE
		return exist;
	}
	
	public static int incrementationOfStock(String matricule, String codeMedicament, int qteStock) {
		return StockerDao.incrementationOfStock(matricule, codeMedicament, qteStock);
	}
}
