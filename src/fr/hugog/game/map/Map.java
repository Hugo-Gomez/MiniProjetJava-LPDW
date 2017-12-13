package fr.hugog.game.map;

import java.util.ArrayList;
import java.util.Random;

import fr.hugog.game.Element.*;

public class Map {
	
	int dimension;
	int randomPositionX, randomPositionY;
	Element[][] map;
	
	public Map() {
		this.dimension = 20;
		ArrayList<Element> element = Map.initialiserElement();
		this.map = initialiserCarte(element);
	}
	
	public int getDimension() {
		return dimension;
	}
	
	public void resetRandom() {
		randomPositionX = (int)(Math.random() * (20-0)) + 0;
		randomPositionY = (int)(Math.random() * (20-0)) + 0;
	}
	
	public Element[][] initialiserCarte(ArrayList<Element> element) {
		
		Element[][] map = new Element[dimension][dimension];
		Random random = new Random();
		int nombreAleatoire;

		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				if (i == 0 && j == 0) {
					map[i][j] = new Hero();
				} else {
					nombreAleatoire = random.nextInt(element.size());
					map[i][j] = element.get(nombreAleatoire);
					element.remove(nombreAleatoire);
				}
			}
		}
		return map;
	}
		
	public static ArrayList<Element> initialiserElement() {
		ArrayList<Element> element = new ArrayList<>();
		for (int i = 0; i < 5 ; i++) {
			element.add(new Flower());
		}
		for (int i = 0; i < 5 ; i++) {
			element.add(new Tree());
		}
		for (int i = 0; i < 10 ; i++) {
			element.add(new Rock());
		}
		for (int i = 0; i < 3 ; i++) {
			element.add(new Key());
		}
		for (int i = 0; i < 3 ; i++) {
			element.add(new Lock());
		}
		for (int i = 0; i < 20 ; i++) {
			element.add(new Gold());
		}
		for (int i = 0; i < 10 ; i++) {
			element.add(new Trap());
		}
		for (int i = 0; i < 15 ; i++) {
			element.add(new Monster());
		}
		for (int i = 0; i < 329 ; i++) {
			element.add(new Grass());
		}
		return element;
	}
	
	public void afficherCarte() {
			
		for (int i = 0; i < this.getDimension(); i++) {
			for (int j = 0; j < this.getDimension(); j++) {
				System.out.print(this.map[i][j].getSymbol());
			}
			System.out.println();
		}
	}
	
	public Element[][] getMap() {
		return map;
}
	
}
