package frc.robot.Drivetrain.Commands.POVDrive;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Drivetrain.Drivetrain;

public class UpLeft extends Command {
    private Drivetrain drivetrain;

    public UpLeft(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
    }

    @Override
    // This run repeatedly while the command is scheduled.
    public void execute() {
        drivetrain.drive(0, 1, 1, 0);
    }
}