/*
 * Cr�� le 23 f�vr. 2015
 *
 * TODO Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
package gsb.vue;

import gsb.modele.Medecin;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.VisiteurDao;
import gsb.service.MedecinService;
import gsb.service.VisiteurService;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;

/**
 * @author Isabelle 23 f�vr. 2015 TODO Pour changer le mod�le de ce commentaire
 *         de type g�n�r�, allez � : Fen�tre - Pr�f�rences - Java - Style de
 *         code - Mod�les de code
 */
public class JIFVisiteurListeDic extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	//private ArrayList<Medecin> lesMedecins;
	private HashMap<String,Visiteur> diccoVisiteur;


	protected JPanel p;
	protected JScrollPane scrollPane;
	protected JPanel pSaisie;
	protected JTextField JTcodeVisiteur;
	protected JButton JBafficherFiche;
	protected MenuPrincipal fenetreContainer;
	protected JTable table;

	public JIFVisiteurListeDic(MenuPrincipal uneFenetreContainer) {

		fenetreContainer = uneFenetreContainer;
		// r�cup�ration des donn�es Medecin dans la collection
		//lesMedecins = MedecinDao.retournerCollectionDesMedecins();

		//int nbLignes = lesMedecins.size();
		diccoVisiteur = VisiteurService.retournerDictionnaireDesVisiteurs();
		int nbLignes= diccoVisiteur.size();
		
		
		
		p = new JPanel(); // panneau principal de la fen�tre

		int i=0;
		String[][] data = new String[nbLignes][4] ;
		//for(Medecin unMedecin : lesMedecins){
		
		for (Entry<String, Visiteur> uneEntree : diccoVisiteur.entrySet()){
			data[i][0] = uneEntree.getValue().getMatricule();
			data[i][1] = uneEntree.getValue().getNom();
			data[i][2] = uneEntree.getValue().getPrenom();
			i++;
			}
		String[] columnNames = {"Matricule", "Nom","Prenom"};
		table = new JTable(data, columnNames);
		table.getSelectionModel().addListSelectionListener(table);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		p.add(scrollPane);
		
		pSaisie = new JPanel();
		JTcodeVisiteur = new JTextField(20);
		JTcodeVisiteur.setMaximumSize(JTcodeVisiteur.getPreferredSize());
		JBafficherFiche = new JButton("Afficher Fiche Visiteur");
		JBafficherFiche.addActionListener(this); // source d'�venement
		pSaisie.add(JTcodeVisiteur);
		pSaisie.add(JBafficherFiche);
		p.add(pSaisie);
		
		// mise en forme de la fen�tre
		Container contentPane = getContentPane();
		contentPane.add(p);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
   		if (source == JBafficherFiche){
   			if (diccoVisiteur.containsKey(JTcodeVisiteur.getText())){
   	   			Visiteur unVisiteur = diccoVisiteur.get(JTcodeVisiteur.getText());
   	   			fenetreContainer.ouvrirFenetre(new JIFVisiteurFiche(unVisiteur));
   			}
   		}
   		if (source == table) {
   		    int selectedRow = table.getSelectedRow();
   		    int matriculeColumnIndex = 0; // L'index de la colonne "Matricule"
   		    Object matriculeValue = table.getValueAt(selectedRow, matriculeColumnIndex);
   		    JTcodeVisiteur.setText(matriculeValue.toString());
   		}
	}
}
