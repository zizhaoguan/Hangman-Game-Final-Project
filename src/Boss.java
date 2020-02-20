import javax.swing.ImageIcon;

public class Boss implements HangingCharacters
{

	private String description;
	private String endOfGameMessage;
	private ImageIcon image;
	private String  name;
	
	public Boss()
	{
		name = "Boss";
		image = new ImageIcon("src/Images/Boss.jpg");
		
		description = "That skinflint boss of yours has skimped out on your bonus again! But this time you’re not taking it lying down. "
				+ "\nYou hired an assassin to take out your boss but the problem was you were too poor to afford a regular one so you had to go on CraigsList and get a cheap impractical one. "
				+ "\nHe likes to play practical jokes with his victims. See, the assassin will kill your boss by playing real Hangman with him but you have to guess the word for him to off your boss or else he’ll make public your assiassination attempt. "
				+ "\nThis is real serious stuff.";
		
		endOfGameMessage = "The assassin leaves and posts the recorded event online. You go to prison for 15 years for attempted manslaughter."
				+ "\nYou’re a terrible person!";
		
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
