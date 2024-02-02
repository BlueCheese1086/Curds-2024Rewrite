// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private Command autonomousCommand;
  private Command teleopCommand;

  @Override
  // Runs when the robot is initially started up.
  public void robotInit() {
    RobotContainer robotContainer = new RobotContainer();

    autonomousCommand = robotContainer.getAutonomousCommand();
    teleopCommand = robotContainer.getTeleopCommand();
  }

  @Override
  // Runs repeatedly while the robot is active.
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  // Runs once when the robot enters the autonomous mode.
  public void autonomousInit() {
    autonomousCommand.schedule();
  }

  @Override
  // Runs once when the robot exits the autonomous mode.
  public void autonomousExit() {
    autonomousCommand.cancel();
  }

  @Override
  // Runs once when the robot enters the teleop mode.
  public void teleopInit() {
    teleopCommand.schedule();
  }

  @Override
  // Runs once when the robot exits teleop mode.
  public void teleopExit() {
    teleopCommand.cancel();
  }
}