import javax.swing.ImageIcon;

public class MintInBox implements HangingCharacters
{

	private String description;
	private String endOfGameMessage;
	private ImageIcon image;
	private String name;
	public MintInBox()
	{
		name = "MintInBox";
		image = new ImageIcon("src/Images/Lightsaver.jpeg");
		
		description = "Your most prized possession is your still inbox red double bladed lightsaber from Star Wars Episode 1 The Phantom Menace. It carries memories of simpler time when you were actually happy, not like now. "
				+ "\nAnyway a weirdo breaks into your house hanging your lightsaber from its packaging, he says he’ll give it back if you play hangman, the game that’s all the rage these days. "
				+ "\nIf you guess all the letters of the word he’s guessing, he’ll return it. If you get letters wrong, he’ll keep on hanging the box higher and higher until it rips. You have no choice but to accept. For your childhood.";
		
		endOfGameMessage = "You get your lightsaber back. In your rage, you open the lightsaber and beat the weirdo up with it like a Star Wars guy. But now you realize you broke the original packaging and it holds no true value. "
				+ "\nBut that thought quickly dissipates into a new stronger thought, a resolution. You realize that a toy is meant to be played with and not hoarded. You are happy again like when you were a kid. "
				+ "\nYou thank the weirdo for helping you realize this lesson and he smiles saying, “My job here is done.” He fades from existence.";
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
