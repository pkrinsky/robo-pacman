package pacman.robot;

import pacman.base.RobotBase;
import pacman.base.RobotRunner;
import pacman.commands.AutoGroup;

public class Robot extends RobotBase {

	// Robot is a singleton
	private static Robot robot = new Robot();

	public static Robot getInstance() {
		return robot;
	}

	public static void main(String[] args) {
		// how long to wait (in ms) before the next loop
		long delay = 100;

		// run the command group
		RobotRunner.run(robot,new AutoGroup(), delay);

	}

}
