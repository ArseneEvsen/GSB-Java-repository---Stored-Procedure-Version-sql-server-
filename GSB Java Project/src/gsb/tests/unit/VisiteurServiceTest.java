package gsb.tests.unit;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gsb.modele.Localite;
import gsb.modele.Visiteur;
import gsb.service.VisiteurService;
import junit.framework.TestCase;

class VisiteurServiceTest extends TestCase {
	Visiteur unVisiteur = null;

	@BeforeEach
	protected void setUp() throws Exception {
		super.setUp();
		
		
	}

	@Test
	void testRechercherVisiteur() {
		assertEquals("Test rechercher visiteur","a131", VisiteurService.rechercherVisiteur("a131").getMatricule());
	}

	@Test
	void testCreerUnVisiteur() {
		Localite uneLocalite = new Localite("44000", null);	
		Visiteur unVisiteur = new Visiteur("c456","LaPaix","Lycee","lapaix56","123456789","adresse","2005-12-21 00:00:00", "BO","SWISS","0102030405",10,uneLocalite);
		assertEquals("Test Créer un Visiteur", 1, VisiteurService.creerUnVisiteur(unVisiteur));
	}

	@Test
	void testRetournerCollectionVisiteur() {
		ArrayList<Visiteur> lesVisiteurs = null;
		assertNotNull(lesVisiteurs = VisiteurService.retournerCollectionVisiteur());
	}

	@Test
	void testRetournerDictionnaireDesVisiteurs() {
		HashMap<String, Visiteur> diccoDesVisiteurs = null;
		assertNotNull(diccoDesVisiteurs = VisiteurService.retournerDictionnaireDesVisiteurs());
	}

	@Test
	void testListeCodeVisiteurs() {
		ArrayList<String> listeCodeVisiteurs = null;
		assertNotNull(listeCodeVisiteurs = VisiteurService.listeCodeVisiteurs());
	}

	@Test
	void testCheckIfVisiteurExist() {
		assertTrue("Test cas où le visiteur existe", VisiteurService.checkIfVisiteurExist("a131"));
	}

}
