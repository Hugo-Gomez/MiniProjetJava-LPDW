package fr.hugog.game;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.hugog.game.Element.Element;
import fr.hugog.game.Element.Flower;
import fr.hugog.game.Element.Gold;
import fr.hugog.game.Element.Grass;
import fr.hugog.game.Element.Hero;
import fr.hugog.game.Element.Key;
import fr.hugog.game.Element.Lock;
import fr.hugog.game.Element.Monster;
import fr.hugog.game.Element.Rock;
import fr.hugog.game.Element.Trap;
import fr.hugog.game.Element.Tree;
import fr.hugog.game.map.Map;

public class GamePanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see Element
     */
	Element[][] map;
	
	JLabel inventory = new JLabel("");
	

	public void paintComponent(Graphics g){
		
		ArrayList<Element> elements = Map.initializeElement();
		
		this.map = initMap(elements);
		
		Map map = new Map();
		
		Hero hero = (Hero) map.getMap()[0][0];
		
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				try {

			      Image element = ImageIO.read(new File(this.map[i][j].getImageElement() + ".png"));

			      g.drawImage(element, i*40, j*40, this);

			    } catch (IOException e) {

			      e.printStackTrace();
			    }
			}
		}
		
		this.printObjects(hero);
	    
	  }
	
	public void printObjects(Hero hero) {
		inventory.setText("LifePoints : " + hero.getHealth() + " // Gold : " + hero.getGold() + " // Keys : " + hero.getKeys());
		this.add(inventory, BorderLayout.PAGE_END);
	}
	
	public Element[][] initMap(ArrayList<Element> element) {
		
		Element[][] map = new Element[20][20];
		Random random = new Random();
		int randomNumber;

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (i == 0 && j == 0) {
					map[i][j] = new Hero();
				} else {
					randomNumber = random.nextInt(element.size());
					map[i][j] = element.get(randomNumber);
					element.remove(randomNumber);
				}
			}
		}
		return map;
	}
	
	public static ArrayList<Element> initElement() {
		ArrayList<Element> elements = new ArrayList<>();
		for (int i = 0; i < 5 ; i++) {
			elements.add(new Flower());
		}
		for (int i = 0; i < 5 ; i++) {
			elements.add(new Tree());
		}
		for (int i = 0; i < 10 ; i++) {
			elements.add(new Rock());
		}
		for (int i = 0; i < 3 ; i++) {
			elements.add(new Key());
		}
		for (int i = 0; i < 3 ; i++) {
			elements.add(new Lock());
		}
		for (int i = 0; i < 20 ; i++) {
			elements.add(new Gold());
		}
		for (int i = 0; i < 10 ; i++) {
			elements.add(new Trap());
		}
		for (int i = 0; i < 15 ; i++) {
			elements.add(new Monster());
		}
		for (int i = 0; i < 329 ; i++) {
			elements.add(new Grass(0, 0));
		}
		return elements;
	}

}
