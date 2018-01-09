package fr.hugog.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class HomePanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g){
		
		try {

	      Image bg = ImageIO.read(new File("beige-bg.jpg"));

	      g.drawImage(bg, 0, 0, this);

	    } catch (IOException e) {

	      e.printStackTrace();

	    } 

	    Font title = new Font("Courier", Font.BOLD, 20);
	    Font rules = new Font("Courier", Font.BOLD, 12);
	    Font name = new Font("Courier", Font.BOLD, 17);
	    
	    g.setFont(title);
	    g.setColor(Color.red);
	    
	    g.drawString("LP-DW Labyrinth", 300, 20);
	    
	    g.drawString("Welcome to the game !", 270, 100);
	    
	    g.setFont(rules);
	    g.setColor(Color.black);
	    
	    g.drawString("---------RULES---------", 300, 200);
	    g.drawString("In this game, you have to collect 10 Gold coin (5) to win", 180, 220);
	    g.drawString("Mind the trap (7) and the monsters (8) ! They deal damage and if you loose your 10 Life Points, it's over !", 25, 240);
	    g.drawString("Trees (3) and rocks (2) will block the way", 230, 260);
	    g.drawString("Keys (4) makes you able to open locks (6) and give you 2 Gold coin !", 150, 280);
	    g.drawString("---------//---------", 310, 300);
	    
	    g.setFont(name);
	    g.setColor(Color.black);	   
	    
	    g.drawString("What's your name ?", 300, 350);
	    
	  }  

}
