package mypackage.tuto.prototype;

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

import javax.swing.JPanel;

public class SelectionChatJPanel extends JPanel {
	private static Logger logger = Logger.getAnonymousLogger();
	HaoTutotialFrame frame;
	Chat heros;

public SelectionChatJPanel(HaoTutotialFrame fram, Chat chat) {
	this.frame=fram;
	setLayout(new GridBagLayout());
	this.heros=chat;

	GridBagConstraints cs = new GridBagConstraints();
	cs.fill = GridBagConstraints.HORIZONTAL;
	cs.gridx = 0;
	cs.gridy = 0;
	logger.info("x, y: " + cs.gridx + " , " + cs.gridy + " " + "Jouer");
	
	try {
		try {
			HaoJLabels labels= loadTypesChat("chats/types");
			showLabels(labels);
			addEvent(labels);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

private void addEvent(HaoJLabels labels) {
	for (HaoJLabel label: labels) {

	label.addMouseListener(new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			heros.setType(label.getImage());
			SelectionChatJPanel panel = new SelectionChatJPanel(frame, heros);
			frame.setContentPane(panel);
			frame.setVisible(true);


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
}
}
private void showLabels(HaoJLabels labels) {
	int i=0;
	for (HaoJLabel label: labels) {

		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = (int) i % 2;
		c.gridy = 1 + (int) Math.floor(i / 2);
		logger.info("x, y: " + c.gridx + " , " + c.gridy + " " + label.getName());

		this.add(label, c);
		i++;

	}

	}

	


private HaoJLabels loadTypesChat(String folder) throws IOException, URISyntaxException {
	URL url=this.getClass().getResource("/"+folder);
	URI uri=url.toURI();
	Path myPath = Paths.get(uri);
	Stream<Path> walk = Files.walk(myPath, 1);
	HaoJLabels labels=new HaoJLabels();
	for (Iterator<Path> it = walk.iterator(); it.hasNext(); ) {
	    Path filename = it.next();   
	    String namefile=filename.getFileName().toString();
	    String image=folder+"/"+namefile;

	    logger.info("name of file : "+namefile);
	    logger.info("Image : "+image);
	    if(namefile.toLowerCase().endsWith("png")) {
	    HaoJLabel label=new HaoJLabel(namefile, image, null);
	    labels.add(label);
	}
	}
	return labels;
}


}
