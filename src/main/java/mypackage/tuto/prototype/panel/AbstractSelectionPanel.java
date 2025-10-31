package mypackage.tuto.prototype.panel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.logging.Logger;
import java.util.stream.Stream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import mypackage.tuto.prototype.beans.Chat;
import mypackage.tuto.prototype.beans.Position;
import mypackage.tuto.prototype.labels.HaoJLabel;
import mypackage.tuto.prototype.labels.HaoJLabels;

public abstract class AbstractSelectionPanel extends JPanel {

	protected static Logger logger = Logger.getAnonymousLogger();
	protected JFrame frame;
	protected Chat heros;
	HaoJLabels labels = new HaoJLabels();
	Boolean start;
	Position p=new Position(0,0);
	HaoJLabel selectedLabel;
	protected AbstractSelectionPanel nextPanel;
	JPanel contentPane;
	public AbstractSelectionPanel(JFrame fram, Chat chat) {
		start=false;
		this.frame = fram;
		
		setLayout(new GridBagLayout());
		if(chat!=null)this.heros = chat;
		else heros=new Chat();

        JScrollPane scrollPane = new JScrollPane(this);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(30, 30, 1200, 800);
        contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(1200, 800));
        contentPane.add(scrollPane);

        
		initLabels();
		showLabels(p);
		addEventToLabels();
	}
	public void show() {
		frame.setContentPane(contentPane);

	}
	protected void initLabels() {
		URL url = getLabelsResources();
		URI uri = null;
		try {
			uri = url.toURI();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Path myPath = Paths.get(uri);
		Stream<Path> walk = null;
		try {
			walk = Files.walk(myPath, 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HaoJLabels labels = new HaoJLabels();
		for (Iterator<Path> it = walk.iterator(); it.hasNext();) {
			Path filename = it.next();
			String namefile = filename.getFileName().toString();
			String image = getLabelsResourcesFolder() + "/" + namefile;

			logger.info("name of file : " + namefile);
			logger.info("Image : " + image);
			if (namefile.toLowerCase().endsWith("png")) {
				String value=namefile.replaceFirst("[.][^.]+$", "");
				HaoJLabel label = new HaoJLabel(value, image);
				labels.add(label);
			}
		}
		this.labels = labels;
	}

	public URL getLabelsResources() {
		return this.getClass().getResource("/" + getLabelsResourcesFolder());
	}
	public abstract String getLabelsResourcesFolder();

	public AbstractSelectionPanel() {
		super();
	}




	protected void showLabels(Position offset) {
		int nbcol=getLabelsCols();;
		int i = 0;

		for (HaoJLabel label : labels) {

			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = offset.getX()+(int) i % nbcol;
			c.gridy = offset.getY() + (int) Math.floor(i / nbcol);
			logger.info("x, y: " + c.gridx + " , " + c.gridy + " " + label.getImage());

			this.add(label, c);
			i++;

		}

	}
	
	public void addEventToLabels() {
		// TODO Auto-generated method stub

	
		for(HaoJLabel label: labels) {
		label.addMouseListener(new MouseListener() {

			private void bJouerPressed() {
				selectedLabel=label;
				boolean b=updateHeros();
				if(!b) {
					logger.info("Tu dois bien remplir les caractéristiques de ton chat");
					return; 
				}
				logger.info(heros.toString());
				/*TODO*/
				AbstractSelectionPanel panel = getNextPanel(); 
				panel.show();
				
				//frame.setContentPane(panel);
				frame.setVisible(true);
			}





			@Override
			public void mouseClicked(MouseEvent e) {
				bJouerPressed();

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		}}


	protected abstract AbstractSelectionPanel getNextPanel();
	protected abstract int getLabelsCols();
	protected boolean updateHeros() {
		return true;
	}
}