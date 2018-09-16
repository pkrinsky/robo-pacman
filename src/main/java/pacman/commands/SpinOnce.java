package pacman.commands;

import pacman.base.CommandBase;
import pacman.robot.Robot;

public class SpinOnce extends CommandBase {
	
	int turns = 0;

	protected boolean isFinished() {
		boolean success = false;
		
		if (turns == 4) {
			success = true;
		}
		
		System.out.println("turns:"+turns);
		return success;
	}

	protected void execute() {
		super.execute();
		
		System.out.println("Hello world, watch me spin to the right");
		Robot.driveTrain.tankDrive(1, 0);

		// keep track of the number of times we have turned
		turns = turns + 1;
		
	}
	
	
	
}
