package fr.hugog.game;

import java.util.Scanner;

import fr.hugog.game.Element.Hero;
import fr.hugog.game.map.Map;

public class Program {

	public static void main(String[] args) {
		
		int mouvement;
		int nextElement = 0;
		int gameStatus = 1;
		String name;
		
		Map map = new Map();
		
		Hero hero = (Hero) map.getMap()[0][0];
		Scanner nameScan = new Scanner(System.in);
		System.out.println("Welcome to the game !");
		System.out.println("What's your name ? : ");
		name = nameScan.nextLine();
		hero.setName(name);
		System.out.println("OK " + hero.getName() + " let's go !!");
		System.out.println();
		
		map.afficherCarte();
		
		hero = (Hero) map.getMap()[0][0];
		
		Map.printInventory(hero);
			
		while(gameStatus == 1) {
			Scanner scanner = new Scanner(System.in);
			mouvement = scanner.nextInt();
			
			if(mouvement == 0) {
				System.out.println("You gave up..");
				gameStatus = -1;
				break;
			}
			
			try {
				nextElement = Integer.parseInt(map.getElement(mouvement, hero));
			} catch ( NumberFormatException e) {
				
			}
			if(!(nextElement == 9 || nextElement == 2 || nextElement == 3 || (nextElement == 6 && hero.getKeys() < 1))) {
				switch(nextElement) {
					case 0: 
						break;
					case 1: 
						break;
					case 4: 
						hero.setKeys(hero.getKeys() + 1);
						break;
					case 5: 
						hero.setGold(hero.getGold() + 1);
						break;
					case 6: 
						hero.setKeys(hero.getKeys() - 1);
						break;
					case 7:
						hero.setHealth(hero.getHealth() - 1);
						break;
					case 8:
						hero.setHealth(hero.getHealth() - 2);
						break;
					default: break;
				}
				
				map.setMap(hero.moveHero(mouvement, map.getMap()));
				
				if(hero.getHealth() <= 0) {
					System.err.println("Game Over..");
					gameStatus = -1;
					break;
				}
				else if(hero.getGold() == 10) {
					System.out.println("You Win ! Well done " + hero.getName() + " !");
					gameStatus = -1;
					break;
				}
			}
			else {
				System.err.println("Oh.. It seems like you can't go this way..");
			}
			System.out.println();
			map.afficherCarte();
			
			Map.printInventory(hero);
		}
		
	}

}
