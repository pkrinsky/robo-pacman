package pacman.base;

import pacman.graphics.PacmanGraphics;
import pacman.robot.Robot;

public class RobotRunner {
	
	public static void run(RobotBase robot, CommandGroupBase group) {
		run(robot,group,100);
	}
	
	public static void run(RobotBase robot, CommandGroupBase group, long delay) {
		
		boolean running = true;
		int currentCommand = 0;
		boolean runInit = true;
		
		Util.log("RobotRunner:robotInit");
		robot.robotInit();
		
		PacmanGraphics graphics = new PacmanGraphics();
		graphics.setup();
		
		while (running && PacmanGraphics.getTime() < 30) {
			
			CommandBase command = group.getCommand(currentCommand);
			
			// check to see if this command is finished
			if (command != null) {
				Util.log("RobotRunner:got command "+command.getClass().getName()+" isFinished:"+command.isFinished());
				if (command.isFinished()) {
					currentCommand ++;
					runInit = true;
					command = group.getCommand(currentCommand);
					if (command != null)
						Util.log("RobotRunner:got next command "+command.getClass().getName());
				}
			} else {
				Util.log("RobotRunner:no commands to run");
			}
			
			if (command == null) {
				running = false;
			} else {
				if (runInit) {
					command.initialize();
					runInit = false;
				}
				Util.log("RobotRunner:execute "+command.getClass().getName());
				command.execute();	
			}
			
			graphics.drawField(RobotBase.driveTrain.getPositionX(), RobotBase.driveTrain.getPositionY(), Robot.driveTrain.getAngle());
			
			
			// add a little delay
			try {
				Thread.sleep(delay);
				Util.log("--------------------------\n\n");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		Util.log("RobotRunner:done score:"+PacmanGraphics.getScore());
		
	}

}
