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
		super("X");
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
	
	public Element[][] move(int m, Element[][] map) {
		switch (m) {
		
		case 8: 
			if(!(this.getHeroX() - 1 <= 0)) { // not functionnal
				map[this.getHeroX()][this.getHeroY()] = new Grass(this.getHeroX(), this.getHeroY());
				map[this.getHeroX()-1][this.getHeroY()] = this;
				this.setHeroX(this.getHeroX()-1);
			}
			return map;
			
		case 2:
			if(!(this.getHeroX() + 1 >= 20)) {
				map[this.getHeroX()][this.getHeroY()] = new Grass(this.getHeroX(), this.getHeroY());
				map[this.getHeroX()+1][this.getHeroY()] = this;
				this.setHeroX(this.getHeroX()+1);
			}
			return map;
			
		case 4:
			if(!(this.getHeroY() - 1 <= 0)) { // not functionnal
				
				map[this.getHeroX()][this.getHeroY()] = new Grass(this.getHeroX(), this.getHeroY());
				map[this.getHeroX()][this.getHeroY()-1] = this;
				this.setHeroY(this.getHeroY()-1);
			}		
			return map;
			
		case 6:
			if(!(this.getHeroY() + 1 >= 20)) {
				map[this.getHeroX()][this.getHeroY()] = new Grass(this.getHeroX(), this.getHeroY());
				map[this.getHeroX()][this.getHeroY()+1] = this;
				this.setHeroY(this.getHeroY()+1);
			}		
			return map;
			
		case 0:
			break;
		
		default:
			System.out.println("You can't move this way");
			return map;
			
			
		}
		return null;
}	

}
