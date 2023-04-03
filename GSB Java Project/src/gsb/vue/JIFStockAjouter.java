package gsb.vue;

import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;
import gsb.service.MedicamentService;
import gsb.service.StockerService;
import gsb.service.VisiteurService;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JIFStockAjouter extends JInternalFrame implements ActionListener  {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel JLcodeVisiteur;
	private JLabel JLdepotLegal;
	private JLabel JLquantite;
	private JComboBox<String> jComboBoxMedicament;
	private JComboBox<String> jComboBoxVisiteur;
	private JTextField JTquantite;
	private JButton ajouterQuantiteBouton;
	protected JPanel p;  
	protected JPanel pTexte;

	
	public JIFStockAjouter() {
		
		
		Container contentPane = getContentPane();
        pTexte = new JPanel(new GridLayout(14,2));
        p = new JPanel();
        
		ajouterQuantiteBouton = new JButton ("Ajouter Quantité");
		ajouterQuantiteBouton.addActionListener(this);
		
		JLcodeVisiteur = new JLabel("Code Visiteur");
		jComboBoxVisiteur = new JComboBox<String>();
		ArrayList<String> listeCodeVisiteurs = VisiteurService.listeCodeVisiteurs();
		for(String codeVisiteur : listeCodeVisiteurs) {
			jComboBoxVisiteur.addItem(codeVisiteur);
		}
		
		JLdepotLegal = new JLabel("Dépot légal");
		jComboBoxMedicament = new JComboBox<String>();
		ArrayList<String> listeMedicaments = MedicamentService.listeDepotLegalMedicament();
		for(String medicament : listeMedicaments) {
			jComboBoxMedicament.addItem(medicament);
		}
		
		JLquantite = new JLabel("Quantité");
		JTquantite = new JTextField();
		
		pTexte.add(JLcodeVisiteur);
		pTexte.add(jComboBoxVisiteur);
		pTexte.add(JLdepotLegal);
		pTexte.add(jComboBoxMedicament);
		pTexte.add(JLquantite);
		pTexte.add(JTquantite);
		pTexte.add(ajouterQuantiteBouton);
		
		p.add(pTexte);
        contentPane.add(p);

		setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Ajouter une quantité de médicament");
		
	}
	
	public void actionPerformed(ActionEvent evt) { 
		Object source = evt.getSource();
		String ChoixOption = evt.getActionCommand();
		if (ChoixOption.equals("Ajouter Quantité")){
			String codeVisiteur = jComboBoxVisiteur.getSelectedItem().toString();
			String depotLegal = jComboBoxMedicament.getSelectedItem().toString();
			int quantite = Integer.parseInt(JTquantite.getText());
			
			if(quantite >= 0) {
			
				// Création d'un objet Medicament, Visiteur et Stocker 
				Medicament unMedicament = new Medicament(depotLegal, null, null, null, null, 0, null, null);
				Visiteur unVisiteur = new Visiteur(codeVisiteur,null,null,null,null,null,null,null,null,null,0,null);
				Stocker unStock = new Stocker(quantite, unVisiteur,unMedicament);
			
				// Vérifier si le stock existe déjà pour la paire visiteur/medicament donnée
				if(StockerService.checkIfExist(codeVisiteur, depotLegal)) {
				
					// Si la condition est vérifié, alors la paire existe déjà et il faut incrémenter le stock par la quantité reçue
					int result = StockerService.incrementationOfStock(codeVisiteur, depotLegal, quantite);
				
					System.out.println( result);
				
				}
				else  {
					// Création d'un stock avec la paire visiteur/medicament donnée, si la paire n'existe déjà pas
					int resultInput = StockerService.creerUnStock(unStock);
					if(resultInput == 1) {
						JOptionPane.showMessageDialog(null, "Le stock a bien été créé ou mis à jour.");
					}
					else {
						JOptionPane.showMessageDialog(null, "Un problème est survenu.");
					}
				}
			}
		else {
			JOptionPane.showMessageDialog(null, "La quantité de stock ne peut pas être négatif.");
		}
	} // fin actionPerformed
	}
}
