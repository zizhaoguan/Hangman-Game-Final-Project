import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CharacterJPanel extends JPanel {

    private JButton buttonOne;
    private JLabel topTittle;
    private JLabel bottomLabel;
    private JPanel centerPanel;

    //Buttons that will represent the characters that are available to chose from
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
	private JPanel parentPanel;
	private CardLayout parentPanelLayout;

    private ArrayList<Image> imageInputs;
    private Hangman game;

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	
        	
            if (e.getSource() == button1) 
            {
            	game.setHangingCharacter(new Boss());
            	parentPanel.add(new GameMainWindow(parentPanel,game), "4");
            	parentPanelLayout.show(parentPanel, "4"); 
            }
            else if (e.getSource() == button2) 
            {
            	game.setHangingCharacter(new Shirt());
            	parentPanel.add(new GameMainWindow(parentPanel,game), "4");
            	parentPanelLayout.show(parentPanel, "4"); ;
            } 
            else if (e.getSource() == button3) 
            {
            	game.setHangingCharacter(new Grandma());
            	parentPanel.add(new GameMainWindow(parentPanel,game), "4");
            	parentPanelLayout.show(parentPanel, "4"); 
            } 
            else if (e.getSource() == button4) 
            {	game.setHangingCharacter(new Toucan());
            	parentPanel.add(new GameMainWindow(parentPanel,game), "4");
            	parentPanelLayout.show(parentPanel, "4"); 
            } 
            else if (e.getSource() == button5) 
            {
            	game.setHangingCharacter(new MintInBox());
            	parentPanel.add(new GameMainWindow(parentPanel,game), "4");
            	parentPanelLayout.show(parentPanel, "4"); 
            } 
            else if (e.getSource() == button6) 
            {
            	game.setHangingCharacter(new Goose());
            	parentPanel.add(new GameMainWindow(parentPanel,game), "4");
            	parentPanelLayout.show(parentPanel, "4"); 
            }
        }
    }

    private class MouseActivityListener implements MouseListener
    {
        public void mouseEntered (MouseEvent event)
        {
            if(event.getSource() == button1)
            { bottomLabel.setText("Your Boss"); }
            else  if (event.getSource() == button2)
            {bottomLabel.setText("Your Shirt");}
            else  if (event.getSource() == button3)
            {bottomLabel.setText("Your Grandma");}
            else  if (event.getSource() == button4)
            {bottomLabel.setText("Your Toucan");}
            else  if (event.getSource() == button5)
            {bottomLabel.setText("Your Lightsaver");}
            else  if (event.getSource() == button6)
            {bottomLabel.setText("Your Goose");}

        }

        //Do-Nothing methods
        public void mouseReleased(MouseEvent event){};
        public void mouseClicked(MouseEvent event){};
        public void mouseExited(MouseEvent event){};
        public void mousePressed(MouseEvent event){}
        

    }
    public CharacterJPanel (JPanel inputPanel, CardLayout inputLayout, Hangman inputGame)
    {
    	game  = inputGame;
    	parentPanel = inputPanel;
    	parentPanelLayout = inputLayout;
   
        //setting Layout
        this.setLayout(new BorderLayout());

        imageInputs = new ArrayList<>();


        //Initializing Jlabels
        topTittle = new JLabel("Who do you want to hang?", JLabel.CENTER);
        topTittle.setFont(new Font("Comic Sans Ms", Font.BOLD, 40));
        bottomLabel = new JLabel("", JLabel.CENTER);
        bottomLabel.setFont(new Font("Arial", Font.BOLD, 30));


        //adding "topTittle" to the top of the panel
        this.add(topTittle, BorderLayout.NORTH);


        //creating centerPanel. THis section contains all of the character choices
        createCenterPanel();

        //Adding "bottomLabel" to the bottom of the panel
        this.add(bottomLabel, BorderLayout.SOUTH);

        //Setting the size of the frame
        setPreferredSize(new Dimension(900,700));





    }

    private void createCenterPanel()
    {
        //creating panel
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2,3));
       // centerPanel.setMaximumSize(new Dimension(200,200));
        centerPanel.setPreferredSize(new Dimension(100,100));
       // centerPanel.setBounds(50, 50, 50, 50);

        //Reading Images
        try {


            imageInputs.add(ImageIO.read(new File("src/Images/Boss.jpg")));
            imageInputs.add(ImageIO.read(new File("src/Images/Shirt.jpg")));
            imageInputs.add(ImageIO.read(new File("src/Images/Grandma.jpg")));
            imageInputs.add(ImageIO.read(new File("src/Images/Toucan.jpg")));
            imageInputs.add(ImageIO.read(new File("src/Images/Lightsaver.jpeg")));
            imageInputs.add(ImageIO.read(new File("src/Images/Goose.jpg")));
           

        }
        catch (IOException e){

            System.out.print("SelectCharacter----" + e);
        }

        //initializing Button Action Listener
        ButtonListener listener = new ButtonListener();
        MouseActivityListener mouseListener = new MouseActivityListener();

        //Initializing Buttons
        button1  = new JButton(new ImageIcon(imageInputs.get(0)));
        button1.setBounds(100, 100, 100, 100);
        button1.setMaximumSize(new Dimension (50,50));
        button1.addActionListener(listener);
        button1.addMouseListener(mouseListener);
        
        button2 = new JButton(new ImageIcon(imageInputs.get(1)));
        button2.addActionListener(listener);
        button2.addMouseListener(mouseListener);
        button2.setSize(200,200);
        
        button3 = new JButton(new ImageIcon(imageInputs.get(2)));
        button3.addActionListener(listener);
        button3.addMouseListener(mouseListener);
        button3.setSize(200,200);
        
        button4 = new JButton(new ImageIcon(imageInputs.get(3)));
        button4.addActionListener(listener);
        button4.addMouseListener(mouseListener);
        button4.setSize(200,200);
        
        button5 = new JButton(new ImageIcon(imageInputs.get(4)));
        button5.addActionListener(listener);
        button5.addMouseListener(mouseListener);
        button1.setSize(200,200);
        
        button6 = new JButton(new ImageIcon(imageInputs.get(5)));
        button6.addActionListener(listener);
        button6.addMouseListener(mouseListener);
        button6.setSize(200,200);

     
        //adding buttons to the "centerPanel"
        centerPanel.add(button1);
        centerPanel.add(button2);
        centerPanel.add(button3);

        centerPanel.add(button4);
        centerPanel.add(button5);
        centerPanel.add(button6);





        //setting a border to the panel
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        this.add(centerPanel, BorderLayout.CENTER);




    }


}
