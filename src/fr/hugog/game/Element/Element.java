package fr.hugog.game.Element;

public class Element {

	int x, y;
	private String symbol;
	private String imageElement; 

	public Element(String symbol, String imageElement) {
		this.symbol = symbol;
		this.imageElement = imageElement;
	}
	
	/**
     * Return the symbol of an element
     *
     * @return symbol
     */

	public String getSymbol() {
		return symbol;
	}
	
	/**
     * Update the symbol of an element
     *
     * @param symbol
     */

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	/**
     * Return the X position of an element
     *
     * @return x
     */

	public int getX() {
		return x;
	}
	
	/**
     * Update the X position of an element
     *
     * @param x
     */

	public void setX(int x) {
		this.x = x;
	}
	
	/**
     * Return the Y position of an element
     *
     * @return y
     */

	public int getY() {
		return y;
	}
	
	/**
     * Update the Y position of an element
     *
     * @param y
     */

	public void setY(int y) {
		this.y = y;
	}
	
	/**
     * Return the image of an element
     *
     * @return imageElement
     */

	public String getImageElement() {
		return imageElement;
	}
	
}
