package gsb.tests.unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gsb.modele.Localite;
import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;
import gsb.service.StockerService;
import junit.framework.TestCase;

class StockerServiceTest extends TestCase {

	@BeforeEach
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Test
	void testCreerUnStock() {
		// Préparations des propriétés	
		Localite uneLocalite = new Localite("44000", null);	
		Visiteur unVisiteur = new Visiteur("a131","LaPaix","Lycee","lapaix56","123456789","adresse","2005-12-21 00:00:00", "BO","SWISS","0102030405",10,uneLocalite);
		Medicament unMedicament = new Medicament("CARTION6",null, null, null,null,0,null,null);
		Stocker unStock = new Stocker (3, unVisiteur, unMedicament);
		
		// Test unitaire
		assertEquals("Test d'une création de stock réussie", 1, StockerService.creerUnStock(unStock));
	}

	@Test
	void testRetournerCollectionStockVisiteur() {
		// Cas où le visiteur a bien une collection de stock
		assertNotNull(StockerService.retournerCollectionStockVisiteur("a131"));
	}

	@Test
	void testCheckIfExist() {
		assertTrue("Test où le visiteur a bien un stock donnée",StockerService.checkIfExist("a131", "3MYC7") );
	}

	@Test
	void testIncrementationOfStock() {
		assertEquals("test d'incrémentation d'un stock qui existe déjà", 1, StockerService.incrementationOfStock("a131", "3MYC7", 10));
	}

}
