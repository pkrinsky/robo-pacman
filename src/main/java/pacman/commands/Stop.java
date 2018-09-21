package pacman.commands;

import pacman.base.CommandBase;
import pacman.base.DriveTrain;

public class Stop extends CommandBase {

	protected void execute() {
		super.execute();
		
		DriveTrain.getInstance().tankDrive(0, 0);
		
	}
	
	
	
}
