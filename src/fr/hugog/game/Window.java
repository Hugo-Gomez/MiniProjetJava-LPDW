package fr.hugog.game;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
	
	public Window() {
		this.setTitle("Game");
		this.setSize(800, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	    JPanel pan = new JPanel();
	    pan.setBackground(Color.WHITE);        
	    this.setContentPane(pan);
	    
	    this.setContentPane(new Panel());
		
		this.setVisible(true);
	}

}
