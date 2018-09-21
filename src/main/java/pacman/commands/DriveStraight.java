package pacman.commands;

import pacman.base.CommandBase;
import pacman.base.DriveTrain;
import pacman.base.Util;

public class DriveStraight extends CommandBase {
	
	private double targetDistance;
	private double startDistance;
	private boolean success = false;
	private DriveTrain driveTrain = DriveTrain.getInstance();
	
	public DriveStraight(double distance) {
		super();
		// save the target distance for later
		this.targetDistance = distance;
		Util.log("DriveStraight:targetDistance:"+targetDistance);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		// save the starting point for later
		startDistance = driveTrain.getDistance();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		// calc distance traveled since this command started
		double currentDistance = driveTrain.getDistance() - startDistance;
		Util.log("DriveStraight:currentDistance:"+currentDistance);
		
		// if we have gone far enough then stop
		if (currentDistance >= targetDistance) {
			driveTrain.tankDrive(0, 0);
			success = true;
		} else {
			driveTrain.tankDrive(1, 1);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return success;
	}

}
