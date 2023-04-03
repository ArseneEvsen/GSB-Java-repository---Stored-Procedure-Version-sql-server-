package gsb.vue;

import gsb.modele.Medecin;
import gsb.modele.Visiteur;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JIFVisiteur extends JInternalFrame  {
	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel p;  
	protected JPanel pTexte;
	protected JPanel pBoutons;
	

	protected JLabel JLmatricule;
	protected JLabel JLnom;
	protected JLabel JLprenom;
	protected JLabel JLadresse;
	protected JLabel JLcodeUnite;
    protected JLabel JLdateEntree;
    protected JLabel JLtelephone;
    protected JLabel JLnomUnite;
    protected JLabel JLprime;
    protected JLabel JLcodePostal;
    
	protected JTextField JTmatricule;
	protected JTextField JTnom;
	protected JTextField JTprenom;
	protected JTextField JTadresse;
	protected JTextField JTcodeUnite;
    protected JTextField JTdateEntree;
    protected JTextField JTtelephone;
    protected JTextField JTnomUnite;
    protected JTextField JTprime;
    protected JTextField JTcodePostal;
	
    public JIFVisiteur() {
    	p = new JPanel();  // panneau principal de la fen�tre
        pBoutons = new JPanel();    // panneau supportant les boutons
        pTexte = new JPanel(new GridLayout(14,2));
    	
        JLmatricule = new JLabel("Matricule");
         JLnom = new JLabel("Nom");
         JLprenom = new JLabel("Prénom");
         JLadresse = new JLabel("Adresse rue");
         JLcodePostal = new JLabel("Code Postal");
         JLcodeUnite = new JLabel("Code unité");
         JLdateEntree = new JLabel("Date d'entrée");
         JLtelephone = new JLabel("Téléphone");
         JLnomUnite = new JLabel("Nom d'unitée");
         JLprime = new JLabel("Prime");
         
         JTmatricule = new JTextField(20);
         JTmatricule.setMaximumSize(JTmatricule.getPreferredSize());
         JTnom = new JTextField();
         JTprenom = new JTextField();
         JTadresse = new JTextField();    
         JTcodeUnite = new JTextField();
         JTdateEntree = new JTextField();
         JTtelephone = new JTextField();
         JTnomUnite = new JTextField();
         JTprime = new JTextField();
         JTcodePostal = new JTextField();
         
         pTexte.add(JLmatricule);
         pTexte.add(JTmatricule);
         pTexte.add(JLnom);
         pTexte.add(JTnom);
         pTexte.add(JLprenom);
         pTexte.add(JTprenom);
         pTexte.add(JLadresse);
         pTexte.add(JTadresse);
         pTexte.add(JLcodePostal);
         pTexte.add(JTcodePostal);
         pTexte.add(JLcodeUnite);
         pTexte.add(JTcodeUnite);
         pTexte.add(JLdateEntree);
         pTexte.add(JTdateEntree);
         pTexte.add(JLtelephone);
         pTexte.add(JTtelephone);
         pTexte.add(JLnomUnite);
         pTexte.add(JTnomUnite);
         pTexte.add(JLprime);
         pTexte.add(JTprime);
		
        // mise en forme de la fen�tre

         p.add(pTexte);
         p.add(pBoutons);
         Container contentPane = getContentPane();
         contentPane.add(p);

	}
    
    public void remplirText(Visiteur unVisiteur) 	
    {  // m�thode qui permet de remplir les zones de texte � partir des valeurs pass�es en param�tres
        JTmatricule.setText(unVisiteur.getMatricule());        
        JTnom.setText(unVisiteur.getNom());
        JTprenom.setText(unVisiteur.getPrenom());
        JTadresse.setText(unVisiteur.getAdresse());
        JTcodePostal.setText(unVisiteur.getUneLocalite().getCodePostal());
        JTcodeUnite.setText(unVisiteur.getCodeUnite());
        JTdateEntree.setText(unVisiteur.getDateEntree());
        JTtelephone.setText(unVisiteur.getTelephone());
        JTnomUnite.setText(unVisiteur.getNomUnite());
        Integer y = new Integer(unVisiteur.getPrime());
        y.toString();
        JTprime.setText(y.toString());
     }
     
      public void viderText() 	
    {  // m�thode qui permet de vider les zones de texte 
    	JTmatricule.setText("");        
        JTnom.setText("");
        JTprenom.setText("");
        JTadresse.setText("");    
        JTcodeUnite.setText("");
        JTdateEntree.setText("");
        JTtelephone.setText("");
        JTnomUnite.setText("");
        JTprime.setText("");
     }
          
}
