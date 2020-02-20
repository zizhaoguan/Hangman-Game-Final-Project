import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartingWindow extends JPanel{
	
	private Image backgroundImage; // Background image
	private JPanel parentPanel;
	private CardLayout parentFrameLayout;
	private JButton quitButton;
	private JButton playButton;
	
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			
			if(e.getSource() == playButton)
			{
				parentFrameLayout.show(parentPanel, "2");
			}
			if (e.getSource() == quitButton)
			{
				System.exit(0);
			}
		}
	}
	
	public StartingWindow(JPanel inputFrame, CardLayout inputLayout) 
	{
		parentPanel = inputFrame;
		parentFrameLayout = inputLayout;
		setLayout(null);
		
		try
		{
			backgroundImage = ImageIO.read(new File("src/Images/startingWindowBackground.png"));
		}
		catch(IOException e)
		{
			System.out.println("Exception Trying to read the image " + e);
		}
		
		this.setPreferredSize(new Dimension (900,700));
		ButtonListener buttonListener = new ButtonListener();
		quitButton = new JButton("Quit");
		quitButton.setBackground(SystemColor.activeCaption);
		quitButton.setForeground(SystemColor.text);
		quitButton.setFont(new Font("Kristen ITC", Font.BOLD, 39));
		quitButton.setBounds(506, 567, 223, 72);
		quitButton.addActionListener(buttonListener);
		add(quitButton);
		
		playButton = new JButton("Play");
		
		playButton.setBackground(SystemColor.activeCaption);
		playButton.setForeground(SystemColor.textHighlightText);
		playButton.setFont(new Font("Kristen ITC", Font.BOLD, 39));
		playButton.setBounds(169, 567, 223, 72);
		playButton.addActionListener(buttonListener);
		add(playButton);
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0,0, null);
	}
}
