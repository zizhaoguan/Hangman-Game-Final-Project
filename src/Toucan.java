import javax.swing.ImageIcon;

public class Toucan implements HangingCharacters {

	private String description;
	private String endOfGameMessage;
	private ImageIcon image;
	private String name;
	
	public Toucan()
	{
		name = "Toucan";
		image = new ImageIcon("src/Images/Toucan.jpg");
		
		description = "You are in the Amazon rainforest, here to see the beautiful toucans. They are highly endangered and you wanted to see them before they go away. But international terrorists have come in to accelerate that timeline. "
				+ "\nThey call themselves, The Toucan Killers, dedicated to getting rid of them all over the world to free people from their multicolored evil. "
				+ "\nThey have all the toucans on nooses and getting ready on finishing the last batch of toucans but you step in and challenge them to a game of Hangman, where if you guess the letters of the word they’re thinking of they’ll let them go. "
				+ "\nThey can’t deny this as this is their custom. You’re their only chance. Go!";
		
		endOfGameMessage = "The terrorists let them go as they lost. The police come in and send them to the big house. The toucans take you into the sky to live with them. Another crisis averted. "
				+ "\nAnother day in the life of you.";
		
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
