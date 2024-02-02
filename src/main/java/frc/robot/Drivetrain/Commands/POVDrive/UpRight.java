package frc.robot.Drivetrain.Commands.POVDrive;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Drivetrain.Drivetrain;

public class UpRight extends Command {
    private Drivetrain drivetrain;

    public UpRight(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
    }

    @Override
    // This runs repeatedly while the command is scheduled.
    public void execute() {
        drivetrain.drive(1, 0, 0, 1);
    }
}