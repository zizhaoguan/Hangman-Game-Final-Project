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


class RoleJPanel extends JPanel
{
	private ImageIcon dsPic;
	private ImageIcon kfgPic;
	private ImageIcon hPic;
	private ImageIcon jbPic;
	private ImageIcon nPic;
	private ImageIcon jPic;
	private JButton dsButton;
	private JButton kfgButton;
	private JButton hButton;
	private JButton jbButton;
	private JButton nButton;
	private JButton jButton;
	private JPanel parentPanel;
	private CardLayout parentPanelLayout;
	private Hangman game;
	
	public RoleJPanel(JPanel inputPanel, CardLayout inputLayout, Hangman inputGame)
	{
		parentPanel = inputPanel;
		parentPanelLayout = inputLayout;
		game = inputGame;
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		dsPic = new ImageIcon("src/Images/Dr_Strange.jpg");
		dsPic.setImage(dsPic.getImage().getScaledInstance(280, 280, Image.SCALE_DEFAULT));
		
		kfgPic = new ImageIcon("src/Images/King_of_Game.jpg");
		kfgPic.setImage(kfgPic.getImage().getScaledInstance(280, 280, Image.SCALE_DEFAULT));
		
		hPic = new ImageIcon("src/Images/Hulk.png");
		hPic.setImage(hPic.getImage().getScaledInstance(280, 280, Image.SCALE_DEFAULT));
		
		jbPic = new ImageIcon("src/Images/JamesBond.jpg");
		jbPic.setImage(jbPic.getImage().getScaledInstance(280, 280, Image.SCALE_DEFAULT));
		
		nPic = new ImageIcon("src/Images/Nanny.jpg");
		nPic.setImage(nPic.getImage().getScaledInstance(280, 280, Image.SCALE_DEFAULT));
		
		jPic = new ImageIcon("src/Images/Joker.jpg");
		jPic.setImage(jPic.getImage().getScaledInstance(280, 280, Image.SCALE_DEFAULT));
		
		
		dsButton = new JButton(dsPic);
		kfgButton = new JButton(kfgPic);
		hButton = new JButton(hPic);
		jbButton = new JButton(jbPic);
		nButton = new JButton(nPic);
		jButton = new JButton(jPic);
		//b.setSize(100, 100);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0;
		c.gridx = 1;
		c.gridy = 0;
		JLabel textTitle = new JLabel();
		textTitle.setText("Choose a hero!");
		Font font = new Font("Serif", Font.ITALIC | Font.BOLD, 50);
		textTitle.setFont(font);
		this.add(textTitle,c);
		
		
		dsButton.setBorder(BorderFactory.createRaisedBevelBorder());
		kfgButton.setBorder(BorderFactory.createRaisedBevelBorder());
		hButton.setBorder(BorderFactory.createRaisedBevelBorder());
		jbButton.setBorder(BorderFactory.createRaisedBevelBorder());
		nButton.setBorder(BorderFactory.createRaisedBevelBorder());
		jButton.setBorder(BorderFactory.createRaisedBevelBorder());
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		this.add(dsButton, c);
		
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		this.add(kfgButton, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 1;
		this.add(hButton, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 2;
		this.add(jbButton, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 2;
		this.add(nButton, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 2;
		this.add(jButton, c);
		
		dsButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						game.setRole(new DrStrange());
						
						//frame.setVisible(false);
						//gamePlayPane(game);
						parentPanelLayout.show(parentPanel, "3");
					}
				});
		kfgButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						game.setRole(new KingOfGame());
						//frame.setVisible(false);
						//gamePlayPane(game);
						parentPanelLayout.show(parentPanel, "3");
					}
				});
		hButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						game.setRole(new Hulk());
						//frame.setVisible(false);
						//gamePlayPane(game);
						parentPanelLayout.show(parentPanel, "3");
					}
				});
		
		jbButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						game.setRole(new JamesBond());
						//frame.setVisible(false);
						//gamePlayPane(game);
						parentPanelLayout.show(parentPanel, "3");
					}
				});
		nButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						game.setRole(new Nanny());
						//frame.setVisible(false);
						//gamePlayPane(game);
						parentPanelLayout.show(parentPanel, "3");
					}
				});
		jButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						game.setRole(new Joker());
						//frame.setVisible(false);
						//gamePlayPane(game);
						parentPanelLayout.show(parentPanel, "3");
					}
				});		
		setPreferredSize(new Dimension(900,700));
		
	}
	
}