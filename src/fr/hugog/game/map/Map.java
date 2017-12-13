package fr.hugog.game.map;

import fr.hugog.game.Element.*;

public class Map {
	
	int dimension;
	int randomPositionX, randomPositionY;
	Element[][] map;
	
	public Map() {
		this.dimension = 20;
		this.map = initialiserCarte();
	}
	
	public int getDimension() {
		return dimension;
	}
	
	public void resetRandom() {
		randomPositionX = (int)(Math.random() * (20-0)) + 0;
		randomPositionY = (int)(Math.random() * (20-0)) + 0;
	}
	
	public Element[][] initialiserCarte() {
		
		Element[][] map = new Element[dimension][dimension];

		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				if (i == 0 && j == 0) {
					map[i][j] = new Hero();
				} else {
					map[i][j] = new Grass();
				}
			}
		}
		
		for (int i = 0; i <= 5; i++) {
			resetRandom();
			map[randomPositionX][randomPositionY] = new Flower();
			resetRandom();
			map[randomPositionX][randomPositionY] = new Tree();
		}
		
		for (int i = 0; i <= 10; i++) {
			resetRandom();
			map[randomPositionX][randomPositionY] = new Rock();
			resetRandom();
			map[randomPositionX][randomPositionY] = new Trap();
		}
		
		for (int i = 0; i <= 3; i++) {
			resetRandom();
			map[randomPositionX][randomPositionY] = new Key();
			resetRandom();
			map[randomPositionX][randomPositionY] = new Lock();
		}
		
		for (int i = 0; i <= 20; i++) {
			resetRandom();
			map[randomPositionX][randomPositionY] = new Gold();
		}
		
		for (int i = 0; i <= 15; i++) {
			resetRandom();
			map[randomPositionX][randomPositionY] = new Monster();
		}
		
		
		
		
		return map;
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
