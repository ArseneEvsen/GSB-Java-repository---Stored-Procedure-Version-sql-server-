package gsb.tests;

import java.util.*;

import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteurDao;

public class VisiteurDaoHashMapTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			HashMap<String, Visiteur> diccoDesVisiteurs = new HashMap<String, Visiteur>();
			diccoDesVisiteurs = VisiteurDao.retournerDictionnaireDesVisiteurs();
			
			System.out.println(diccoDesVisiteurs);		
	}

}
