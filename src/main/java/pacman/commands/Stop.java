package pacman.commands;

import pacman.base.CommandBase;
import pacman.robot.Robot;

public class Stop extends CommandBase {

	@Override
	protected void execute() {
		Robot.driveTrain.tankDrive(0, 0);
	}
	
	
	
}
