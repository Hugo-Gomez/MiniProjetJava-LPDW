package fr.hugog.game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Window extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel homePan = new HomePanel();
	GamePanel gamePan = new GamePanel();
	JLabel inGameHeroName = new JLabel("");
	JLabel inventory = new JLabel("");
    JTextField nameInput = new JTextField("");
    JButton startBtn = new JButton("Go !");
    String heroName;

	public Window() 
	{
		this.setTitle("Game");
		this.setSize(815, 900);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	/**
     * Print the home panel
     */
	public void printHomePan()
    {
		startBtn.addActionListener(this);
	    
	    nameInput.setPreferredSize(new Dimension(200, 30));
	    nameInput.setForeground(Color.black);
	    homePan.add(nameInput);
	    homePan.add(startBtn);
	    
	    homePan.setLayout(null);
	    nameInput.setBounds(285, 400, 200, 30);
	    startBtn.setBounds(345, 440, 70, 30);
	    
	    this.setContentPane(homePan);
		
		this.setVisible(true);
    }
	
	/**
     * Print the game panel
     */
	
	public void printGamePan()
    {
		gamePan.setLayout(new BorderLayout());
		
		gamePan.printObjects(gamePan.getHero());

        this.setContentPane(gamePan);
		
		this.setVisible(true);
    }
	
	/**
     * Print the game panel when the user entered his name
     * 
     * @param ae
     */
	
	public void actionPerformed(ActionEvent ae)
    {
		if (nameInput.getText().isEmpty()) {
			nameInput.setText("Please enter your name");
		}
		else {
			this.printGamePan();
		}
    }

}
