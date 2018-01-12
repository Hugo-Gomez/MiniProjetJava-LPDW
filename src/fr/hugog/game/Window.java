package fr.hugog.game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.hugog.game.Element.Element;
import fr.hugog.game.Element.Flower;
import fr.hugog.game.Element.Gold;
import fr.hugog.game.Element.Grass;
import fr.hugog.game.Element.Hero;
import fr.hugog.game.Element.Key;
import fr.hugog.game.Element.Lock;
import fr.hugog.game.Element.Monster;
import fr.hugog.game.Element.Rock;
import fr.hugog.game.Element.Trap;
import fr.hugog.game.Element.Tree;
import fr.hugog.game.map.Map;

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
		ArrayList<Element> elements = Map.initializeElement();
		this.map = initMap(elements);
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
		// gamePan.setLayout(new BorderLayout());
		// inGameHeroName.setText("<html><font color='red' size='20'><div style='text-align: center;'>" + heroName + "'s Game</div></font></html>");
		
		Map map = new Map();
		
		Hero hero = (Hero) map.getMap()[0][0];

        this.setContentPane(gamePan);
			
		// gamePan.add(inGameHeroName, BorderLayout.PAGE_START);
		
		this.generateGameMap();
		
		this.printObjects(hero);
		
		this.setVisible(true);
    }
	
	public Element[][] initMap(ArrayList<Element> element) {
			
		Element[][] map = new Element[20][20];
		Random random = new Random();
		int randomNumber;

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (i == 0 && j == 0) {
					map[i][j] = new Hero();
				} else {
					randomNumber = random.nextInt(element.size());
					map[i][j] = element.get(randomNumber);
					element.remove(randomNumber);
				}
			}
		}
		return map;
	}
	
	public static ArrayList<Element> initElement() {
		ArrayList<Element> elements = new ArrayList<>();
		for (int i = 0; i < 5 ; i++) {
			elements.add(new Flower());
		}
		for (int i = 0; i < 5 ; i++) {
			elements.add(new Tree());
		}
		for (int i = 0; i < 10 ; i++) {
			elements.add(new Rock());
		}
		for (int i = 0; i < 3 ; i++) {
			elements.add(new Key());
		}
		for (int i = 0; i < 3 ; i++) {
			elements.add(new Lock());
		}
		for (int i = 0; i < 20 ; i++) {
			elements.add(new Gold());
		}
		for (int i = 0; i < 10 ; i++) {
			elements.add(new Trap());
		}
		for (int i = 0; i < 15 ; i++) {
			elements.add(new Monster());
		}
		for (int i = 0; i < 329 ; i++) {
			elements.add(new Grass(0, 0));
		}
		return elements;
	}
	
	public void generateGameMap() {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				JLabel element = new JLabel(this.map[i][j].getSymbol() + " ");
	            gamePan.add(element);
			}
		}
	}
	
	public void printObjects(Hero hero) {
		inventory.setText("LifePoints : " + hero.getHealth() + " // Gold : " + hero.getGold() + " // Keys : " + hero.getKeys());
		gamePan.add(inventory, BorderLayout.PAGE_END);
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
