package pacman.base;

import pacman.base.DriveTrain;

public class RobotBase {
	
	// subsystems
	public static DriveTrain driveTrain;	
	
	public void robotInit() {
		driveTrain = new DriveTrain();
	}	
	
	public void autonomousInit() {
		//driveTrain.zeroLeftEncoder();
		//driveTrain.zeroRightEncoder();
		//driveTrain.zeroGyroRotation();	
	}
	
	public void autonomousPeriodic() {
		//Scheduler.getInstance().run();
		//driveTrain.getGyroRotation();
	}
	
	

}
