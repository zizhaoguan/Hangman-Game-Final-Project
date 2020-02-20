import javax.swing.Icon;
import javax.swing.*;

public abstract class AbstractRole implements Role{

	String roleName;  //the name of the role
	String description;  //description of skill
	int skillChances;  //how many available skill chances
	ImageIcon image;  //the role image
	boolean useOfSkill; //if skill is not working, it's false. Otherwise, it become true
	int id;
	String skillDialog;
	
	AbstractRole()
	{
		System.out.println("here is abstract role");
		skillChances = 1;
		useOfSkill = false;
	}
	/**
	 * get the role name
	 * @return roleName
	 */
	public String getName() {
		return roleName;
	}
	/**
	 * @return if the skill is work or not
	 */
	public boolean checkIfSkillWork() {
		return useOfSkill;
	}

	/**
	 * @return the skill description
	 */
	public String getDescription() {	
		return description;
	}
	/**
	 * set how many chances you can use skill
	 * @param chances = the number user can use skill
	 */
	public void setSkillChances(int chances) {
		skillChances = chances;
	}

	/**
	 * @return the chances of available skill
	 */
	public int getSkillChances() {
		return skillChances;
	}
	/**
	 * @return the ImageIcon
	 */
	public Icon getImage() {
		return image;
	}
	
	public String getSkillDialog()
	{
		return skillDialog;
	}
}
