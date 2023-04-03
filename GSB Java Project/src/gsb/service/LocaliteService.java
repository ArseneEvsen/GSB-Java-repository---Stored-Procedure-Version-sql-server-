package gsb.service;

import java.util.ArrayList;

import gsb.modele.dao.LocaliteDao;

public class LocaliteService {

	//Cette méthode doit retourner les codes postaux autorisés pour la création d'un visiteur (les codes postaux étant des clés étrangères dans la table visiteur)
		public static ArrayList<String> listeCodesPostaux(){
			return LocaliteDao.listeCodesPostaux();

			
		}
}
