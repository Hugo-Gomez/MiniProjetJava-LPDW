package fr.hugog.game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import fr.hugog.game.Element.Hero;
import fr.hugog.game.map.Map;

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
	    
	    this.setContentPane(homePan);
		
		this.setVisible(true);
    }
	
	public void printGamePan()
    {
		final String heroName = nameInput.getText();
		gamePan.setLayout(new FlowLayout());
		inGameHeroName.setForeground(Color.black); 
		inGameHeroName.setText("<html><font color='red' size='20'>" + heroName + "'s Game</font></html>");
		
		Map map = new Map();
		
		Hero hero = (Hero) map.getMap()[0][0];

        this.setContentPane(gamePan);
		
		gamePan.add(inGameHeroName);
		
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				JLabel l = new JLabel("" + i, JLabel.CENTER);
	            l.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	            l.setFont(l.getFont().deriveFont(20f));
	            gamePan.add(l);
			}
		}
		
	    this.setContentPane(gamePan);
		
		this.setVisible(true);
    }
	
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
