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

import fr.hugog.game.Element.Element;

public class Window extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel homePan = new HomePanel();
	JPanel gamePan = new GamePanel();
	JLabel inGameHeroName = new JLabel("");
	JLabel inventory = new JLabel("");
    JTextField nameInput = new JTextField("");
    JButton startBtn = new JButton("Go !");
    String heroName;
    
    /**
     * @see Element
     */
	Element[][] map;

	public Window() 
	{
		//ArrayList<Element> elements = Map.initializeElement();
		//this.map = initMap(elements);
		this.setTitle("Game");
		this.setSize(815, 837);
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
		// final String heroName = nameInput.getText();
		// gamePan.setLayout(new FlowLayout());
		// gamePan.setLayout(new BorderLayout());
		// inGameHeroName.setText("<html><font color='red' size='20'><div style='text-align: center;'>" + heroName + "'s Game</div></font></html>");

        this.setContentPane(gamePan);
			
		// gamePan.add(inGameHeroName, BorderLayout.PAGE_START);
		
		// this.setContentPane(new MapPanel());
		
		// this.printObjects(hero);
		
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
