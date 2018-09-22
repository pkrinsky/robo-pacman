package pacman.base;

import pacman.graphics.PacmanGraphics;

public class RobotRunner {

	public static final double MAX_TIME = 15;
	
	public static void run(RobotBase robot, CommandGroupBase group) {
		run(robot,group,100);
	}
	
	public static void run(RobotBase robot, CommandGroupBase group, long delay) {
		
		boolean running = true;
		int currentCommand = 0;
		boolean runInit = true;
		
		Util.log("RobotRunner:robot.robotInit");
		robot.robotInit();
		
		PacmanGraphics graphics = new PacmanGraphics();
		graphics.setup();
		
		while (running && graphics.getTime() < MAX_TIME) {
			
			// get a command from the group
			CommandBase command = group.getCommand(currentCommand);
			
			// check to see if this command is finished and get another
			if (command != null) {
				// if command has been initialized then check to see if it is finished
				if (!runInit) {
					Util.log("RobotRunner: check if command is finished");
					boolean finished = command.isFinished(); 
					if (finished) {
						Util.log("RobotRunner:command "+command.getClass().getName()+" isFinished: true");
						currentCommand ++;
						runInit = true;
						command = group.getCommand(currentCommand);
						if (command != null) Util.log("RobotRunner:got next command "+command.getClass().getName());
					} else {
						Util.log("RobotRunner:command "+command.getClass().getName()+" isFinished: false");
					}
				} 
			}
			
			if (command == null) {
				running = false;
				Util.log("RobotRunner:no commands to run");
			} else {
				if (runInit) {
					Util.log("RobotRunner:initialize command "+command.getClass().getName());
					command.initialize();
					runInit = false;
				}
				Util.log("RobotRunner:execute command "+command.getClass().getName());
				command.execute();	
			}
			
			graphics.drawField(robot);
			
			
			// add a little delay
			try {
				Thread.sleep(delay);
				Util.log("--------------------------\n\n");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		Util.log("RobotRunner:done score:"+graphics.getScore());
		
	}

}
