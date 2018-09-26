package pacman.base;

import java.util.concurrent.ThreadLocalRandom;

public class RobotBase {

	private int startingPosition = ThreadLocalRandom.current().nextInt(1,4);;

	// subsystems
	public static DriveTrain driveTrain = new DriveTrain();
	public static GhostSensor ghostSensor = new GhostSensor();

	public int getStartingPosition() {
		return startingPosition;
	}

	public void robotInit() {
	}
	
}
