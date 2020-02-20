import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;


/**
  the role Doctor Strange
 */
public class JamesBond extends AbstractRole{


	/**
	 * Construct a DrStrange Class
	 */
	public JamesBond()
	{
		System.out.println("here is James Bond");
		roleName = new String("James Bond");
		
		description =new String("Seduce: every time when you "
				+ "go up and handsome charms to seduce the person and get a free letter,"
				+ " but you spend too much time seducing using 2 chances. ");
		image = new ImageIcon("src/Images/JamesBond.jpg");
		
		skillDialog = "James Bond: I can't believe! I'm too handsome!\n"
				+ " Ahhhhh!!! My handsome face makes me blind...chances(-1)";
	}
	
	/**
	 * using skill
	 * @param conditon = how many letters to go
	 * 
	 * when user click on "skill" button, it will show a dialog with description and a box ask
	 * if you want to continue. As long as user click on "yes" button, the actionListner will call the 
	 * event of getSkill. If the skill work (useOfSkill become true), then the skill will effect base on different roles
	 * if the skill work, the Player class should help reset the game chances
	 */
	public void getSkill(Hangman game)
	{
		useOfSkill = false;
		ArrayList<Character> correctWords = new ArrayList<Character>();
		correctWords = game.getAvailableRightLetters();
		Random rand = new Random();
		int size = correctWords.size();
		int rand_int1 = rand.nextInt(size);
		if(skillChances > 0 && game.getGameChances() > 2 && size>0) {
			setSkillChances(0);
			useOfSkill = true;
			game.subGameChances(2);
			game.addRightLetters(correctWords.get(rand_int1));
		}
	}

}


