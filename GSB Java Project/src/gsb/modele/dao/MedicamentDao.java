package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gsb.modele.Medicament;

public class MedicamentDao {

	public static ArrayList<Medicament> retournerCollectionDesMedicaments(){
		// Déclaration de la collection qui va contenir les objets Medicament
		ArrayList<Medicament> collectionDesMedicaments = new ArrayList<Medicament>();
		
		// Récupération de tout les enregistrements de la table Medicament
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * FROM gsbjava.MEDICAMENT ");
		try{
		while (reqSelection.next()) {
			// Déclaration d'un objet Medicament que l'ont va instancier grâce aux résultats de la requête
			String medDepotLegal = reqSelection.getString(1);
			String medNomCommercial = reqSelection.getString(2);
			String medComposition = reqSelection.getString(3);
			String medEffets = reqSelection.getString(4);
			String medContreIndications = reqSelection.getString(5);
			float medPrixEchantillion = reqSelection.getFloat(6);
			String codeFamille = reqSelection.getString(7);
			String libelleFamille = reqSelection.getString(8);
			
			Medicament unMedicament = new Medicament(medDepotLegal,medNomCommercial,medComposition,medEffets,medContreIndications,medPrixEchantillion,codeFamille,libelleFamille);
			
		    collectionDesMedicaments.add(unMedicament);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesMedecins()");
		}
		return collectionDesMedicaments;
	}
}
