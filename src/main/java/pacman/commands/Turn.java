package pacman.commands;

import pacman.base.CommandBase;
import pacman.base.DriveTrain;
import pacman.base.Util;

public class Turn extends CommandBase {
	
	private boolean success = false;
	private int targetAngle;
	private DriveTrain driveTrain = DriveTrain.getInstance();
	
	public Turn(int angle) {
		super();
		
		// save the target angle for later
		this.targetAngle = angle;
		Util.log("Turn:targetAngle:"+targetAngle);
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		int currentAngle = driveTrain.getAngle();
		Util.log("Turn:currentAngle:"+currentAngle);
		
		// if we have turned far enough then stop
		if (currentAngle == targetAngle) {
			driveTrain.tankDrive(0, 0);
			success = true;
		} else {
			// compare the current to the target angle to see which way to turn
			if (currentAngle < targetAngle) {
				driveTrain.tankDrive(1, -1);	
			} else {
				driveTrain.tankDrive(-1, 1);
			}
		}
	}

	protected boolean isFinished() {
		return success;	
	}

}
