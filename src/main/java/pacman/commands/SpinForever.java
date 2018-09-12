package pacman.commands;

import pacman.base.CommandBase;
import pacman.robot.Robot;

public class SpinForever extends CommandBase {

	protected void execute() {
		super.execute();
		
		System.out.println("Hello world, watch me spin to the right");
		Robot.driveTrain.tankDrive(1, 0);
		
		// slow down the game so it's easier to see the logs
		sleep(1000);
	}
	
	
	
}
