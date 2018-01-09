package fr.hugog.game.map;

import java.util.ArrayList;
import java.util.Random;

import fr.hugog.game.Element.*;

public class Map {
	
	private int dimension;
	int randomPositionX, randomPositionY;
	/**
     * @see Element
     */
	Element[][] map;
	
	public Map() {
		this.dimension = 20;
		ArrayList<Element> elements = Map.initializeElement();
		this.map = initialiserCarte(elements);
	}
	
	/**
     * Return the dimension of the map
     *
     * @return dimension
     */
	
	public int getDimension() {
		return dimension;
	}
	
	/**
     * Return the map
     *
     * @return map
     */
	
	public Element[][] getMap() {
		return map;
	}
	
	/**
     * Update the map
     *
     * @param map
     */
	
	public void setMap(Element[][] map) {
		this.map = map;
	}
	
	/**
     * Initialize the map
     *
     * @param element
     * @return map
     */
	
	public Element[][] initialiserCarte(ArrayList<Element> element) {
		
		Element[][] map = new Element[dimension][dimension];
		Random random = new Random();
		int randomNumber;

		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
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
     * Initialize each element of the map to put them randomly in the map, once the basic map is generated
     *
     * @return elements
     */
		
	public static ArrayList<Element> initializeElement() {
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
     * Print the map
     */
	
	public void afficherCarte() {
			
		for (int i = 0; i < this.getDimension(); i++) {
			for (int j = 0; j < this.getDimension(); j++) {
				System.out.print(this.map[i][j].getSymbol());
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	/**
     * Print the inventory of the hero and his health
     * 
     * @param hero
     */
	
	public static void printInventory(Hero hero) {
		System.out.println();
		System.out.println("-----------");
		System.out.println();
		System.out.println("LifePoints : " + hero.getHealth() + " // Gold : " + hero.getGold() + " // Keys : " + hero.getKeys());
		System.out.println("Make your move : ");
	}
	
	/**
     * Return the nextElement in the map according to the movement of the hero
     * 
     * @param m, hero
     */
	
	public String getElement(int m, Hero hero) {
		
		try { 
			switch (m) {
			case 8: 
				return this.map[hero.getHeroX() - 1][hero.getHeroY()].getSymbol();
				
			case 2:
				return this.map[hero.getHeroX() + 1][hero.getHeroY()].getSymbol();
						
			case 4:
				return this.map[hero.getHeroX()][hero.getHeroY() - 1].getSymbol();
						
			case 6:
				return this.map[hero.getHeroX()][hero.getHeroY() + 1].getSymbol();
					
			case 0: 
				return "0";
			
			default:
				System.err.println("This mouvement ain't authorize");
				
			}
			return "9";
		
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		return "3";
     }

	
}
