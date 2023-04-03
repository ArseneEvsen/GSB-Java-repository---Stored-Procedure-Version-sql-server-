package gsb.tests;

import java.util.ArrayList;

import gsb.modele.Medicament;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.VisiteurDao;

public class MedicamentDaoTest {
	public static void main(String[] args) {
		
		ArrayList<Medicament> collectionDesMedicaments = new ArrayList<Medicament>();
		
		collectionDesMedicaments = MedicamentDao.retournerCollectionDesMedicaments();
		
		for(Medicament unMedicament : collectionDesMedicaments ) {
		
			System.out.println(unMedicament.getCodeFamille());
			System.out.println(unMedicament.getComposition());
			System.out.println(unMedicament.getContreIndication());
			System.out.println(unMedicament.getDepotLegal());
			System.out.println(unMedicament.getEffets());
			System.out.println(unMedicament.getLibelleFamille());
			System.out.println(unMedicament.getNomCommercial());
			System.out.println(unMedicament.getPrixEchantillion());
			
		}
		
	}
	
}
