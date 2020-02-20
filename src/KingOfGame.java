
import java.util.Random;

import javax.swing.ImageIcon;

/**
the role of King of Game
 */
public class KingOfGame extends AbstractRole{

//	private char choiceOfRightLetter;
//	private char choiceOfWrongLetter ;
	public KingOfGame()
	{
		System.out.println("here is King of Game");
		roleName = new String("King of Game");
		
		description =new String("I will win the game: you always believe you will win the game."
				+ " Your belief has touched the God of Game, "
				+ "so God is going to give you two letters(one is right, another is wrong) to choose from.");
						
		image = new ImageIcon("src/Images/King_of_Game.jpg");
		
		skillDialog = "King of Game: I can win any game\n"
				+ " because I trust I am always make right choice!\n "
				+ "go! Pikachu!......Oh, no, wrong movie...";

	}
	
	/**
	 * using skill
	 * @param conditon doesn't have condition for this role
	 * 
	 * when user click on "skill" button, it will show a dialog with description and a box ask
	 * if you want to continue. As long as user click on "yes" button, the actionListner will call the 
	 * event of getSkill. If the skill work (useOfSkill become true), then the skill will effect base on different roles
	 * if the skill work, then system will show 2 choices of letters, one is true
	 */
	public void getSkill(Hangman game)
	{
//		int randomNum1;
//		int randomNum2;
//		int size1 = game.getAvailableRightLetters().size();//get the size of the available correct letters from the word
//		int size2 = game.getAvailableWrongLetters().size();//get the size of the available wrong letters from the remaining alphabet
//		Random rand = new Random();
		
		useOfSkill = false;
		if(game.checkWin()==false && game.checkLose()==false && skillChances > 0) 
		{
			if(game.getAvailableRightLetters().isEmpty() || game.getAvailableWrongLetters().isEmpty()) {System.out.println("There is no letter in the set");}
			else
			{
//				randomNum1 = rand.nextInt(size1);
//				randomNum2 = rand.nextInt(size2);
//				choiceOfRightLetter=  game.getAvailableRightLetters().get(randomNum1);
//				choiceOfWrongLetter= game.getAvailableWrongLetters().get(randomNum2);
				useOfSkill = true;
				setSkillChances(0);
			}
		}
		else {System.out.println("The game is end...you cannot use skill");}
		
		//System.out.println("The correct letter for choosing is: "+choiceOfRightLetter+'\n'+"The Wrong letter for choosing is: "+choiceOfWrongLetter);
	}
//	char getChoiceRight()
//	{
//		return choiceOfRightLetter;
//	}
//	char getChoiceWrong()
//	{
//		return choiceOfWrongLetter;
//	}

}
