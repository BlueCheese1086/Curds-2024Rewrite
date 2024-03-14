package frc.robot.Drivetrain.Commands.Autonomous;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.Drivetrain.Drivetrain;

public class TurnTime extends Command {
    private Drivetrain drivetrain;
    private double speed;
    private double end;

    /**
     * Creates a new TurnTime command. This will turn the romi based off of the
     * supplied speed for a specified number of seconds.
     * 
     * @param drivetrain The subsystem this command will run on.
     * @param speed      The speed at which the robot will drive.
     * @param seconds    How long the robot will move in seconds.
     */
    public TurnTime(Drivetrain drivetrain, double speed, double seconds) {
        this.speed = speed;
        this.end = System.currentTimeMillis() + (seconds * 1000);
        this.drivetrain = drivetrain;
    }

    @Override
    /** Called every time the scheduler runs while the command is scheduled. */
    public void execute() {
        drivetrain.drive(new ChassisSpeeds(0, 0, speed));
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