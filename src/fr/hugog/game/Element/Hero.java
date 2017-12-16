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
	
	/**
     * Return the X position of the hero
     *
     * @return x
     */
	
	public int getHeroX() {
		return x;
	}
	
	/**
     * Update the X position of the hero
     *
     * @param x
     */
	
	public void setHeroX(int x) {
		this.x = x;
	}
	
	/**
     * Return the Y position of the hero
     *
     * @return y
     */
	
	public int getHeroY() {
		return y;
	}
	
	/**
     * Update the Y position of the hero
     *
     * @return y
     */
	
	public void setHeroY(int y) {
		this.y = y;
	}
	
	/**
     * Return the name of the hero
     *
     * @return name
     */
	
	public String getName() {
		return name;
	}
	
	/**
     * Update the name of the hero
     *
     * @param name
     */
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
     * Return the health of the hero
     *
     * @return health
     */
	
	public int getHealth() {
		return health;
	}
	
	/**
     * Return the health of the hero
     *
     * @param health
     */
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	/**
     * Return the gold amount of the hero
     *
     * @return gold
     */
	
	public int getGold() {
		return gold;
	}
	
	/**
     * Update the gold amount of the hero
     *
     * @param gold
     */

	public void setGold(int gold) {
		this.gold = gold;
	}
	
	/**
     * Return the keys amount of the hero
     *
     * @return keys
     */
	
	public int getKeys() {
		return keys;
	}
	
	/**
     * Update the keys amount of the hero
     *
     * @param keys
     */
	
	public void setKeys(int keys) {
		this.keys = keys;
	}
	
	/**
     * Return the locks amount of the hero
     *
     * @return locks
     */
	
	public int getLocks() {
		return locks;
	}
	
	/**
     * Update the locks amount of the hero
     *
     * @param locks
     */
	
	public void setLocks(int locks) {
		this.locks = locks;
	}
	
	/**
     * Make the hero move across the map
     *
     * @param m, map
     * @return map
     */
	
	public Element[][] moveHero(int m, Element[][] map) {
		try { 
			switch (m) {
			
				case 8: 
					map[this.getHeroX()][this.getHeroY()] = new Grass(this.getHeroX(), this.getHeroY());
					map[this.getHeroX()-1][this.getHeroY()] = this;
					this.setHeroX(this.getHeroX()-1);
					return map;
					
				case 2:
					map[this.getHeroX()][this.getHeroY()] = new Grass(this.getHeroX(), this.getHeroY());
					map[this.getHeroX()+1][this.getHeroY()] = this;
					this.setHeroX(this.getHeroX()+1);
					return map;
					
				case 4:
					map[this.getHeroX()][this.getHeroY()] = new Grass(this.getHeroX(), this.getHeroY());
					map[this.getHeroX()][this.getHeroY()-1] = this;
					this.setHeroY(this.getHeroY()-1);
					return map;
					
				case 6:
					map[this.getHeroX()][this.getHeroY()] = new Grass(this.getHeroX(), this.getHeroY());
					map[this.getHeroX()][this.getHeroY()+1] = this;
					this.setHeroY(this.getHeroY()+1);
					return map;
					
				case 0:
					break;
			
				default:
					System.out.println("You can't move this way");
					
				return map;
			}
			
			return null;
			
		} catch (ArrayIndexOutOfBoundsException e) {
        }
		return map;
		
		
	}	

}
