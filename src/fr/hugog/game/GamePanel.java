package fr.hugog.game;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	

	public void paintComponent(Graphics g){
		
		try {

		      Image bg = ImageIO.read(new File("beige-bg.jpg"));

		      g.drawImage(bg, 0, 0, this);

		    } catch (IOException e) {

		      e.printStackTrace();

		    }
	    
	  }  

}
