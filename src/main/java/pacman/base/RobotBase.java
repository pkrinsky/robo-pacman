package pacman.base;

import java.util.concurrent.ThreadLocalRandom;

public class RobotBase {

	

	// subsystems
	public static DriveTrain driveTrain = new DriveTrain();
	public static GhostSensor ghostSensor = new GhostSensor();

	public void robotInit() {
	}
	
}
