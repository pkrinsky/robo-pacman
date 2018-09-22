package pacman.commands;

import pacman.base.Arm;
import pacman.base.CommandBase;
import pacman.base.Util;

public class ExtendArm extends CommandBase {
	
	private boolean success = false;
	private Arm arm;
	
	protected void execute() {
		Util.log("Extending Arm");
		int currentLength = arm.getLength();
		
		if (currentLength == Arm.MAX_LENGTH) {
			success = true;
		} else {
			arm.extend();
		}
	}

	protected boolean isFinished() {
		Util.log("Extend isFinished with Arm at "+arm.getLength());
		return success;	
	}

}
