package gsb.service;

import java.util.ArrayList;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

public class MedicamentService {
	
	public static ArrayList<String> listeDepotLegalMedicament() {
		ArrayList<String> listeDepotLegalMedicament = new ArrayList<String>();
		ArrayList<Medicament> listeMedecins = new ArrayList<Medicament>();
		
		// On récupére la collection des médecins
		listeMedecins = MedicamentDao.retournerCollectionDesMedicaments();
		
		// On extrait les codeMedicaments de la collection de medicaments reçue
		for(Medicament unMedicament : listeMedecins) {
			listeDepotLegalMedicament.add(unMedicament.getDepotLegal());
		}
		
		return listeDepotLegalMedicament;
	}

}
