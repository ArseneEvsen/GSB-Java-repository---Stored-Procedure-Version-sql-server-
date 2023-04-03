package gsb.vue;

import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.modele.Visiteur;
import gsb.service.LocaliteService;
import gsb.service.VisiteurService;
import gsb.utils.DateLabelFormatter;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.jdatepicker.DateModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import java.util.Date;
import java.util.Properties;

public class JIFVisiteurAjouter extends JIFVisiteur implements ActionListener  {
	
	private static final long serialVersionUID = 1L;
	Visiteur unVisiteur;
	Localite uneLocalite;
	
	private JLabel JLlogin;
	private JLabel JLmdp;
	
	private JTextField JTlogin;
	private JPasswordField JTmdp;
	private JComboBox<String> JCListeCodePostaux;
	private JButton ajouterBouton;
	private UtilDateModel model;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;
	
	public JIFVisiteurAjouter() {
		super();
		ajouterBouton = new JButton ("Ajouter");
		ajouterBouton.addActionListener(this);
		
		JLlogin = new JLabel("Login");
		JLmdp = new JLabel("Mot de passe");
		
		JTlogin = new JTextField();
		JTmdp = new JPasswordField();
		
		// Liste déroulante pour les codes postaux
		JCListeCodePostaux = new JComboBox<String>();
		ArrayList<String> listeCodesPostaux = LocaliteService.listeCodesPostaux();
		for(String codePostal : listeCodesPostaux) {
			JCListeCodePostaux.addItem(codePostal);
		}
		// Mise en place du calendrier pour la saisie de la date d'entrée 
		model = new UtilDateModel();
		
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(model, p);
		
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		
		// Puisque cette vue hérite de la vue Visiteur, tout les components sont remove pour pouvoir les remettres dans l'ordre nécessaire à cette vue
        pTexte.remove(JLmatricule);
        pTexte.remove(JTmatricule);
        pTexte.remove(JLnom);
        pTexte.remove(JTnom);
        pTexte.remove(JLprenom);
        pTexte.remove(JTprenom);
        pTexte.remove(JLadresse);
        pTexte.remove(JTadresse);
        pTexte.remove(JLcodePostal);
        pTexte.remove(JTcodePostal);
        pTexte.remove(JLcodeUnite);
        pTexte.remove(JTcodeUnite);
        pTexte.remove(JLdateEntree);
        pTexte.remove(JTdateEntree);
        pTexte.remove(JLtelephone);
        pTexte.remove(JTtelephone);
        pTexte.remove(JLnomUnite);
        pTexte.remove(JTnomUnite);
        pTexte.remove(JLprime);
        pTexte.remove(JTprime);
        
        // Ajout des components à la vue avec l'ordre et les ajouts nécessaires
        pTexte.add(JLmatricule);
        pTexte.add(JTmatricule);
        pTexte.add(JLnom);
        pTexte.add(JTnom);
        pTexte.add(JLprenom);
        pTexte.add(JTprenom);
        pTexte.add(JLadresse);
        pTexte.add(JTadresse);
        pTexte.add(JLcodePostal);
        pTexte.add(JCListeCodePostaux);
        pTexte.add(JLcodeUnite);
        pTexte.add(JTcodeUnite);
        pTexte.add(JLdateEntree);
		pTexte.add(datePicker);
        pTexte.add(JLtelephone);
        pTexte.add(JTtelephone);
        pTexte.add(JLnomUnite);
        pTexte.add(JTnomUnite);
        pTexte.add(JLprime);
        pTexte.add(JTprime);
		pTexte.add(JLlogin);
		pTexte.add(JTlogin);
		pTexte.add(JLmdp);
		pTexte.add(JTmdp);
		pBoutons.add(ajouterBouton);
		// Ce component est enlevé car remplaçé par la liste déroulante
		pTexte.remove(JTcodePostal);
		
		JTprime.setText("0");
		Date date = new Date();
		JLdateEntree.setText("Date d'entrée");
		
        setTitle("Ajouter un visiteur");
		
	}
	
	public void actionPerformed(ActionEvent evt) { 
		Object source = evt.getSource();
		String ChoixOption = evt.getActionCommand();
   		if (ChoixOption.equals("Ajouter")){
   			// Récupération des valeurs dans les champs de saisies
   			Date dateSelectionnee = (Date) datePicker.getModel().getValue();
   			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
   			String date = dateFormat.format(dateSelectionnee);  
   			

   			
   			
   			
   			
   			uneLocalite = new Localite(JCListeCodePostaux.getSelectedItem().toString(), null);
   			
   			unVisiteur = new Visiteur (
   			JTmatricule.getText(),
   			JTnom.getText(),
   			JTprenom.getText(),
   			JTlogin.getText(),
   			JTmdp.getText(),
   			JTadresse.getText(),
   			date,
   			JTcodeUnite.getText(),
   			JTnomUnite.getText(),
   			JTtelephone.getText(),
   			Integer.parseInt(JTprime.getText()),
   			uneLocalite
   			);
   			
   			
   			if(unVisiteur.getMatricule() == null || unVisiteur.getMatricule().length() == 0 ) {
   				JOptionPane.showMessageDialog(null, "Le matricule doit être renseigné.");
   			}
   			else if(unVisiteur.getMatricule().length() > 5 ) {
   				JOptionPane.showMessageDialog(null, "La longueur du matricule ne peut pas excéder 4 charactères.");
   			}
   			
   			else if(unVisiteur.getCodeUnite() == null || unVisiteur.getCodeUnite().length() == 0) {
   				JOptionPane.showMessageDialog(null, "Le Code Unite doit être renseigné.");
   			}
   			else if (VisiteurService.checkIfVisiteurExist(unVisiteur.getMatricule())) {
   			// Vérification si le visiteur n'existe pas déjà en base de donnée
   				JOptionPane.showMessageDialog(null, "Le visiteur existe déjà.");
   				System.out.println("Le visiteur existe déjà.");
   			}
   			else {
   				// Création du visiteur avec l'appelle de la procédure stocké en bdd prévue pour 
   				VisiteurService.createVisitorWithStoredProcedure(unVisiteur);
   			
   				/*
   			// Si les vérifications sont remplis alors créer un visiteur
   				if(VisiteurService.creerUnVisiteur(unVisiteur) == 0 ) {
   					JOptionPane.showMessageDialog(null, "Un problème est survenu, veuillez vérifier que tout les champs sont bien et correctement rempli.");
   				}
   				else {
   					JOptionPane.showMessageDialog(null, "Le visiteur a bien été créé.");
   				}
   				*/
   					
   			}
   		}
		
	} // fin actionPerformed
		
}
