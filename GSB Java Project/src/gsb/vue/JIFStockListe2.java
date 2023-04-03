package gsb.vue;

import gsb.modele.Medecin;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.StockerDao;
import gsb.service.StockerService;
import gsb.service.VisiteurService;

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
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class JIFStockListe2 extends JInternalFrame implements ActionListener  {
	
	

	protected JPanel p;
	protected JScrollPane scrollPane;
	protected JTextField JTmatricule;
	protected MenuPrincipal fenetreContainer;
	protected JTable table;
	protected JComboBox listeDeroulante;
	
	public JIFStockListe2 (MenuPrincipal uneFenetreContainer) {

		fenetreContainer = uneFenetreContainer;
		
		p = new JPanel(); // panneau principal de la fen�tre

		int i=0;
		String[][] data = new String[i][3] ;
		String[] columnNames = {"Visiteur", "Medicament","Stock"};
		
		table = new JTable(data, columnNames);
		table.getSelectionModel().addListSelectionListener(table);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		p.add(scrollPane);
		
		JTmatricule = new JTextField(20);
		JTmatricule.setMaximumSize(JTmatricule.getPreferredSize());
		
		ArrayList<String> listeDeroulante = VisiteurService.listeCodeVisiteurs();
		JComboBox<String> jComboBox = new JComboBox<>();
		for(String choix : listeDeroulante) {
			jComboBox.addItem(choix);
		}
		jComboBox.addActionListener(this);
        p.add(jComboBox);
		
		// mise en forme de la fen�tre
		Container contentPane = getContentPane();
		contentPane.add(p);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox)e.getSource();		
		
		if (e.getSource() == cb) {
			
			// Récupération des stocks concernant le visiteur choisis
			ArrayList<Stocker> lesStocks = StockerService.retournerCollectionStockVisiteur(cb.getSelectedItem().toString());
			
			
			String[] columnNames = {"Visiteur", "Medicament", "Stock"};
			DefaultTableModel model = new DefaultTableModel(columnNames, 0);

			for (Stocker stock : lesStocks) {
			    String[] data = {stock.getUnVisiteur().getMatricule(), stock.getUnMedicament().getDepotLegal(), String.valueOf(stock.getQteStock())};
			    model.addRow(data);
			}

			table.setModel(model);
			
			

		}
			
   		
	}
	
}
