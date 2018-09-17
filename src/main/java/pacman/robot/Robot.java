package pacman.robot;

import pacman.base.RobotBase;
import pacman.base.RobotRunner;
import pacman.base.Util;
import pacman.commands.*;

public class Robot extends RobotBase {

	public static void log(String s) {
		Util.log(s);
	}	
	
	public static void main(String[] args) {

		// how long to wait (in ms) before the next loop
		long delay = 100;

		// create a new robot
		Robot robot = new Robot();
		
		// run the command group
		RobotRunner.run(robot, new SpinGroup(), delay);
		
	}		

}
