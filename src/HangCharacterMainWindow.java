import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class HangCharacterMainWindow extends JPanel
{
	private BufferedImage img = null;
	private ArrayList<BufferedImage> subImages;
	private int count;
	

	public HangCharacterMainWindow(Hangman game)
	{
		subImages = new ArrayList<>();
		count = 0;
		try
		{
			if(game.getHangingCharacter().getName().equals("Grandma"))
			{
				img = ImageIO.read(new File("src/Images/ImagesForHanging/Grandma.jpg"));
			}
			
			else if(game.getHangingCharacter().getName().equals("Boss"))
			{
				img = ImageIO.read(new File("src/Images/ImagesForHanging/Boss.jpg"));
			}
			else if(game.getHangingCharacter().getName().equals("Toucan"))
			{
				img = ImageIO.read(new File("src/Images/ImagesForHanging/Toucan.jpg"));
			}
			else if(game.getHangingCharacter().getName().equals("Goose"))
			{
				img = ImageIO.read(new File("src/Images/ImagesForHanging/Goose.jpg"));
			}
			else if(game.getHangingCharacter().getName().equals("Shirt"))
			{
				img = ImageIO.read(new File("src/Images/ImagesForHanging/Shirt.jpg"));
			}
			else if(game.getHangingCharacter().getName().equals("MintInBox"))
			{
				img = ImageIO.read(new File("src/Images/ImagesForHanging/Lightsaver.jpeg"));
			}
		}
		catch (IOException e)
		{
			System.out.println(e);
		}

		

		
		//divideImage();
		this.setPreferredSize(new Dimension(250,250));
		
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		
		g.drawImage(img.getSubimage(0, 0, 252, ((count + 1) * 42)), 0,0, null);
		
	
	}
	
	public void redrawAgain()
	{
		count++;
		repaint();
	}
}
