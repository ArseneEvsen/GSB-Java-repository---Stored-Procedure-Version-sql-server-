package gsb.vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import gsb.service.LocaliteService;
import gsb.service.VisiteurService;

public class JIFAjouterResponsable extends JInternalFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    protected JPanel p;
    protected JLabel JLvisiteur;
    protected JLabel JLresponsable;
    private JComboBox<String> JComboBoxVisiteur;
    private JComboBox<String> JComboBoxResponsable;
    private JButton buttonAdd;

    public JIFAjouterResponsable() {
        // Initialisation des attributs
        p = new JPanel(new GridBagLayout()); // panneau principal de la fenêtre
        JLvisiteur = new JLabel("Visiteur :");
        JLresponsable = new JLabel("Responsable :");
        buttonAdd = new JButton("Ajouter");
        buttonAdd.addActionListener(this);

        // Configuration des listes déroulantes
        JComboBoxVisiteur = new JComboBox<String>();
        ArrayList<String> listeVisiteurs = VisiteurService.listeCodeVisiteurs();
        for (String visiteur : listeVisiteurs) {
            JComboBoxVisiteur.addItem(visiteur);
        }

        JComboBoxResponsable = new JComboBox<String>();
        ArrayList<String> listesResponsables = VisiteurService.listeCodeVisiteurs();
        for (String responsable : listesResponsables) {
            JComboBoxResponsable.addItem(responsable);
        }

        // Ajouts des éléments au panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        p.add(JLvisiteur, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        p.add(JComboBoxVisiteur, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        p.add(JLresponsable, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        p.add(JComboBoxResponsable, gbc);

        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        p.add(buttonAdd, gbc);

        // Mise en place finale de la fenêtre
        Container contentPane = (JPanel) getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(p, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	Object source = e.getSource();
		String ChoixOption = e.getActionCommand();
   		if (ChoixOption.equals("Ajouter")) {
   			String codeVisiteur = JComboBoxVisiteur.getSelectedItem().toString();
			String codeResponsable = JComboBoxResponsable.getSelectedItem().toString();
			
			// Service création du responsable 
			VisiteurService.assignerUnResponsable(codeResponsable, codeVisiteur);
   		}
    }
}
