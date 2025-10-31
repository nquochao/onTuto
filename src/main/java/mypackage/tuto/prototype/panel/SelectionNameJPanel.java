package mypackage.tuto.prototype.panel;

import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import mypackage.tuto.prototype.Chat;
import mypackage.tuto.prototype.Position;

public class SelectionNameJPanel extends AbstractSelectionPanel {
	JTextField nameTextField;
	JList namePrefixList;
	JList genreList;

	public SelectionNameJPanel(JFrame frame, Chat heros) {
		super(frame, heros);
	}

	@Override
	protected void showLabels(Position p) {
	    // Create a list of strings
        List<String> items = new ArrayList<>();
        items.add("Petit");
        items.add("Petite");

        
        // Create a DefaultListModel to store the strings
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String item : items) {
            listModel.addElement(item);
        }
        
	    // Create a list of strings
        List<String> genreItems = new ArrayList<>();
        genreItems.add("Garçon");
        genreItems.add("Fille");

        
        // Create a DefaultListModel to store the strings
        DefaultListModel<String> genreListModel = new DefaultListModel<>();
        for (String item : genreItems) {
        	genreListModel.addElement(item);
        }
        

        // Create a JList and set its model to the DefaultListModel
		GridBagConstraints cs = new GridBagConstraints();
		namePrefixList = new JList<>(listModel);
		cs.fill = GridBagConstraints.HORIZONTAL;
		
		int x = 0, y = 0;

		x = 0;
		cs.gridx = x;
		cs.gridy = y;
		JLabel labelGenre = new JLabel();
		labelGenre.setText("Choisis ton genre");
		this.add(labelGenre, cs);
		x=x+1;
        
		cs = new GridBagConstraints();
		cs.fill = GridBagConstraints.HORIZONTAL;
		cs.gridx = x;
		cs.gridy = y;
		genreList = new JList(genreListModel);
		this.add(genreList, cs);

		y = y + 1;
		x=0;
		cs.gridx = x;
		cs.gridy = y;
		JLabel label = new JLabel();
		label.setText("Choisis ton préfixe");
		this.add(label, cs);
		x=x+1;
		cs = new GridBagConstraints();

		cs.gridx = x;
		cs.gridy = y;
		nameTextField = new JTextField();
		this.add(namePrefixList, cs);

		y = y + 1;
		x = 0;
		cs.gridx = x;
		cs.gridy = y;
		JLabel labelNom = new JLabel();
		label.setText("Choisis ton nom");
		this.add(labelNom, cs);
		x=x+1;
        
		cs = new GridBagConstraints();
		cs.fill = GridBagConstraints.HORIZONTAL;
		cs.gridx = x;
		cs.gridy = y;
		nameTextField = new JTextField();
		this.add(nameTextField, cs);

		y = y + 1;

		super.showLabels(new Position(x, y));
	}

	@Override
	protected int getLabelsCols() {
		return 2;
	}

	@Override
	public String getLabelsResourcesFolder() {
		return "panel/name";
	}

	@Override
	public AbstractSelectionPanel getNextPanel() {
		return new SelectionFinalJPanel(frame, heros);
		
	}

	@Override
	protected boolean updateHeros() {
		String name =namePrefixList.getSelectedValue()+" "+ nameTextField.getText().trim();
		heros.setName(name);
		heros.setGenre((String)genreList.getSelectedValue());
		return (namePrefixList.getSelectedValue()!=null&&genreList.getSelectedValue()!=null &&!nameTextField.getText().isEmpty());
	}

}
