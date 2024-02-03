// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.Drivetrain.Drivetrain;
import frc.robot.Drivetrain.Commands.ArcadeDrive;
import frc.robot.Drivetrain.Commands.Autonomous.*;
import frc.robot.Drivetrain.Commands.POVDrive.*;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {
  Drivetrain drivetrain = new Drivetrain();
  Joystick joystick = new Joystick(0);

  public RobotContainer() {
    configureBindings();
  }

  // This is where all of the buttons are bound to different commands.
  private void configureBindings() {
    // Allows the robot to be driven with the POV Controls on the joystick.
    new POVButton(joystick, 0).whileTrue(new Up(drivetrain));           // Up
    new POVButton(joystick, 45).whileTrue(new UpRight(drivetrain));     // Up-Right
    new POVButton(joystick, 90).whileTrue(new Right(drivetrain));       // Right
    new POVButton(joystick, 135).whileTrue(new DownRight(drivetrain));  // Down-Right
    new POVButton(joystick, 180).whileTrue(new Down(drivetrain));       // Down
    new POVButton(joystick, 225).whileTrue(new DownLeft(drivetrain));   // Down-Left
    new POVButton(joystick, 270).whileTrue(new Left(drivetrain));       // Left
    new POVButton(joystick, 315).whileTrue(new UpLeft(drivetrain));     // Up-Left
  }

  public Command getAutonomousCommand() {
    return new Autonomous(drivetrain);
  }

  public Command getTeleopCommand() {
    return new ArcadeDrive(drivetrain, () -> -joystick.getRawAxis(1), () -> joystick.getRawAxis(4));
  }
}