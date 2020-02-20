import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;



public class testHangman {

	
	public static void main(String[] args) throws IOException {
		
		Hangman game = new Hangman();
		
//		while(game.getGameChances()>0)
//		{
//			System.out.println("what?");
//			Scanner a = new Scanner(System.in);
//			char ch = a.next().charAt(0);
//			game.checkGuess(ch);
//		}
		
		
		choosingRolePane(game);
		//System.out.println("what?");
		//Scanner a = new Scanner(System.in);
		//String str = a.nextLine();
		//System.out.println(game.getRole().getName());
		
	}
	
	
	static void choosingRolePane(Hangman game)
	{
		
		JFrame frame = new JFrame("Hangman Game");
		frame.pack();
		frame.setSize(900, 700);
		
		JPanel roleChoicePanel = new JPanel();
		roleChoicePanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		ImageIcon dsPic = new ImageIcon("src/Dr_Strange.jpg");
		dsPic.setImage(dsPic.getImage().getScaledInstance(280, 280, Image.SCALE_DEFAULT));
		
		ImageIcon kfgPic = new ImageIcon("src/King_of_Game.jpg");
		kfgPic.setImage(kfgPic.getImage().getScaledInstance(280, 280, Image.SCALE_DEFAULT));
		
		ImageIcon hPic = new ImageIcon("src/Hulk.jpg");
		hPic.setImage(hPic.getImage().getScaledInstance(280, 280, Image.SCALE_DEFAULT));
		
		ImageIcon jbPic = new ImageIcon("src/JamesBond.jpg");
		jbPic.setImage(jbPic.getImage().getScaledInstance(280, 280, Image.SCALE_DEFAULT));
		
		ImageIcon nPic = new ImageIcon("src/Nanny.jpg");
		nPic.setImage(nPic.getImage().getScaledInstance(280, 280, Image.SCALE_DEFAULT));
		
		ImageIcon jPic = new ImageIcon("src/Joker.jpg");
		jPic.setImage(jPic.getImage().getScaledInstance(280, 280, Image.SCALE_DEFAULT));
		
		
		JButton dsButton = new JButton(dsPic);
		JButton kfgButton = new JButton(kfgPic);
		JButton hButton = new JButton(hPic);
		JButton jbButton = new JButton(jbPic);
		JButton nButton = new JButton(nPic);
		JButton jButton = new JButton(jPic);
		//b.setSize(100, 100);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0;
		c.gridx = 1;
		c.gridy = 0;
		JLabel textTitle = new JLabel();
		textTitle.setText("Choose a hero!");
		Font font = new Font("Serif", Font.ITALIC | Font.BOLD, 50);
		textTitle.setFont(font);
		roleChoicePanel.add(textTitle,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		roleChoicePanel.add(dsButton, c);
		
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		roleChoicePanel.add(kfgButton, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 1;
		roleChoicePanel.add(hButton, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 2;
		roleChoicePanel.add(jbButton, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 2;
		roleChoicePanel.add(nButton, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 2;
		roleChoicePanel.add(jButton, c);
		
		
		//JButton c = new JButton(aRole.getImage());
		//dsButton.setSize(100, 100);
		dsButton.setBorder(BorderFactory.createRaisedBevelBorder());
		kfgButton.setBorder(BorderFactory.createRaisedBevelBorder());
		hButton.setBorder(BorderFactory.createRaisedBevelBorder());
		jbButton.setBorder(BorderFactory.createRaisedBevelBorder());
		nButton.setBorder(BorderFactory.createRaisedBevelBorder());
		jButton.setBorder(BorderFactory.createRaisedBevelBorder());
		
		frame.add(roleChoicePanel);
		
		
//		dsButton.addActionListener(event->game.setRole(new DrStrange()));
//		kfgButton.addActionListener(event->game.setRole(new KingOfGame()));
//		hButton.addActionListener(event->game.setRole(new Hulk()));
//		jbButton.addActionListener(event->game.setRole(new JamesBond()));
//		nButton.addActionListener(event->game.setRole(new Nanny()));
		//jButton.addActionListener(event->game.setRole(new Joker()));
		dsButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						game.setRole(new DrStrange());
						frame.setVisible(false);
						gamePlayPane(game);
					}
				});
		kfgButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						game.setRole(new KingOfGame());
						frame.setVisible(false);
						gamePlayPane(game);
					}
				});
		hButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						game.setRole(new Hulk());
						frame.setVisible(false);
						gamePlayPane(game);
					}
				});
		
		jbButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						game.setRole(new JamesBond());
						frame.setVisible(false);
						gamePlayPane(game);
					}
				});
		nButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						game.setRole(new Nanny());
						frame.setVisible(false);
						gamePlayPane(game);
					}
				});
		jButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						game.setRole(new Joker());
						frame.setVisible(false);
						gamePlayPane(game);
					}
				});
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	static void gamePlayPane(Hangman game)
	{
		JLabel chanceField = new JLabel();
		JLabel skillField = new JLabel();
		JTextArea enterField;
		JTextArea descriptionField;
		GridBagConstraints c = new GridBagConstraints();
		
		//main window frame
		JFrame frame = new JFrame();
		
		//center panel
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		
		
		
		
//		BufferedImage hangingImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
//		try
//		{
//			hangingImage = ImageIO.read(new File("src/hang.jpg"));
//			
//			Graphics2D graphics = hangingImage.createGraphics();
//
//			hangingImage = graphics.getDeviceConfiguration().createCompatibleImage(100,100, Transparency.TRANSLUCENT);
//			
//			OutputStream out = new FileOutputStream(new File("src/hang2.jpg"));
//			ImageIO.write(hangingImage, "jpg", out);
//			System.out.print("here");
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		
		ImageIcon hangingImage = new ImageIcon("src/hang2.png");
		
		 hangingImage.setImage( hangingImage.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
		JLabel hangingL = new JLabel( hangingImage, JLabel.CENTER);
	
		ImageIcon heroImage = (ImageIcon) game.getRole().getImage();
		heroImage.setImage(heroImage.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		JLabel heroL = new JLabel(heroImage, JLabel.CENTER);
		
		
		//top panel
		JPanel titlePane = new JPanel();
		titlePane.add(new JLabel("Hangman"), BorderLayout.NORTH);
		titlePane.add(new JLabel("Description"), BorderLayout.CENTER);
		descriptionField = new JTextArea(4,50);
		descriptionField.setLineWrap(true);
		descriptionField.setWrapStyleWord(true);
		descriptionField.setText(game.getRole().getDescription());
		titlePane.add(descriptionField, BorderLayout.SOUTH);
		
		//left panel
		JPanel chancePane = new JPanel();
	
		chancePane.setLayout(new GridBagLayout());
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		chancePane.add(new JLabel("Total Chance: "), c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		chanceField.setText(Integer.toString(game.getGameChances())+"  ");  
		chancePane.add(chanceField, c);
		
		c.fill = GridBagConstraints.VERTICAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 2;
		JLabel guessTitle = new JLabel("guess:"); 
		chancePane.add(guessTitle, c);
		
		String term = game.getWord();
		
		//ArrayList<Character> blanks = new ArrayList<Character>();
		int count = term.length()+term.length()-1;
		char[] blanks = new char[count];
		for(int i=0; i<count; i++) 
		{
			if(i%2 == 0) {blanks[i]='_';}
			else {blanks[i]=' ';}
			
		}
		term = new String(blanks);
		
		c.fill = GridBagConstraints.VERTICAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 3;
		JLabel blankLines = new JLabel(term);
		chancePane.add(blankLines, c);
		
		
		
		//right panel
		JPanel skillPane = new JPanel();
		skillPane.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		skillPane.add(new JLabel("  Skill: "), c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		skillField.setText(Integer.toString(game.getRole().getSkillChances())+"  ");
		skillPane.add(skillField, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		JButton skillButton = new JButton("Skill");
		skillButton.setBorder(BorderFactory.createRaisedBevelBorder());
		Dimension size = new Dimension(50, 20);
		skillButton.setPreferredSize(size);
		skillPane.add(skillButton, c);
		
		
		skillButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						game.getRole().getSkill(game);
						boolean a = game.getRole().checkIfSkillWork();
						if(a == true)
						{
							skillField.setText(Integer.toString(game.getRole().getSkillChances())+"  ");
							chanceField.setText(Integer.toString(game.getGameChances())+"  ");  
							chancePane.add(chanceField, c);
							JOptionPane.showMessageDialog(frame, game.getRole().getName()+"'s skill is working", "Skill", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(frame, game.getRole().getName()+" can't use skill", "Skill", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
				);
		
		
		//bottom panel
		JPanel enter = new JPanel();
		enterField = new JTextArea(2, 10);
		enter.add(enterField, BorderLayout.SOUTH);
		JButton submitButton = new JButton("submit");
		submitButton.setBorder(BorderFactory.createRaisedBevelBorder());
		submitButton.setPreferredSize(size);
		enter.add(submitButton, BorderLayout.SOUTH);
		
		submitButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						char textValue = enterField.getText().charAt(0);
						boolean a = game.checkGuess(textValue);
						if(a == true)
						{
							JOptionPane.showMessageDialog(frame, textValue + " is correct", "Check", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							chanceField.setText(Integer.toString(game.getGameChances())+"  ");  
							chancePane.add(chanceField, c);
							JOptionPane.showMessageDialog(frame, textValue + " is incorrect", "Check", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
		
		
		
		ImageIcon background = new ImageIcon("src/background2.jpg");
		background.setImage(background.getImage().getScaledInstance(650, 450, Image.SCALE_DEFAULT));
		JLabel backgroundL = new JLabel(background, JLabel.CENTER);
		frame.getLayeredPane().add(backgroundL, -1);
		backgroundL.setBounds(150, 150, 600, 400);
		
		

		

		frame.getLayeredPane().add(hangingL, 0);
		hangingL.setBounds(250, 200, 400, 300);
		hangingL.setOpaque(false);
		//hangingL.setBackground(Color.black);
		
		frame.getLayeredPane().add(titlePane, 0);
		titlePane.setBounds(200, 0, 500, 300);
		titlePane.setOpaque(false);
		
		//frame.getLayeredPane().add(comp)
		
		
		frame.add(chancePane, BorderLayout.WEST);
		
		frame.add(enter, BorderLayout.SOUTH);
		frame.add(skillPane, BorderLayout.EAST);
		frame.pack();
		frame.setSize(900,700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
}



