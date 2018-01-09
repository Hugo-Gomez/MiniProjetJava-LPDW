package fr.hugog.game;
import java.awt.Color;
import java.awt.Dimension;
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
	    
	    nameInput.setPreferredSize(new Dimension(200, 30));
	    nameInput.setForeground(Color.black);
	    
	    pan.add(nameInput);
	    pan.add(startBtn);
	    
	    pan.setLayout(null);
	    nameInput.setBounds(285, 400, 200, 30);
	    startBtn.setBounds(345, 440, 70, 30);
	    
	    this.setContentPane(pan);
		
		this.setVisible(true);
	}

}
