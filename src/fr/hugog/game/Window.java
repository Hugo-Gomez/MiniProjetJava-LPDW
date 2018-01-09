package fr.hugog.game;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Window extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Window() {
		this.setTitle("Game");
		this.setSize(800, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
	    JPanel pan = new Panel();
	    JTextField nameInput = new JTextField("");
	    JButton startBtn = new JButton("Go !");
	    Box nameStart = Box.createVerticalBox();
	    
	    nameInput.setPreferredSize(new Dimension(200, 30));
	    nameInput.setForeground(Color.black);
	    
	    nameStart.add(nameInput);
	    nameStart.add(startBtn);
	    
	    pan.add(nameStart);
	    
	    this.setContentPane(pan);
		
		this.setVisible(true);
	}

}
