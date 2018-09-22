package pacman.commands;

import pacman.base.CommandBase;
import pacman.robot.Robot;

public class Stop extends CommandBase {

	protected void execute() {
		super.execute();
		
		Robot.driveTrain.tankDrive(0, 0);
		
	}
	
	
	
}
