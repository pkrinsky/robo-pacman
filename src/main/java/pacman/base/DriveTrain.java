package pacman.base;

import pacman.graphics.PacmanGraphics;

public class DriveTrain {
	
	public static int MAX_SPEED = 5;
	private double distance = 0;
	private int angle = 0;
	private int posX = PacmanGraphics.WIDTH / 2;
	private int posY = PacmanGraphics.HEIGHT - 100;
	private int speed = 5;
	
	public double getDistance() {
		return distance; 
	}
	
	public void zeroDistance() {
		distance = 0;
	}
	
	public void zeroAngle() {
		angle = 0;
	}
	
	public int getAngle() {
		return angle;
	}
	
	public int getPositionX() {
		return posX;
	}
	
	public int getPositionY() {
		return posY;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void tankDrive(double left, double right) {
		Util.log("DriveTrainBase:tankDrive left:"+left+" right:"+right);

		// calculate speed and angle based on inputs
		if (left == 0 && right == 0) {
			// NEUTRAL: stop
			speed = 0;
			Util.log("DriveTrainBase:tankDrive neutral");
		} else if (left > 0 && right > 0 && left == right) {
			// FORWARD: increase speed
			speed = MAX_SPEED;
			Util.log("DriveTrainBase:tankDrive forward");
		} else if (left < 0 && right < 0 && left == right) {
			// REVERSE: increase speed
			speed = -MAX_SPEED;
			Util.log("DriveTrainBase:tankDrive reverse");
		} else if (left >= 0 && left > right) {
			// RIGHT TURN
			if (speed == 0) {
				angle += 90;	
				Util.log("DriveTrainBase:tankDrive right to:"+angle);
			} else {
				Util.log("DriveTrainBase:tankDrive cant turn while moving");
			}
		} else if (right >= 0 && right > left) {
			if (speed == 0) {
				angle -= 90;	
				Util.log("DriveTrainBase:tankDrive left to:"+angle);
			} else {
				Util.log("DriveTrainBase:tankDrive cant turn while moving");
			}
			
		}

		Util.log("DriveTrainBase:tankDrive speed:"+speed);

		// keep angle [-179,180]
		if (angle < -179) angle += 360;
		if (angle > 180) angle -= 360;

		// update position
		if (angle == 0) {
			posY = posY - speed;
		} else if (angle == 180 || angle == -180) {
			posY = posY + speed;
		} else if (angle == 90) {
			posX = posX + speed;
		} else if (angle == -90) {
			posX = posX - speed;
		}

		// update distance
		distance += Math.abs(speed);


		
		Util.log("DriveTrainBase:tankDrive posX:"+posX+" posY:"+posY+" angle:"+angle+" dist:"+distance);
		
	}	

}
