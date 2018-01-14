package fr.hugog.game;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

public class GamePanel extends JPanel implements KeyListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see Element
     */
	Element[][] map;
	
	JLabel inventory = new JLabel("");
	Hero hero = new Hero();
	
	
	public GamePanel() {
		ArrayList<Element> elements = Map.initializeElement();
		this.map = initMap(elements);
		this.addKeyListener(this);
		this.requestFocusInWindow();		
		this.setFocusable(true);
	}
	
	/**
     * Paint the map with all the images for each element
     *
     * @param g
     */

	public void paintComponent(Graphics g){
		
		Map map = new Map();
		
		hero = (Hero) map.getMap()[0][0];
		
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
	    
	  }
	
	/**
     * Print the inventory of the player
     *
     * @param hero
     */
	
	public void printObjects(Hero hero) {
		inventory.setText("<html><div style='text-align: center;'><font size='20'>LifePoints : " + hero.getHealth() + " // Gold : " + hero.getGold() + " // Keys : " + hero.getKeys() + "</font></div></html>");
		inventory.setHorizontalAlignment(JLabel.CENTER);
		this.add(inventory, BorderLayout.PAGE_END);
	}
	
	/**
     * Initialize all the element randomly in the map
     *
     * @param element
     * @return map
     */
	
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
	
	/**
     * Initialize all the element on a array list
     *
     * @return elements
     */
	
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

	/**
     * Tell in the console which key are pressed when you use arrow key on the JFrame
     *
     * @param e
     */
	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_RIGHT){
				System.out.println("Right");
			}
		else if (keyCode == KeyEvent.VK_DOWN)
			System.out.println("Down");
		else if (keyCode == KeyEvent.VK_UP)
			System.out.println("Up");
		else if (keyCode == KeyEvent.VK_LEFT)
			System.out.println("Left");
		
	}


	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
     * Return hero
     *
     * @return hero
     */
	
	public Hero getHero() {
		return hero;
	}

}
