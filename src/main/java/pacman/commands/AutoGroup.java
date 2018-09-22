package pacman.commands;

import pacman.base.CommandGroupBase;

public class AutoGroup extends CommandGroupBase{
	
	public AutoGroup() {
		addSequential(new DriveStraight(200));  
		addSequential(new Turn(90));
		addSequential(new DriveStraight(200));
		addSequential(new Turn(0));
		addSequential(new DriveStraight(200));
		addSequential(new Turn(-90));
		addSequential(new DriveStraight(400));
		addSequential(new Turn(180));
		addSequential(new DriveStraight(300));
		addSequential(new Turn(180));
		addSequential(new DriveStraight(50));
		addSequential(new Turn(90));
		addSequential(new DriveStraight(50));
	} 
	
}
