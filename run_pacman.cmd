
rem run pacman game
rem note this assumes project was built by Gradle and uses build subdir
rem if not building with Gradle and using something like Eclipse then may need to point to bin

java -cp build/classes/java/main;build/resources/main pacman.robot.Robot

