import javax.swing.ImageIcon;
import java.util.Random; 

/**
 * 
 * The role Joker
 *
 */
public class Joker extends AbstractRole{
	public Joker() {
		System.out.println("here is Joker");
		roleName = new String("Joker");
		
		description = new String("The Joker's job is to let you happy or cry,\n"
				+ "I will give you extral two chances or minus two chance to guess,\n" + 
				"Let's see how you are lucky!\n\n");
		image = new ImageIcon("src/Images/Joker.jpg");
		skillDialog = "Joker: tell you a joke~(#$!@#%@#!@#$!@#!@#!@#!@)\n"
				+ " Why you don't laugh! I won't save you any more T_T";
	}

	@Override
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
		if(game.getGameChances()>2 && skillChances > 0)
		{
			Random rand = new Random();
			int rand_int1 = rand.nextInt(1000);
			if(rand_int1 % 2 == 0) {
				game.addGameChances(2);;  //get two more chances to guess
			}else
			{
				game.subGameChances(2);;  //minus two chances
			}
			useOfSkill = true;
			setSkillChances(0);
		}
		
	}

}
