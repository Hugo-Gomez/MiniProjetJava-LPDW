package fr.hugog.game;

import java.util.Scanner;

import fr.hugog.game.Element.Hero;
import fr.hugog.game.map.Map;

public class Program {

	public static void main(String[] args) {
		
		Map map = new Map();
		
		map.afficherCarte();
		
		Hero hero = (Hero) map.getMap()[0][0];
		
		Map.printInventory(hero);
		
		int mouvement;
		int nextElement;
		int gameStatus = 1;
			
			
		while(gameStatus == 1) {
			Scanner scanner = new Scanner(System.in);
			mouvement = scanner.nextInt();
			
			if(mouvement == 0) {
				System.out.println("Did you gave up ?");
				gameStatus = -1;
				break;
			}
			
			nextElement = Integer.parseInt(map.getElement(mouvement, hero));
			System.out.println(nextElement);
			if(!(nextElement == 9 || nextElement == 2 ||  nextElement == 3 || (nextElement == 6 && hero.getKeys() < 1))) {
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
				
				map.setMap(hero.move(mouvement, map.getMap()));
				
				if(hero.getHealth() <= 0) {
					System.err.println("Game Over..");
					gameStatus = -1;
				}
				else if(hero.getGold() == 10) {
					System.out.println("You Win !");
					gameStatus = -1;
				}
			}
			else {
				System.err.println("An obstacle is on the way, and you can't walk through..");
			}
			System.out.println();
			map.afficherCarte();
			
			Map.printInventory(hero);
		}
		
	}

}
