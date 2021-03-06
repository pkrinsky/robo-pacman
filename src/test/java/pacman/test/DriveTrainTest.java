package pacman.test;
import static org.junit.Assert.assertEquals;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import org.junit.Test;

import pacman.base.DriveTrain;
import pacman.base.DriveTrainEngine;

public class DriveTrainTest {

    
    @Test public void testSpeed() {
		DriveTrain driveTrain = new DriveTrain();
		DriveTrainEngine engine = new DriveTrainEngine();
    	
    	// starting speed should be zero
    	assertEquals("Speed zero",0,driveTrain.getSpeed());
    	
    	// should immediately accelerate to max speed
		driveTrain.tankDrive(1, 1);
		engine.tankDrive(driveTrain);
    	assertEquals("Speed max of "+DriveTrainEngine.MAX_SPEED,DriveTrainEngine.MAX_SPEED,driveTrain.getSpeed());

    	// should maintain max speed even while driving full out
		driveTrain.tankDrive(1, 1);
		engine.tankDrive(driveTrain);
		driveTrain.tankDrive(1, 1);
		engine.tankDrive(driveTrain);
    	assertEquals("Speed max of "+DriveTrainEngine.MAX_SPEED,DriveTrainEngine.MAX_SPEED,driveTrain.getSpeed());

    	// should stop when trying to turn
		driveTrain.tankDrive(1, 1);
		engine.tankDrive(driveTrain);
		driveTrain.tankDrive(0, 1);
		engine.tankDrive(driveTrain);
    	assertEquals("Speed should be zero",0,driveTrain.getSpeed());
    	
    	// should stop when trying to turn
		driveTrain.tankDrive(1, 1);
		engine.tankDrive(driveTrain);
		driveTrain.tankDrive(1, 0);
		engine.tankDrive(driveTrain);
    	assertEquals("Speed should be zero",0,driveTrain.getSpeed());

    	// should immediately stop
		driveTrain.tankDrive(0, 0);
		engine.tankDrive(driveTrain);
    	assertEquals("Speed should be zero",0,driveTrain.getSpeed());

    	// should accelerate to max for anything > 0
		driveTrain.tankDrive(0, 0);
		engine.tankDrive(driveTrain);
		driveTrain.tankDrive(0.5, 0.5);
		engine.tankDrive(driveTrain);
    	assertEquals("Speed max of "+DriveTrainEngine.MAX_SPEED,DriveTrainEngine.MAX_SPEED,driveTrain.getSpeed());

    	// should accelerate to max for anything > 0
		driveTrain.tankDrive(0,0);
		engine.tankDrive(driveTrain);
		driveTrain.tankDrive(0, 0.5);
		engine.tankDrive(driveTrain);
    	assertEquals("Speed should be zero",0,driveTrain.getSpeed());

    }
    
    @Test public void testAngle() {
		DriveTrain driveTrain = new DriveTrain();
		DriveTrainEngine engine = new DriveTrainEngine();
    	
    	// starting angle should be zero
    	assertEquals("Angle zero",0,driveTrain.getAngle());
    	
    	// right turn
		driveTrain.tankDrive(1,0);
		engine.tankDrive(driveTrain);
    	assertEquals("Angle error",90,driveTrain.getAngle());

		driveTrain.tankDrive(1,0);
		engine.tankDrive(driveTrain);
    	assertEquals("Angle error",180,driveTrain.getAngle());

		driveTrain.tankDrive(1,0);
		engine.tankDrive(driveTrain);
    	assertEquals("Angle error",-90,driveTrain.getAngle());

		driveTrain.tankDrive(1,0);
		engine.tankDrive(driveTrain);
    	assertEquals("Angle error",0,driveTrain.getAngle());
    	
    	// left turn
		driveTrain.tankDrive(0,1);
		engine.tankDrive(driveTrain);
    	assertEquals("Angle error",-90,driveTrain.getAngle());

		driveTrain.tankDrive(0,1);
		engine.tankDrive(driveTrain);
    	assertEquals("Angle error",180,driveTrain.getAngle());

		driveTrain.tankDrive(0,1);
		engine.tankDrive(driveTrain);
    	assertEquals("Angle error",90,driveTrain.getAngle());

		driveTrain.tankDrive(0,1);
		engine.tankDrive(driveTrain);
    	assertEquals("Angle error",0,driveTrain.getAngle());

    	// partial left turn should still be 90 degrees
		driveTrain.tankDrive(0,0.5);
		engine.tankDrive(driveTrain);
    	assertEquals("Angle error",-90,driveTrain.getAngle());
    	
		driveTrain.tankDrive(0.5,0);
		engine.tankDrive(driveTrain);
    	assertEquals("Angle error",0,driveTrain.getAngle());
    	
    }
}
