package frc.robot.Drivetrain.Commands.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.Drivetrain.Commands.Autonomous.MecanumTime.Directions;
import frc.robot.Drivetrain.Drivetrain;

// Due to a suspicious lack of encoders on NSP, these commands will be based off of time, and not distance.
public class Autonomous extends SequentialCommandGroup {
    public Autonomous(Drivetrain drivetrain) {
        addCommands(
            new DriveTime(drivetrain, 1, 1),
            new TurnTime(drivetrain, 1, 1),
            new MecanumTime(drivetrain, 1, Directions.DOWN, 1)
        );
    }
}