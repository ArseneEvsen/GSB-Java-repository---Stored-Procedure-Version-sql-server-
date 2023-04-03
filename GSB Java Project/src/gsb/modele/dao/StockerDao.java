package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;

public class StockerDao {

	public static int creerStock (Stocker unStock) {
		Visiteur unVisiteur = unStock.getUnVisiteur();
		Medicament unMedicament = unStock.getUnMedicament();
		
		int resultat = ConnexionMySql.execReqMaj("insert into gsbjava.STOCK values ("+unStock.getQteStock()+",'"+unVisiteur.getMatricule()+"','"+unMedicament.getDepotLegal()+"')");
		return resultat;
	}
	
	public static ArrayList<Stocker> retournerCollectionStockVisiteur(String unMatricule) {
		ArrayList<Stocker> lesStocks = new ArrayList<Stocker>();
		Stocker unStock=null;
		Medicament unMedicament=null;
		Visiteur unVisiteur =null;
		
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from gsbjava.STOCK where MATRICULE ='"+unMatricule+"'");
			try {
				// Pour tout les résultats existant dans la table reqSelection, les parcourirs
				while (reqSelection.next()) {
				
					// Construction des objets avec les valeurs reçues dans la table reqSelection
					unMedicament = new Medicament(reqSelection.getString(3), null, null, null,null,0,null,null);
					unVisiteur = new Visiteur(reqSelection.getString(2), null,null,null,null,null,null,null,null,null,0,null);
					unStock = new Stocker(reqSelection.getInt(1),unVisiteur,unMedicament);
					lesStocks.add(unStock);
				}
			}
				catch(Exception e) {
					System.out.println("erreur reqSelection.next() pour la requ�te - select * from gsbjava.VISITEUR");
					e.printStackTrace();
					}
				ConnexionMySql.fermerConnexionBd();
				
		return lesStocks;
	}
	
	// Cette méthode a pour but de vérifier si un visiteur a un stock d'échantillion en particulier
	public static boolean checkIfStockExist(String matricule, String medicamentDepotLegal) {
		boolean exist = false;
		
		ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT * FROM gsbjava.stock WHERE MATRICULE = '"+matricule+"' AND MED_DEPOTLEGAL = '"+medicamentDepotLegal+"'");
		
		try {
			if(reqSelection.next()) {
				exist = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exist;
	}
		
	// Cette méthode a pour but d'incrémenter le stock d'échantillon d'un visiteur
	public static int incrementationOfStock(String matricule, String codeMedicament, int qteStock) {
		String request = "update gsbjava.STOCK set QTESTOCK = QTESTOCK + '"+qteStock+"' where MATRICULE = '"+matricule+"' AND MED_DEPOTLEGAL = '"+codeMedicament+"'";
		
		int result = ConnexionMySql.execReqMaj(request);
		
		return result;
	}
}

