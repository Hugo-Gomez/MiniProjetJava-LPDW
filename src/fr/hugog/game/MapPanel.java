package fr.hugog.game;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import fr.hugog.game.Element.Element;

public class MapPanel extends JPanel{
	
	/**
     * @see Element
     */
	Element[][] map;
	
	public void paintComponent(Graphics g) {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				try {

			      Image element = ImageIO.read(new File(this.map[i][j].getImageElement() + ".png"));

			      g.drawImage(element, 0, 0, this);

			    } catch (IOException e) {

			      e.printStackTrace();
			    }
			}
		}
	}

}
