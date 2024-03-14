package frc.robot.Drivetrain.Commands.Autonomous;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.Drivetrain.Drivetrain;

public class DriveTime extends Command {
    private Drivetrain drivetrain;
    private double speed;
    private double end;

    /**
     * Creates a new DriveTime command. This command drives the robot forward at a
     * desired speed for a set amount of time.
     * 
     * @param drivetrain The subsystem that the command will run on.
     * @param speed      The speed the robot will move at.
     * @param seconds    How long the robot will move forward.
     */
    public DriveTime(Drivetrain drivetrain, double speed, double seconds) {
        this.drivetrain = drivetrain;
        this.speed = speed;
        this.end = System.currentTimeMillis() + (seconds * 1000);
    }

    @Override
    /** Called every time the scheduler runs while the command is scheduled. */
    public void execute() {
        drivetrain.drive(new ChassisSpeeds(speed, 0, 0));
    }

    @Override
    /** Called once the command ends or is interrupted. */
    public void end(boolean interrupted) {
        drivetrain.drive(new ChassisSpeeds(0, 0, 0));
    }

    @Override
    /** Returns true when the command should end. */
    public boolean isFinished() {
        return (System.currentTimeMillis() >= end);
    }
}