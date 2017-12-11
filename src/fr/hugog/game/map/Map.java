package fr.hugog.game.map;

import fr.hugog.game.Element.*;

public class Map {
	
	int dimension;
	int randomPositionX, randomPositionY;
	Element[][] map;
	Element hero;
	
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
				map[i][j] = new Element("0 ");
			}
		}
		
		for (int i = 0; i <= 5; i++) {
			resetRandom();
			map[randomPositionX][randomPositionY] = new Element("1 ");
			resetRandom();
			map[randomPositionX][randomPositionY] = new Element("2 ");
		}
		
		for (int i = 0; i <= 10; i++) {
			resetRandom();
			map[randomPositionX][randomPositionY] = new Element("3 ");
			resetRandom();
			map[randomPositionX][randomPositionY] = new Element("7 ");
		}
		
		for (int i = 0; i <= 3; i++) {
			resetRandom();
			map[randomPositionX][randomPositionY] = new Element("4 ");
			resetRandom();
			map[randomPositionX][randomPositionY] = new Element("6 ");
		}
		
		for (int i = 0; i <= 20; i++) {
			resetRandom();
			map[randomPositionX][randomPositionY] = new Element("5 ");
		}
		
		for (int i = 0; i <= 15; i++) {
			resetRandom();
			map[randomPositionX][randomPositionY] = new Element("8 ");
		}
		
		map[0][0] = new Hero("X ");
		
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
