package frc.robot;

public class Constants {
    public class RobotMap { // All the motor IDs of the robot
        public static final int FrontLeft = 1;
        public static final int FrontRight = 2;
        public static final int BackLeft = 3;
        public static final int BackRight = 4;
    }

    public class DriveConfig {
        public static final boolean squareInputs = true; // Whether or not to square the inputs in the Drivetrain file.
        public static final double deadband = 0.02; // The deadband for the controllers.
        public static final double maxSpeed = 0.4; // The maximum output for the motors.
        public static final double radius = 0.25; // The radius of the wheels in feet.
    }
}