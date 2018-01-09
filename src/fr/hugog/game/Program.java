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
		
		Window window = new Window();
		
		Map map = new Map();
		
		Hero hero = (Hero) map.getMap()[0][0];
		
		Scanner nameScan = new Scanner(System.in);
		
		System.out.println("Welcome to the game !");
		System.out.println("");
		System.out.println("---------RULES---------");
		System.out.println("");
		System.out.println("In this game, you have to collect 10 Gold coin (5) to win");
		System.out.println("Mind the trap (7) and the monsters (8) ! They deal damage and if you loose your 10 Life Points, it's over !");
		System.out.println("Trees (3) and rocks (2) will block the way");
		System.out.println("Keys (4) makes you able to open locks (6) and give you 2 Gold coin !");
		System.out.println("");
		System.out.println("---------//---------");
		System.out.println("");
		System.out.println("What's your name ? : ");
		name = nameScan.nextLine();
		hero.setName(name);
		
		System.out.println("OK " + hero.getName() + " let's go !! Have fun !");
		System.out.println();
		
		map.afficherCarte();
		Map.printInventory(hero);
			
		while(gameStatus == 1) {
			Scanner moveScan = new Scanner(System.in);
			mouvement = moveScan.nextInt();
			
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
						System.out.println("You found a Key !");
						break;
					case 5: 
						hero.setGold(hero.getGold() + 1);
						System.out.println("You found a Gold coin !");
						break;
					case 6: 
						hero.setKeys(hero.getKeys() - 1);
						hero.setGold(hero.getGold() + 2);
						System.out.println("Your key opened the lock ! You earned 2 Gold Coin !");
						break;
					case 7:
						hero.setHealth(hero.getHealth() - 1);
						System.err.println("Ouch!! You walked on a trap.. (-1 Lp)");
						break;
					case 8:
						hero.setHealth(hero.getHealth() - 2);
						System.err.println("AAaah!! A monster hit you and ran away.. (-2 Lp)");
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
