package frc.robot.Drivetrain.Commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.Drivetrain.Drivetrain;

public class ArcadeDrive extends Command {
    private Drivetrain drivetrain;
    private Supplier<Double> xSpeedSupplier;
    private Supplier<Double> zRotationSupplier;

    /** 
     * A general ArcadeDrive command that controls the robot with x speed and z rotation
     * 
     * @param drivetrain The drivetrain subsystem to manipulate
     * @param xSpeedSupplier A supplier for the robot's speed along the x axis
     * @param zRotationSupplier A supplier for the robot's rotation along the z axis
    */
    public ArcadeDrive(Drivetrain drivetrain, Supplier<Double> xSpeedSupplier, Supplier<Double> zRotationSupplier) {
        this.drivetrain = drivetrain;
        this.xSpeedSupplier = xSpeedSupplier;
        this.zRotationSupplier = zRotationSupplier;
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        drivetrain.arcadeDrive(xSpeedSupplier.get(), zRotationSupplier.get());
    }
}