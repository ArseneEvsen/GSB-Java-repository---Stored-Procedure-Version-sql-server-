/*
 * Cr�� le 22 f�vr. 2015
 *
 * TODO Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
package gsb.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * @author Isabelle 22 f�vr. 2015 TODO Pour changer le mod�le de ce commentaire
 *         de type g�n�r�, allez � : Fen�tre - Pr�f�rences - Java - Style de
 *         code - Mod�les de code
 */
public class MenuPrincipal extends JFrame implements ActionListener {

	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 2591453837113855452L;

	protected JInternalFrame myJInternalFrame;
	protected JDesktopPane desktopPane;
	protected JMenuBar mbar;
	protected JMenu mMedecins;
	protected JMenu mMedicaments;
	protected JMenu mVisiteurs;
	protected JMenu mStock;


	JMenu mVisites;

	/**
	 * 
	 */
	public MenuPrincipal() {

		myJInternalFrame = new JInternalFrame(); // pour affichage d'une seule
													// JInternalFrame � la fois
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.gray);
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);

		setTitle("GSB");
		setSize(600, 500);
		
		

		// Ajout d'une barre de menus � la fen�tre
		mbar = new JMenuBar();
		mMedecins = new JMenu("Medecins");
		JMenuItem mC1 = new JMenuItem("Consultation Medecin");
		mC1.addActionListener(this); // installation d'un �couteur d'action
		mMedecins.add(mC1);
		JMenuItem mC2 = new JMenuItem("Liste Medecins");
		mC2.addActionListener(this);
		mMedecins.add(mC2);

		mMedicaments = new JMenu("Medicaments");
		JMenuItem mE1 = new JMenuItem("Consultation Medicament");
		mE1.addActionListener(this); // installation d'un �couteur d'action
		mMedicaments.add(mE1);
		JMenuItem mE2 = new JMenuItem("Ajout Medicaments");
		mE2.addActionListener(this);
		mMedicaments.add(mE2);

		mVisites = new JMenu("Visites");
		JMenuItem mA1 = new JMenuItem("Consultation Visite");
		mE1.addActionListener(this); // installation d'un �couteur d'action
		mVisites.add(mA1);
		JMenuItem mA2 = new JMenuItem("Ajout Visite");
		mA2.addActionListener(this);
		mVisites.add(mA2);
		
		mVisiteurs = new JMenu("Visiteurs");
		JMenuItem mV1 = new JMenuItem("Liste des visiteurs");
		mV1.addActionListener(this); // installation d'un �couteur d'action
		mVisiteurs.add(mV1);
		JMenuItem mV2 = new JMenuItem("Ajouter un visiteur");
		mV2.addActionListener(this); // installation d'un �couteur d'action
		mVisiteurs.add(mV2);
		JMenuItem mV3 = new JMenuItem("Ajouter un responsable");
		mV3.addActionListener(this); // installation d'un �couteur d'action
		mVisiteurs.add(mV3);
		
		mStock = new JMenu("Stocker");
		JMenuItem mS1 = new JMenuItem("Liste des échantillons");
		mS1.addActionListener(this); // installation d'un �couteur d'action
		mStock.add(mS1);
		JMenuItem mS2 = new JMenuItem("Ajouter un échantillion");
		mS2.addActionListener(this); // installation d'un �couteur d'action
		mStock.add(mS2);
		
		
		mbar.add(mMedecins);
		mbar.add(mMedicaments);
		mbar.add(mVisites);
		mbar.add(mVisiteurs);
		mbar.add(mStock);
		
		setJMenuBar(mbar);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		
		if (evt.getSource() instanceof JMenuItem) {
			String ChoixOption = evt.getActionCommand();

			if (ChoixOption.equals("Consultation Medecin")) {
				// Creation d'une sous-fenetre
				ouvrirFenetre(new JIFMedecinCons());

			} else if (ChoixOption.equals("Liste Medecins")) {
				ouvrirFenetre(new JIFMedecinListeDic(this));
			}
			
			else if (ChoixOption.equals("Liste des visiteurs")) {
				ouvrirFenetre(new JIFVisiteurListeDic(this));
			}
			
			else if(ChoixOption.equals("Ajouter un visiteur")) {
				ouvrirFenetre(new JIFVisiteurAjouter());
			}
			
			else if(ChoixOption.equals("Ajouter un responsable")) {
				ouvrirFenetre(new JIFAjouterResponsable());
			}

			else if(ChoixOption.equals("Liste des échantillons")) {
				ouvrirFenetre(new JIFStockListe2(this));
			}
			
			else if(ChoixOption.equals("Ajouter un échantillion")) {
				ouvrirFenetre(new JIFStockAjouter());
			}
		}
		
		
		
		

	}

	public void ouvrirFenetre(JInternalFrame uneFenetre) {
		myJInternalFrame.dispose(); // si une fen�tre �tait dej� affich�e, elle
									// est lib�r�e
		myJInternalFrame = uneFenetre;
		myJInternalFrame.setVisible(true);
		myJInternalFrame.setResizable(true);
		myJInternalFrame.setMaximizable(true);
		myJInternalFrame.setClosable(true);
		myJInternalFrame.setSize(600, 500);
		desktopPane.add(myJInternalFrame);
	}

}
