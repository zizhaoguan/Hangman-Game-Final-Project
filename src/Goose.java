import javax.swing.ImageIcon;

public class Goose implements HangingCharacters
{

	private String description;
	private String endOfGameMessage;
	private ImageIcon image;
	private String name;
	
	public Goose()
	{
		name = "Goose";
		image = new ImageIcon("src/Images/Goose.jpg");
		
		description = "Looks like your dang pet goose, Lucy the Goosey, has got into trouble again. She’s caught in a noose by a really hungry homeless man. You lock eyes with him and you can tell he means business, goose business. "
				+ "\n“This here my lunch and you ain’t gunna take it from me. Unless you can entertain me. I of course mean hangman. Goose hangman. Get the letters right and I’ll let the little fella go.”"
				+ "\nAs a responsible goose owner, you accept. These things happen but it’s okay, you did the training.";
		
		endOfGameMessage = "You save Lucy! What a hero! “Ah, I should have known better than to mess with a goose owner! Y’all are hangman experts! Guess I’ll look for rats now.” "
				+ "\nYou scold Lucy for being so naughty and running off but you know it’s just a day in the life of a goose owner.";
		
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
