package fr.hugog.game.Element;

public class Hero extends Element {
	
	private int x;
	private int y;
	private String name;
	private int health = 10;
	private int gold = 0;
	private int keys = 0;
	private int locks = 0;
	
	public Hero() {
		super("X ");
		this.health = 10;
		this.gold = 0;
		this.keys = 0;
	}
	
	public int getHeroX() {
		return x;
	}
	public void setHeroX(int x) {
		this.x = x;
	}
	public int getHeroY() {
		return y;
	}
	public void setHeroY(int y) {
		this.y = y;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public int getKeys() {
		return keys;
	}
	public void setKeys(int keys) {
		this.keys = keys;
	}
	public int getLocks() {
		return locks;
	}
	public void setLocks(int locks) {
		this.locks = locks;
	}
	
	

}
