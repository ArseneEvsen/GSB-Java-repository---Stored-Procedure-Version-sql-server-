/*
 * Cr�� le 22 f�vr. 2015
 *
 * TODO Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
package gsb.modele.dao;

import gsb.modele.Localite;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * @author Isabelle
 * 22 f�vr. 2015
 * TODO Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
public class LocaliteDao {
	
	// Retourne un objet Localite grâce au codeLocalite transmis en paramètre
	public static Localite rechercher(String codeLocalite){
		Localite uneLocalite=null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from gsbjava.LOCALITE where CODEPOSTAL='"+codeLocalite+"'");
		try {
			if (reqSelection.next()) {
				uneLocalite = new Localite(reqSelection.getString(1), reqSelection.getString(2));	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requ�te - select * from gsbjava.LOCALITE where CODEPOSTAL='"+codeLocalite+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return uneLocalite;
	}

	//Cette méthode doit retourner les codes postaux autorisés pour la création d'un visiteur (les codes postaux étant des clés étrangères dans la table visiteur)
	public static ArrayList<String> listeCodesPostaux(){
		ArrayList<String> listeDesCodesPostaux = new ArrayList<String>();
		String request = "SELECT * FROM gsbjava.localite";
		
		// Exécution de la requête
		ResultSet reqSelection = ConnexionMySql.execReqSelection(request);
		
		try {
			while(reqSelection.next()) {
				// Pour tout les codes postaux reçu dans le résultat, les ajouter à la liste
				listeDesCodesPostaux.add(reqSelection.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Retourner la liste
		return listeDesCodesPostaux;
	}
}
