package pacman.robot;

import pacman.base.RobotBase;
import pacman.base.RobotRunner;
import pacman.base.Util;
import pacman.commands.AutoGroup;

public class Robot extends RobotBase {
	
	public static void log(String s) {
		Util.log(s);
	}	
	
	public static void main(String[] args) {
		Robot robot = new Robot();
		RobotRunner.run(robot, new AutoGroup());
	}		

}
