package mypackage.tuto.prototype;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
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

import javax.swing.JPanel;

public abstract class AbstractSelectionPanel extends JPanel {

	protected static Logger logger = Logger.getAnonymousLogger();
	protected HaoTutotialFrame frame;
	protected Chat heros;
	HaoJLabels labels = new HaoJLabels();
	Boolean start;
	Position p=new Position(0,0);
	HaoJLabel selectedLabel;
	public AbstractSelectionPanel(HaoTutotialFrame fram, Chat chat) {
		start=false;
		this.frame = fram;
		setLayout(new GridBagLayout());
		if(chat!=null)this.heros = chat;
		else heros=new Chat();
		
		initLabels();
		showLabels(p);
		addEventToLabels();
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
				HaoJLabel label = new HaoJLabel(value, image, null);
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

	public AbstractSelectionPanel(LayoutManager layout) {
		super(layout);
	}

	public AbstractSelectionPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public AbstractSelectionPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
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
				labels.setVisible(false);
				/*TODO*/
				selectedLabel=label;
				updateHeros();
				logger.info(heros.toString());
				AbstractSelectionPanel panel = getNextPanel(); 
				frame.setContentPane(panel);
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
	protected abstract void updateHeros() ;
}