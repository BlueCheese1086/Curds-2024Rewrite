package frc.robot;

import edu.wpi.first.math.util.Units;

public class Constants {
    public class DriveConstants {
        // Motor IDs
        public static final int FrontLeft = 1;
        public static final int FrontRight = 2;
        public static final int BackLeft = 3;
        public static final int BackRight = 4;

        // Robot Dimensions
        public static final double robotHeight = Units.inchesToMeters(0);
        public static final double robotWidth = Units.inchesToMeters(0);

        public static final boolean squareInputs = true; // Whether or not to square the inputs in the Drivetrain file.
        public static final double deadband = 0.02; // The deadband for the controllers.
        public static final double maxSpeed = 0.4; // The maximum output for the motors.
        public static final double radius = 0.25; // The radius of the wheels in feet.
    }
}