package frc.robot.Drivetrain;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.MecanumDriveKinematics;
import edu.wpi.first.math.kinematics.MecanumDriveWheelSpeeds;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.DriveConstants;

public class Drivetrain extends SubsystemBase {
    // Creates the motors.
    private TalonSRX frontLeft = new TalonSRX(DriveConstants.FrontLeft);
    private TalonSRX frontRight = new TalonSRX(DriveConstants.FrontRight);
    private TalonSRX backLeft = new TalonSRX(DriveConstants.BackLeft);
    private TalonSRX backRight = new TalonSRX(DriveConstants.BackRight);

    // Kinematics
    private MecanumDriveKinematics kinematics;

    // Sets up the motors.
    public Drivetrain() {
        // Configuring motor settings
        frontLeft.configFactoryDefault();
        backLeft.configFactoryDefault();
        frontRight.configFactoryDefault();
        backRight.configFactoryDefault();

        frontLeft.setNeutralMode(NeutralMode.Brake);
        backLeft.setNeutralMode(NeutralMode.Brake);
        frontRight.setNeutralMode(NeutralMode.Brake);
        backRight.setNeutralMode(NeutralMode.Brake);

        frontLeft.setInverted(true);
        backLeft.setInverted(true);
        frontRight.setInverted(false);
        backRight.setInverted(false);

        // Creating the kinematics for the robot
        kinematics = new MecanumDriveKinematics(
            new Translation2d(DriveConstants.robotWidth / 2, DriveConstants.robotHeight / 2),
            new Translation2d(DriveConstants.robotWidth / 2, DriveConstants.robotHeight / 2),
            new Translation2d(DriveConstants.robotWidth / 2, DriveConstants.robotHeight / 2),
            new Translation2d(DriveConstants.robotWidth / 2, DriveConstants.robotHeight / 2)
        );
    }

    public void drive(ChassisSpeeds speeds) {
        MecanumDriveWheelSpeeds driveSpeeds = kinematics.toWheelSpeeds(speeds);

        // Driving with the WheelSpeeds
        frontLeft.set(ControlMode.PercentOutput, driveSpeeds.frontLeftMetersPerSecond);
        backLeft.set(ControlMode.PercentOutput, driveSpeeds.rearLeftMetersPerSecond);
        frontRight.set(ControlMode.PercentOutput, driveSpeeds.frontRightMetersPerSecond);
        backRight.set(ControlMode.PercentOutput, driveSpeeds.rearRightMetersPerSecond);
    }
}