package frc.robot.Drivetrain.Commands;

import java.util.function.Supplier;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.Drivetrain.Drivetrain;

public class MecanumDrive extends Command {
    private Drivetrain drivetrain;
    private Supplier<Double> xSpeedSupplier;
    private Supplier<Double> zSpeedSupplier;
    private Supplier<Double> zRotationSupplier;

    /**
     * A MecanumDrive command that controls the robot with x speed, z speed, and z
     * rotation
     * 
     * @param drivetrain        The drivetrain subsystem to manipulate
     * @param xSpeedSupplier    A supplier for the robot's speed along the x axis
     * @param zSpeedSupplier    A supplier for the robot's speed along the z axis
     * @param zRotationSupplier A supplier for the robot's rotation along the z axis
     */
    public MecanumDrive(Drivetrain drivetrain, Supplier<Double> xSpeedSupplier, Supplier<Double> zSpeedSupplier, Supplier<Double> zRotationSupplier) {
        this.drivetrain = drivetrain;
        this.xSpeedSupplier = xSpeedSupplier;
        this.zSpeedSupplier = zSpeedSupplier;
        this.zRotationSupplier = zRotationSupplier;
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        // Drives the robot similarly to swerve drive.
        drivetrain.drive(new ChassisSpeeds(xSpeedSupplier.get(), zSpeedSupplier.get(), zRotationSupplier.get()));
    }
}