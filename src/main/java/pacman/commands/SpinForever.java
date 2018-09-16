package pacman.commands;

import pacman.base.CommandBase;
import pacman.robot.Robot;

public class SpinForever extends CommandBase {

	protected void execute() {
		super.execute();
		
		System.out.println("Hello world, watch me spin to the right");
		Robot.driveTrain.tankDrive(1, 0);
		
	}
	
	
	
}
