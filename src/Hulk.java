import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

/** 
 the role Hulk 
 */
public class Hulk extends AbstractRole{

	/**
	 * Construct a Hulk Class
	 */
	public Hulk()
	{
		System.out.println("here is Hulk");
		roleName = new String("Hulk");
		description =new String("Hulk goes on a rampage which causes one of two events to occur:"
				+ "you get 2 free letters because you beat up the person real bad or "
				+ "you lose 2 chances because you were too busy being crazy. High risk high reward.");
		image = new ImageIcon("src/Images/Hulk.png");
		
		skillDialog = "Hulk: I should use my super strong power\n"
				+ "............I accidently kill the wrong person...";
	}
	@Override
	public void getSkill(Hangman game) 
	{
		useOfSkill = false;
		Random random = new Random();
		int r = random.nextInt(100);
		
		ArrayList <Character> rightLetterSet = game.getAvailableRightLetters(); //get the right letters set from Hangman
		if(rightLetterSet.size()>=2 && skillChances >0 && game.getGameChances()>=2)
		{
			if(r%2==0)
			{
				game.addRightLetters(rightLetterSet.get(0));
				game.addRightLetters(rightLetterSet.get(0));  //rightLetterSet get the reference from ArrayList of AvailableRightLetterSet
															  //so, when it call addRightLetters(), the ArrayList is removing the first letter
															  // the rightLetterSet is changed with the changing of ArrayList that it refers to
			}
			else{ game.subGameChances(2); }
			useOfSkill = true;
			setSkillChances(0);
		}
	}

}
