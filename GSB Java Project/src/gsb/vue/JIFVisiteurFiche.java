/*
 * Cr�� le 2 mars 2015
 *
 * TODO Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
package gsb.vue;



import java.awt.event.ActionEvent;

import javax.swing.JButton;

import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;
import gsb.service.StockerService;

/**
 * @author Isabelle
 * 2 mars 2015
 * TODO Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
public class JIFVisiteurFiche extends JIFVisiteur {

	private static final long serialVersionUID = 1L;

	public JIFVisiteurFiche(Visiteur unVisiteur) {
		super();
		this.remplirText(unVisiteur);
				
	}
	

}
