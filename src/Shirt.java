import javax.swing.ImageIcon;

public class Shirt implements HangingCharacters 
{

	private String description;
	private String endOfGameMessage;
	private ImageIcon image;
	private String name;
	
	public Shirt()
	{
		name = "Shirt";
		image = new ImageIcon("src/Images/Shirt.jpg");
		
		description = "You/NAME hung a dripping wet shirt to dry after a night of hardcore partying and getting super wasted. Like you/NAME lost your/NAMESELF most of your brain cells wasted."
				+ "\nYou/NAME’re not sure what made the shirt wet but you/NAME decide/S it’s best not to think about it. It’s dryer now and you/NAME want/S to pick it up to go on another hardcore binge "
				+ "\nbut the wind around you/NAME seems to have developed sentience and is holding it hostage. It’s wants to play Hangman, you/NAME gotta/S guess the word to get your/NAME’S shirt back! ";
		
		endOfGameMessage = "The playful wind, having been satisfied at being bested, blows away to find more poor souls to harass. "
				+ "\nExcited, you/NAME put the shirt on immediately and go off into the night to party some more, never to be seen from again.";
		
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
