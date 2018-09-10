package pacman;
import static org.junit.Assert.assertEquals;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import org.junit.Test;

import pacman.base.DriveTrain;

public class DriveTrainTest {

    
    @Test public void testDriveTrainSpeed() {
    	DriveTrain dt = new DriveTrain();
    	
    	// starting speed should be zero
    	assertEquals("Speed zero",0,dt.getSpeed());
    	
    	// should immediately accelerate to max speed
    	dt.tankDrive(1, 1);
    	assertEquals("Speed max of "+DriveTrain.MAX_SPEED,DriveTrain.MAX_SPEED,dt.getSpeed());

    	// should maintain max speed even while driving full out
    	dt.tankDrive(1, 1);
    	dt.tankDrive(1, 1);
    	assertEquals("Speed max of "+DriveTrain.MAX_SPEED,DriveTrain.MAX_SPEED,dt.getSpeed());

    	// should stop when trying to turn
    	dt.tankDrive(1, 1);
    	dt.tankDrive(0, 1);
    	assertEquals("Speed should be zero",0,dt.getSpeed());
    	
    	// should stop when trying to turn
    	dt.tankDrive(1, 1);
    	dt.tankDrive(1, 0);
    	assertEquals("Speed should be zero",0,dt.getSpeed());

    	// should immediately stop
    	dt.tankDrive(0, 0);
    	assertEquals("Speed should be zero",0,dt.getSpeed());

    	// should accelerate to max for anything > 0
    	dt.tankDrive(0, 0);
    	dt.tankDrive(0.5, 0.5);
    	assertEquals("Speed max of "+DriveTrain.MAX_SPEED,DriveTrain.MAX_SPEED,dt.getSpeed());

    	// should accelerate to max for anything > 0
    	dt.tankDrive(0,0);
    	dt.tankDrive(0, 0.5);
    	assertEquals("Speed should be zero",0,dt.getSpeed());

    }
    

}
