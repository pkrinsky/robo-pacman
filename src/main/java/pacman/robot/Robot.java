package pacman.robot;

import pacman.base.RobotBase;
import pacman.base.RobotRunner;
import pacman.base.Util;
import pacman.commands.SpinGroup;

public class Robot extends RobotBase {

	
	public static void log(String s) {
		Util.log(s);
	}	
	
	public static void main(String[] args) {

		// create a new robot
		Robot robot = new Robot();
		
		// run the spin routine
		RobotRunner.run(robot, new SpinGroup(), 1000);
		


	}		

}
