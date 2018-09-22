package pacman.commands;

import pacman.base.CommandBase;
import pacman.robot.Robot;

public class SpinOnce extends CommandBase {
	
	int startingAngle;

	protected void initialize() {
		super.initialize();
		this.startingAngle = Robot.driveTrain.getAngle();
	}

	protected boolean isFinished() {
		boolean success = false;
		
		if (startingAngle == Robot.driveTrain.getAngle()) {
			success = true;
		}
		
		return success;
	}

	protected void execute() {
		super.execute();
		
		Robot.driveTrain.tankDrive(1, 0);

		
	}
	
	
	
}
