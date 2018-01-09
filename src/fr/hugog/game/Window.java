package fr.hugog.game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
	JPanel gamePan = new GamePanel();
	JLabel inGameHeroName = new JLabel("");
    JTextField nameInput = new JTextField("");
    JButton startBtn = new JButton("Go !");
    String heroName;

	public Window() 
	{
		this.setTitle("Game");
		this.setSize(800, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
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
	    
	    this.setContentPane(gamePan);
	    this.setContentPane(homePan);
		
		this.setVisible(true);
    }
	
	public void printGamePan()
    {
		final String heroName = nameInput.getText();
		gamePan.setLayout(new FlowLayout());
		inGameHeroName.setText(heroName + "'s Game");
		gamePan.add(inGameHeroName);
	    this.setContentPane(gamePan);
		
		this.setVisible(true);
    }
	
	public void actionPerformed(ActionEvent ae)
    {
        this.printGamePan();
    }

}
