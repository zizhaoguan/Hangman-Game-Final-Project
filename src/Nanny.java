import javax.swing.ImageIcon;

/**
 * 
 * The role Nanny
 *
 */
public class Nanny extends AbstractRole{
	public Nanny() {
		System.out.println("here is Nanny");
		roleName = new String("Nanny"); 
		
		description = new String("The nanny's job is to take care of you,\n"
				+ "I will give you an extral chance to guess,\n" + 
				"Don't worry, and do your best!\n\n");
		image = new ImageIcon("src/Images/Nanny.jpg");
		skillDialog = "Nanny: I just want to take care of the baby,\n"
				+ " I don't want to play Hangman game...";
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
		if(game.getGameChances()>0 && skillChances >0)
		{
			game.addGameChances(1);  //get one more chance to guess	
			useOfSkill = true;
			setSkillChances(0);
		}
		
	}

}
