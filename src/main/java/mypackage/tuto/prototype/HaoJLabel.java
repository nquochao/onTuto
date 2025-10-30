package mypackage.tuto.prototype;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class HaoJLabel extends JLabel {
	

	
	private ClansExistants clan;
	private String image;

	public ClansExistants getClan() {
		return clan;
	}

	public void setClan(ClansExistants clan) {
		this.clan = clan;
	}

	public HaoJLabel(String value, String image, ClansExistants clan) {
		super(value);
		this.clan=clan;
		setFont(new Font("Arial", Font.PLAIN,20));
		setHorizontalTextPosition(JLabel.CENTER);
		setVerticalTextPosition(JLabel.BOTTOM);
		setPreferredSize(new Dimension(400, 300));
		this.image=image;
		URL url=getClass().getResource("/"+image);
	    try {
	    
	    Image img = ImageIO.read(url);
	    Image resizedImg=img.getScaledInstance((int)getPreferredSize().getWidth()/2, (int)getPreferredSize().getHeight()/2, Image.SCALE_SMOOTH);
	    ImageIcon icon=new ImageIcon(resizedImg);
	    this.setIcon(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		

	}
	}

	public String getImage() {
		// TODO Auto-generated method stub
		return image;
	}
	
	
	 
	
	}

