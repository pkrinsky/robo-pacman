package pacman.base;


public class Arm {

	public static int MAX_LENGTH = 50;
	public static int MOVE_INCREMENT = 10;

	private static Arm instance = new Arm();
	private int length = 0;

	public static Arm getInstance() {
		return instance;
	}

	public int getLength() {
		return length;
	}

	public void extend() {
		if (length < MAX_LENGTH) length+=MOVE_INCREMENT;
	}

	public void retract() {
		if (length > 0) length-=MOVE_INCREMENT;
	}
	

}
