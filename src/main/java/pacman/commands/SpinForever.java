package pacman.commands;

import pacman.base.CommandBase;
import pacman.robot.Robot;

public class SpinForever extends CommandBase {

	@Override
	protected void initialize() {
		System.out.println("init");
	}

	@Override
	protected void execute() {
		Robot.driveTrain.tankDrive(1, 0);
		sleep(200);
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

}
