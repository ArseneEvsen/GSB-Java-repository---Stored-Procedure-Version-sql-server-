package gsb.tests;

import java.util.ArrayList;

import gsb.service.VisiteurService;

public class listeDeroulanteCodeVisiteursTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> listeCodeVisiteurs = new ArrayList<String>();
		
		// Appel de la méthode à tester
		listeCodeVisiteurs = VisiteurService.listeCodeVisiteurs();
		
		// Affichage de la liste
		for (String codeVisiteur : listeCodeVisiteurs) {
			System.out.println(codeVisiteur);
		}
	}

}
