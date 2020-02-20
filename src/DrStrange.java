import java.awt.Image;

import javax.swing.*;


/**
  the role Doctor Strange
 */
public class DrStrange extends AbstractRole{

	/**
	 * Construct a DrStrange Class
	 */
	public DrStrange()
	{
		System.out.println("here is Dr.Strange");
		roleName = new String("Doctor Strange");
		
		description =new String("time travel: every time when the player "
				+ "has one chance left and only need to guess one more letter to win,"
				+ " the player can choose to restart a new game. ");
		image = new ImageIcon("src/Images/Dr_Strange.jpg");
		
		image.setImage( image.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT) );
		
		skillDialog = "Doctor Strange: I need to come back to the past and start over,\n"
				+ " that's how I pass all the tests!!!";
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
		if(skillChances > 0 && game.getGameChances() == 1)
		{
			setSkillChances(1);
			useOfSkill = true;
			setSkillChances(1);
			game.restart();
		}
	}

}



