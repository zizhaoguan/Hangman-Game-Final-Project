import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import java.awt.ScrollPane;





public class GameMainWindow extends JPanel
{
	private Image backgroundImage;
	private JTextField userSubmissionField;
	private JLabel lettersJLabel;
	private JButton btnSubmit; 
	private JLabel characterImageJLabel;
	private JLabel hangCharacterJLabel;
	private JTextArea characterTextArea;
	private JTextArea hangTextArea;
	private JButton btnSkill;
	private JLabel chanceField;
	private JLabel skillField;
	private Hangman game;
	private JPanel CharacterDescriptionPanel;
	private JScrollPane scrollPane;
	private JPanel HangingDescriptionPanel;
	private JScrollPane scrollPane_1;
	private JPanel parentPanel;
	private HangCharacterMainWindow hangPanel;
	private int wordCount;
	private String displayedLetters;
	private String correctWord;
	private int correctWordCount;
	
	//Button action listener
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if (event.getSource() == btnSubmit)//if its the "submit" button
			{
				char textValue = userSubmissionField.getText().charAt(0);
				boolean a = game.checkGuess(textValue);
				
				if(a == true)//if user guess is true
				{
					displayedLetters= "";
					correctWordCount = 0;
					//displaying the word to the screen WITH ONLY the correct letters that the user has guessed
					for(int i = 0; i < wordCount; i++)
					{
						if( game.getRightLetters().contains(correctWord.charAt(i)))
						{
							displayedLetters+= correctWord.charAt(i) + "  ";
							correctWordCount++;
						}
						else
						{
							displayedLetters+= "-  ";
						}
					}
					
					lettersJLabel.setText(displayedLetters);//displaying the text onto the window
					
					JOptionPane.showMessageDialog(parentPanel, textValue + " is correct", "Check", JOptionPane.INFORMATION_MESSAGE);
					
					//If the user has guessesed all the words correctly
					if(correctWordCount == wordCount)
					{
						JOptionPane.showMessageDialog(parentPanel,"YOU WON!! Congratulations!\nPress 'Okay' to end the game..", "Check", JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					}
				}
				else//If user-guess was not successfull
				{
					chanceField.setText("Total Guesses: " + Integer.toString(game.getGameChances())); //update the number of guesses in the screen 
					hangPanel.redrawAgain();//draw more of the hanging character
					JOptionPane.showMessageDialog(parentPanel, textValue + " is incorrect", "Check", JOptionPane.INFORMATION_MESSAGE);
					
					//If user runs out of guessess
					if(game.getGameChances() == 0)
					{
						JOptionPane.showMessageDialog(parentPanel, "You Lost!!You ran out guesses...\nThe correct word was '" + correctWord + "'\nPress 'okay' to end game.", "Check", JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					}
				}
				userSubmissionField.setText("");//clearing the submission box to get ready for the next guess
			}
		
//////////////////////////////////////////////////////////////////////////
			//*****SKILL SECTION  it needs testing***************/////
////////////////////////////////////////////////////////////////////////////////			
			else if (event.getSource() == btnSkill)//if the "skill" button was pressed
			{
			
				
				game.getRole().getSkill(game);
				boolean a = game.getRole().checkIfSkillWork();
				if(a == true)
				{
					skillField.setText("(" + Integer.toString(game.getRole().getSkillChances())+")");
					chanceField.setText("Total Guesses: " + Integer.toString(game.getGameChances()));  
					//chancePane.add(chanceField, c);
					JOptionPane.showMessageDialog(parentPanel, game.getRole().getName()+"'s skill is working", "Skill", JOptionPane.INFORMATION_MESSAGE);
					JOptionPane.showMessageDialog(parentPanel, game.getRole().getSkillDialog(), "Dialog", JOptionPane.INFORMATION_MESSAGE, game.getRole().getImage());
					if(game.getRole().getName().equals("Hulk"))
					{
						displayedLetters= "";
						correctWordCount = 0;
						//displaying the word to the screen WITH ONLY the correct letters that the user has guessed
						for(int i = 0; i < wordCount; i++)
						{
							if( game.getRightLetters().contains(correctWord.charAt(i)))
							{
								displayedLetters+= correctWord.charAt(i) + "  ";
								correctWordCount++;
							}
							else
							{
								displayedLetters+= "-  ";
							}
						}
						lettersJLabel.setText(displayedLetters);//displaying the text onto the window
					}
					else if(game.getRole().getName().equals("King of Game"))
					{
						
						Random random = new Random();
						int r = random.nextInt(game.getAvailableRightLetters().size());
						char ch1 = game.getAvailableRightLetters().get(r);
						r = random.nextInt(game.getAvailableWrongLetters().size());
						char ch2 = game.getAvailableWrongLetters().get(r);
						
						r = random.nextInt(100);
						if( r%2 == 0 )
						{
							JOptionPane.showMessageDialog(parentPanel, "Choose one leter from here: "+ch1+" or "+ch2, "Skill", JOptionPane.INFORMATION_MESSAGE);
						}
						else if(r%2 == 1)
						{
							JOptionPane.showMessageDialog(parentPanel, "Choose one leter from here: "+ch2+" or "+ch1, "Skill", JOptionPane.INFORMATION_MESSAGE);
						}
					}
					else if(game.getRole().getName().equals("Doctor Strange"))
					{
						correctWord = game.getWord();
						wordCount = game.getWord().length();
						displayedLetters= "";
						correctWordCount = 0;
						for(int i = 0; i < wordCount; i++)
						{
							if( game.getRightLetters().contains(correctWord.charAt(i)))
							{
								displayedLetters+= correctWord.charAt(i) + "  ";
								correctWordCount++;
							}
							else
							{
								displayedLetters+= "-  ";
							}
						}
						lettersJLabel.setText(displayedLetters);//displaying the text onto the window
					}
					else if(game.getRole().getName().equals("James Bond"))
					{
						displayedLetters= "";
						correctWordCount = 0;
						for(int i = 0; i < wordCount; i++)
						{
							if( game.getRightLetters().contains(correctWord.charAt(i)))
							{
								displayedLetters+= correctWord.charAt(i) + "  ";
								correctWordCount++;
							}
							else
							{
								displayedLetters+= "-  ";
							}
						}
						
						lettersJLabel.setText(displayedLetters);//displaying the text onto the window
					}
						
				}
				else
				{
					JOptionPane.showMessageDialog(parentPanel, game.getRole().getName()+" can't use skill", "Skill", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
////////////////////////////////////////////////////////////////////////////////////
	}

	
	
	
	
	public GameMainWindow(JPanel inputPanel, Hangman inputGame) 
	{
		game = inputGame;
		

		try
		{
			backgroundImage = ImageIO.read(new File("src/Images/GameWindowBackground2.jpg"));
		}
		catch(IOException e)
		{
			System.out.println("Exception Trying to read the image " + e);
		}
		


		this.setLayout(null);
		
		//creating button listener
		ButtonListener buttonListener = new ButtonListener();
		
		//****************************Letters**********************************
		correctWord = game.getWord();
		wordCount = game.getWord().length();
		correctWordCount = 0;
		displayedLetters = "";
		System.out.println(correctWord);
		for(int i = 0; i < wordCount; i++)
		{
			displayedLetters += "-  "; 
		}
		
		lettersJLabel = new JLabel(displayedLetters, JLabel.CENTER);
		lettersJLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 29));
		lettersJLabel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lettersJLabel.setBounds(65, 359, 800, 49);
		add(lettersJLabel);
		
		//*************************User submission code****************************
		userSubmissionField = new JTextField();
		userSubmissionField.setBackground(new Color(255, 255, 255));
		userSubmissionField.setBounds(338, 418, 125, 31);
		add(userSubmissionField);
		userSubmissionField.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(SystemColor.activeCaption);
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnSubmit.setBounds(497, 418, 106, 38);
		btnSubmit.addActionListener(buttonListener);
		add(btnSubmit);
		
		//***************************Code that shows the Role and Character picture and story**********************************
		ImageIcon heroImage = (ImageIcon)game.getRole().getImage(); 
		heroImage.setImage(heroImage.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		characterImageJLabel = new JLabel(heroImage);
		characterImageJLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		characterImageJLabel.setBackground(Color.WHITE);
		characterImageJLabel.setBounds(44, 500, 90, 90);
		add(characterImageJLabel);
		

		ImageIcon hangingCharacterImage = (ImageIcon)game.getHangingCharacter().getImage(); 
		hangingCharacterImage.setImage(hangingCharacterImage.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		hangCharacterJLabel = new JLabel(hangingCharacterImage);
		hangCharacterJLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		hangCharacterJLabel.setBackground(Color.GRAY);
		hangCharacterJLabel.setBounds(44, 600, 90, 90);
		add(hangCharacterJLabel);
		
		CharacterDescriptionPanel = new JPanel();
		CharacterDescriptionPanel.setBounds(180, 500, 562, 90);
		add(CharacterDescriptionPanel);
		CharacterDescriptionPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 562, 90);
		CharacterDescriptionPanel.add(scrollPane);
		
		characterTextArea = new JTextArea();
		scrollPane.setViewportView(characterTextArea);
		characterTextArea.setText(game.getRole().getDescription());
		
		HangingDescriptionPanel = new JPanel();
		HangingDescriptionPanel.setBounds(180, 600, 562, 90);
		add(HangingDescriptionPanel);
		HangingDescriptionPanel.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 562, 90);
		HangingDescriptionPanel.add(scrollPane_1);
		
		hangTextArea = new JTextArea();
		scrollPane_1.setViewportView(hangTextArea);
		hangTextArea.setText(game.getHangingCharacter().getStory());
		
		
		//****************************************Code that shows Activating Skill Button*****************************************
		btnSkill = new JButton("Skill");
		btnSkill.setBackground(new Color(255, 153, 102));
		btnSkill.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnSkill.setBounds(792, 514, 98, 49);
		btnSkill.addActionListener(buttonListener);
		add(btnSkill);
		
		//shows number of times user can use the skill
		skillField = new JLabel("(1)", JLabel.CENTER);
		skillField.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		skillField.setBounds(747, 516, 35, 45);
		add(skillField);

		
		//***********************Code to show the amount of guesses that the user has left**************************************
		chanceField = new JLabel("Total Guesses: 5", JLabel.CENTER);
		chanceField.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		chanceField.setBounds(701, 129, 139, 70);
		add(chanceField);

		
		
		this.setPreferredSize(new Dimension(900,700));
		hangPanel = new HangCharacterMainWindow(game);
		hangPanel.setBounds(393, 62, 250, 250);
		add(hangPanel);

	}
	
	
	
	//This method prints the background picture
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0,0, null);
	
	}

}
