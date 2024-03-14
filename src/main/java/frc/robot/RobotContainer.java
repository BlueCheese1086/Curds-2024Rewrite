// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.Drivetrain.Commands.*;
import frc.robot.Drivetrain.Commands.Autonomous.*;
import frc.robot.Drivetrain.Drivetrain;

public class RobotContainer {
    // Defining subsystems
    private Drivetrain drivetrain = new Drivetrain();

    // Defining controllers
    private CommandJoystick joystick = new CommandJoystick(0);

    // Boolean that allow the user to switch between drive modes.
    // True is ArcadeDrive, false is MecanumDrive.
    private static boolean driveMode = true;

    public RobotContainer() {
        configureBindings();
    }

    // This is where all of the buttons are bound to different commands.
    private void configureBindings() {
        /*
         * Controls:
         * B Button: Switches the drive mode from Arcade to Mecanum
         */
        joystick.button(2).onTrue(new InstantCommand(RobotContainer::switchDriveMode, drivetrain));
    }

    public static void switchDriveMode() {
        driveMode = !driveMode;
    }

    public Command getAutonomousCommand() {
        return new Autonomous(drivetrain);
    }

    public Command getTeleopCommand() {
        if (driveMode) {
            return new ArcadeDrive(drivetrain, () -> -joystick.getRawAxis(1), () -> joystick.getRawAxis(4));
        }
        return new MecanumDrive(drivetrain, () -> -joystick.getRawAxis(1), () -> joystick.getRawAxis(0),
                () -> joystick.getRawAxis(4));
    }
}