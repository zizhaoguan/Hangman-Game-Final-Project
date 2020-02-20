import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Grandma implements HangingCharacters
{

	private String description;
	private String endOfGameMessage;
	private ImageIcon image;
	private String name;
	
	public Grandma()
	{
		name = "Grandma";
		image = new ImageIcon("src/Images/Grandma.jpg");
		
		description = "Some might say Ol’ Granny’s had it too good for too long. She overcooked the ham this thanksgiving and she told that same old story again to all your/NAME’s relatives about all those times you/NAME wet yourself/NAMESELF as a kid and the other day. "
				+ "\nBut she doesn’t deserve to be hanged by cousin Fred, yes that cousin Fred. He’s playing real Hangman with Ol’ Granny again. "
				+ "\nLuckily you came in right on time and if you guess the word cousin Fred is thinking of he’ll let Granny go with just a warning.";
		
		endOfGameMessage = "You/NAME got the word! “I’ll get you next time Ol’ Granny!” says cousin Fred. “Oh I bet you will.” says Ol’ Granny jokingly. “I bet you will. Lets get inside, it’s cold out.”"
				+ "\nYou/NAME goes inside and have a good time at the family reunion.";
		
	}
	
	
	
	@Override
	public String getStory() {
		
		return description;
	}

	@Override
	public ImageIcon getImage() {
		
		return image;
	}

	@Override
	public String getEndOfGameMessage() {
		
		return endOfGameMessage;
	}
	public String getName()
	{
		return name;
	}

}
