package pacman.commands;

import pacman.base.CommandBase;
import pacman.base.DriveTrain;

public class SpinForever extends CommandBase {

	protected void execute() {
		super.execute();
		
		System.out.println("Hello world, watch me spin to the right");
		DriveTrain.getInstance().tankDrive(1, 0);
		
	}
	
	
	
}
