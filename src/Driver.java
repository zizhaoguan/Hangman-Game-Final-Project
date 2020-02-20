import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Driver {

	public static void main(String args[])
	{
		JFrame frame = new JFrame();
	
		JPanel mainPanel = new JPanel();
		CardLayout layout = new CardLayout();
	    mainPanel.setLayout(layout);
	    Hangman newGame = new Hangman();
	    
	    System.out.println("I am here!");
	    mainPanel.add(new StartingWindow(mainPanel, layout), "1");
	    mainPanel.add(new RoleJPanel(mainPanel, layout, newGame), "2");
	    mainPanel.add(new CharacterJPanel(mainPanel, layout, newGame), "3");
	    

	    layout.show(mainPanel, "1");
	    frame.setLayout(new FlowLayout());
	    frame.add(mainPanel);
		

	 
	    frame.setTitle("Test Frame");	
	    frame.pack();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}
	
}
