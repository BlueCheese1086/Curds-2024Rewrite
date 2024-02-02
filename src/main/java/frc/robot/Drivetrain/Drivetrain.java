package frc.robot.Drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.DriveConfig;
import frc.robot.Constants.RobotMap;

public class Drivetrain extends SubsystemBase {
    // Creates the motors.
    private static TalonSRX frontLeft = new TalonSRX(RobotMap.FrontLeft);
    private static TalonSRX frontRight = new TalonSRX(RobotMap.FrontRight);
    private static TalonSRX backLeft = new TalonSRX(RobotMap.BackLeft);
    private static TalonSRX backRight = new TalonSRX(RobotMap.BackRight);

    // Sets up the motors.
    public Drivetrain() {
        frontRight.setInverted(true);
        backRight.setInverted(true);
    }

    /** Allows for better control of the motors on the robot */
    public void drive(double frontLeftSpeed, double frontRightSpeed, double backLeftSpeed, double backRightSpeed) {
        frontLeft.set(ControlMode.PercentOutput, frontLeftSpeed * DriveConfig.maxSpeed);
        frontRight.set(ControlMode.PercentOutput, frontRightSpeed * DriveConfig.maxSpeed);
        backLeft.set(ControlMode.PercentOutput, backLeftSpeed * DriveConfig.maxSpeed);
        backRight.set(ControlMode.PercentOutput, backRightSpeed * DriveConfig.maxSpeed);
    }

    /** Performs calculations to find the necessary speeds of each motor, and then puts it into the drive function. */
    public void arcadeDrive(double xSpeed, double zRotation) {
        xSpeed = MathUtil.applyDeadband(xSpeed, DriveConfig.deadband);
        zRotation = MathUtil.applyDeadband(zRotation, DriveConfig.deadband);

        xSpeed = MathUtil.clamp(xSpeed, -1.0, 1.0);
        zRotation = MathUtil.clamp(zRotation, -1.0, 1.0);

        if (DriveConfig.squareInputs) {
            xSpeed = Math.copySign(xSpeed * xSpeed, xSpeed);
            zRotation = Math.copySign(zRotation * zRotation, zRotation);
        }

        double leftSpeed = xSpeed - zRotation;
        double rightSpeed = xSpeed + zRotation;

        double greaterInput = Math.max(Math.abs(xSpeed), Math.abs(zRotation));
        double lesserInput = Math.min(Math.abs(xSpeed), Math.abs(zRotation));
        if (greaterInput != 0.0) {
            double saturatedInput = (greaterInput + lesserInput) / greaterInput;
            leftSpeed /= saturatedInput;
            rightSpeed /= saturatedInput;
        }

        drive(leftSpeed, rightSpeed, leftSpeed, rightSpeed);
    }
}