package gsb.tests;

import java.util.ArrayList;

import gsb.service.MedicamentService;

public class MedicamentDepotLegalCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> listeDepotLegalMedicament = new ArrayList<String>();

		listeDepotLegalMedicament = MedicamentService.listeDepotLegalMedicament();
		
		for(String depotLegal : listeDepotLegalMedicament) {
			System.out.println(depotLegal);
		}

	}

}
