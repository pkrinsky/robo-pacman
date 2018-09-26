package pacman.commands;

import pacman.base.CommandGroupBase;
import pacman.robot.Robot;

public class AutoGroup extends CommandGroupBase{
	
	public AutoGroup() {
		addSequential(new DriveStraight(100));  
	} 
	
}
